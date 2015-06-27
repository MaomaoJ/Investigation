package com.investigation.view;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.FindCallback;
import com.example.movestudy.R;
import com.investigation.baseAdapter.ImageAdapter;
import com.investigation.baseAdapter.QuestionItemAdapter;
import com.investigation.baseAdapter.TmlsBasePageAdapter;
import com.investigation.config.Constants.Home;
import com.investigation.entity.QuestionItemEntity;
import com.investigation.entity.Questionnaire;
import com.investigation.slidingmenu.SlidingActivityHelper;
import com.investigation.ui.HomeQuestionActivity;
import com.investigation.ui.HomeQuestionBriefIntroductionActivity;
import com.investigation.widget.CircleFlowIndicator;
import com.investigation.widget.ViewFlow;
import com.investigation.widget.XListView;
import com.investigation.widget.XListView.IXListViewListener;

/**
 * @author qcj
 *
 */
/**
 * @author Administrator
 *
 */
/**
 * @author Administrator
 *
 */
@SuppressLint("ValidFragment")
public class HomePageFragment extends Fragment implements OnClickListener {

	private Activity myActivity;
	private TmlsBasePageAdapter myAdapter;
	private SlidingActivityHelper mHelper;
	// -----------------------------------------------------------
	private ViewFlow mhome_viewflow;
	private CircleFlowIndicator mhome_viewflowindicator;
	private TextView mhome_iv_title;
	private TextView mhome_iv_more;
	private XListView mListView;
	private QuestionItemAdapter mAdapter;

	private View mView;

	@SuppressLint("ValidFragment")
	public HomePageFragment(Activity activity,
			TmlsBasePageAdapter studyBasePageAdapter,
			SlidingActivityHelper mHelper) {
		myActivity = activity;
		myAdapter = studyBasePageAdapter;
		this.mHelper = mHelper;

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mView = inflater.inflate(R.layout.home, null);
		ImageView tohomeButton = (ImageView) mView
				.findViewById(R.id.Linear_above_toHome);
		tohomeButton.setOnClickListener(this);
		TextView tv_above_title = (TextView) mView
				.findViewById(R.id.tv_above_title);
		tv_above_title.setText("首页");
		return mView;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		initView();
		setAds();
		getDataFromLeanCloud();
	}

	// 处理异步获取的数据
	private Handler mHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			List<Questionnaire> list = (List<Questionnaire>) msg.obj;
			if (list.size() > 0) {
				mAdapter = new QuestionItemAdapter(myActivity, list);
				mListView.setAdapter(mAdapter);
			}
			onStopLoad();
		};
	};

	// 初始化各个控件
	private void initView() {
		mhome_viewflow = (ViewFlow) mView.findViewById(R.id.home_viewflow);
		mhome_viewflowindicator = (CircleFlowIndicator) mView
				.findViewById(R.id.home_viewflowindicator);
		mhome_iv_title = (TextView) mView.findViewById(R.id.home_iv_title);
		mhome_iv_more = (TextView) mView.findViewById(R.id.home_iv_more);
		mListView = (XListView) mView.findViewById(R.id.home_listview);
		mhome_iv_more.setOnClickListener(this);
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
	}

	private void onStopLoad() {
		mListView.stopRefresh();
		mListView.stopLoadMore();
		mListView.setRefreshTime("刚刚");
	}

	// // 添加数据
	// private void addData() {
	// mListView.setAdapter(mAdapter);
	// mListView.setOnItemClickListener(new OnItemClickListener() {
	//
	// @Override
	// public void onItemClick(AdapterView<?> parent, View view,
	// int position, long id) {
	// Intent intent = new Intent(getActivity(),
	// HomeQuestionBriefIntroductionActivity.class);
	// startActivity(intent);
	//
	// }
	// });
	// }

	// // 获取显示数据 添加虚拟数据 以后在这里添加网络数据
	//
	// public ArrayList<QuestionItemEntity> getData() {
	// ArrayList<QuestionItemEntity> list = new ArrayList<QuestionItemEntity>();
	// for (int i = 0; i < 9; i++) {
	// QuestionItemEntity entity = new QuestionItemEntity();
	// entity.setQuestion_title("教育调查" + i);
	// entity.setQuestion_aword("奖励：0.5元");
	// entity.setQuestion_date("2014....");
	// entity.setQuestion_deadline("截止：不限");
	// entity.setQuestion_limit("不限");
	// entity.setQuestion_Quota("限额：不限");
	// list.add(entity);
	// }
	// return list;
	// }

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

	// 设置广告自动浮动
	private void setAds() {
		mhome_viewflow.setAdapter(new ImageAdapter(getActivity()));
		mhome_viewflow.setFlowIndicator(mhome_viewflowindicator);
		mhome_viewflow.setTimeSpan(1000 * 3);
		mhome_viewflow.startAutoFlowTimer();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.home_iv_more:
			Intent intent = new Intent(myActivity, HomeQuestionActivity.class);
			startActivity(intent);
			break;
		case R.id.Linear_above_toHome:// 监听above_title中的控件
			mHelper.showMenu();// 调出菜单栏
			break;
		}
	}
}
