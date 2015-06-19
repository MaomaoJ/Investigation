package com.investigation.baseAdapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.movestudy.R;
import com.investigation.entity.QuestionItemEntity;

/**
 * author：qiuchunjia time：下午2:37:48 类描述：这个类是实现listView item的展示
 *
 */

public class QuestionItemAdapter extends BaseAdapter {
	private Context mContext;
	private List<QuestionItemEntity> mList;
	LayoutInflater mInflater;

	public QuestionItemAdapter(Context context, List<QuestionItemEntity> list) {
		this.mContext = context;
		this.mList = list;
		mInflater = LayoutInflater.from(mContext);
	}

	@Override
	public int getCount() {
		return mList.size();
	}

	@Override
	public Object getItem(int position) {
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Viewholder holder = new Viewholder();
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.home_question_item, null,
					false);
			holder.question_title = (TextView) convertView
					.findViewById(R.id.question_title);
			holder.question_date = (TextView) convertView
					.findViewById(R.id.question_date);
			holder.question_aword = (TextView) convertView
					.findViewById(R.id.question_aword);
			holder.question_deadline = (TextView) convertView
					.findViewById(R.id.question_deadline);
			holder.question_Quota = (TextView) convertView
					.findViewById(R.id.question_Quota);
			holder.question_limit = (TextView) convertView
					.findViewById(R.id.question_limit);
			convertView.setTag(holder);
		} else {
			holder = (Viewholder) convertView.getTag();
		}
		QuestionItemEntity entity = mList.get(position);
		// 设置holder
		holder.question_title.setText(entity.getQuestion_title());
		holder.question_date.setText(entity.getQuestion_date());
		holder.question_aword.setText(entity.getQuestion_aword());
		holder.question_deadline.setText(entity.getQuestion_deadline());
		holder.question_Quota.setText(entity.getQuestion_Quota());
		holder.question_limit.setText(entity.getQuestion_limit());
		return convertView;
	}

	private class Viewholder {
		TextView question_title;
		TextView question_date;
		TextView question_aword;
		TextView question_deadline;
		TextView question_Quota;
		TextView question_limit;
	}

}
