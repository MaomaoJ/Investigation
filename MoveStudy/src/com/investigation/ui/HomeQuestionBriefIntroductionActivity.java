package com.investigation.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.example.movestudy.R;
import com.investigation.ui.base.BaseActivity;

/**
 * author：qiuchunjia time：下午4:41:06 类描述：这个类是实现
 *
 */

public class HomeQuestionBriefIntroductionActivity extends BaseActivity
		implements OnClickListener {
	TextView question_title;
	TextView question_date;
	TextView question_aword;
	TextView question_deadline;
	TextView question_Quota;
	TextView question_total;
	TextView brief_introducion_des;
	TextView brief_introducion_descont;
	Button mBrief_introducion_startanwer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_question_brief_introduction);
		initView();
	}

	private void initView() {
		question_title = (TextView) findViewById(R.id.question_limit);
		question_total = (TextView) findViewById(R.id.question_total);
		question_aword = (TextView) findViewById(R.id.question_aword);
		question_date = (TextView) findViewById(R.id.question_date);
		question_Quota = (TextView) findViewById(R.id.question_Quota);
		question_deadline = (TextView) findViewById(R.id.question_deadline);
		brief_introducion_des = (TextView) findViewById(R.id.brief_introducion_des);
		brief_introducion_descont = (TextView) findViewById(R.id.brief_introducion_descont);
		mBrief_introducion_startanwer = (Button) findViewById(R.id.brief_introducion_startanwer);
		mBrief_introducion_startanwer.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.brief_introducion_startanwer:
			Intent intent = new Intent(getApplicationContext(),
					HomeQuestionContentFActivity.class);
			startActivity(intent);

			break;

		default:
			break;
		}
	}
}
