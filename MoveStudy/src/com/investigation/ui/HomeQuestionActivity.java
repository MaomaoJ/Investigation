package com.investigation.ui;

import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.FindCallback;
import com.example.movestudy.R;
import com.investigation.baseAdapter.QuestionItemAdapter;
import com.investigation.config.Constants.Home;
import com.investigation.entity.QuestionItemEntity;
import com.investigation.entity.Questionnaire;
import com.investigation.ui.base.BaseActivity;
import com.investigation.widget.XListView;
import com.investigation.widget.XListView.IXListViewListener;

/**
 * author：qiuchunjia time：下午3:14:38 类描述：这个类是实现
 *
 */

public class HomeQuestionActivity extends BaseActivity {
	private XListView mListView;
	private QuestionItemAdapter mAdapter;
	private List<Questionnaire> mlist;
	// 处理异步获取的数据
	private Handler mHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			List<Questionnaire> list = (List<Questionnaire>) msg.obj;
			if (list.size() > 0) {
				mAdapter = new QuestionItemAdapter(getApplicationContext(),
						list);
				mlist = list;
				mListView.setAdapter(mAdapter);
			}
			onStopLoad();
		};
	};

	private void onStopLoad() {
		mListView.stopRefresh();
		mListView.stopLoadMore();
		mListView.setRefreshTime("刚刚");
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_question);
		initView();
		getDataFromLeanCloud();
	}

	private void initView() {
		mListView = (XListView) findViewById(R.id.home_question_lv);
		mListView.setDividerHeight(0);
		mListView.setPullLoadEnable(false);
		mListView.setPullRefreshEnable(true);
		mListView.setXListViewListener(new IXListViewListener() {

			@Override
			public void onRefresh() {
				getDataFromLeanCloud();
			}

			@Override
			public void onLoadMore() {

			}
		});
		mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				if (mlist.size() > 0) {
					Questionnaire questionnaire = mlist.get(position - 1);
					Bundle bundle = new Bundle();
					bundle.putString(Home.home_bundle_extra,
							questionnaire.getObjectId());
					Intent intent = new Intent(getApplicationContext(),
							HomeQuestionBriefIntroductionActivity.class);
					intent.putExtra(Home.home_bundle_ToFragment, bundle);
					startActivity(intent);
				}

			}
		});

	}

	private void getDataFromLeanCloud() {
		AVQuery<Questionnaire> avQuery = AVObject.getQuery(Questionnaire.class);
		avQuery.findInBackground(new FindCallback<Questionnaire>() {

			@Override
			public void done(List<Questionnaire> list, AVException arg1) {
				if (arg1 == null) {
					// 传送数据
					Message message = Message.obtain();
					message.obj = list;
					mHandler.sendMessage(message);
				} else {

				}
			}
		});
	}

}
