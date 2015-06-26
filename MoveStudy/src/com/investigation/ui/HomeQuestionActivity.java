package com.investigation.ui;

import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.example.movestudy.R;
import com.investigation.baseAdapter.QuestionItemAdapter;
import com.investigation.config.Constants.Home;
import com.investigation.entity.QuestionItemEntity;
import com.investigation.ui.base.BaseActivity;

/**
 * author：qiuchunjia time：下午3:14:38 类描述：这个类是实现
 *
 */

public class HomeQuestionActivity extends BaseActivity {
	private List<QuestionItemEntity> mQuestion;
	private ListView mListView;
	private QuestionItemAdapter mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_question);
		getDataFromActivity();
		initView();
		addData();
	}

	private void getDataFromActivity() {
		Bundle bundle = getIntent().getBundleExtra(Home.home_intent);
		mQuestion = bundle.getParcelableArrayList(Home.home_bundle_extra);
	}

	private void initView() {
		mListView = (ListView) findViewById(R.id.home_question_lv);
		mAdapter = new QuestionItemAdapter(getApplicationContext(), mQuestion);
		mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent = new Intent(getApplicationContext(),
						HomeQuestionBriefIntroductionActivity.class);
				startActivity(intent);

			}
		});

	}

	// 添加数据
	private void addData() {
		mListView.setAdapter(mAdapter);
	}

}
