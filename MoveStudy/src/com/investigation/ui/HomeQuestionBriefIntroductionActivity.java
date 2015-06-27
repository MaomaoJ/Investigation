package com.investigation.ui;

import java.text.SimpleDateFormat;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.AVRelation;
import com.avos.avoscloud.GetCallback;
import com.example.movestudy.R;
import com.investigation.config.Constants.Home;
import com.investigation.entity.Questionnaire;
import com.investigation.entity.Topic;
import com.investigation.ui.base.BaseActivity;
import com.investigation.utils.ToastUtil;

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
	private Questionnaire mQuestionnaire;
	SimpleDateFormat from = new SimpleDateFormat("yyyy-MM-dd");
	private List<Topic> mTopicList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_question_brief_introduction);
		initView();
		getObjectIdFromActivity();
	}

	private void initView() {
		question_title = (TextView) findViewById(R.id.question_title);
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

	private void getObjectIdFromActivity() {
		Bundle bundle = getIntent().getBundleExtra(Home.home_bundle_ToFragment);
		String objectid = bundle.getString(Home.home_bundle_extra);
		if (objectid != null) {
			getDataFromLeancloud(objectid);
		}
	}

	private void getDataFromLeancloud(String objectid) {
		AVQuery<Questionnaire> avQuery = AVObject.getQuery(Questionnaire.class);
		avQuery.include("topic");
		avQuery.getInBackground(objectid, new GetCallback<Questionnaire>() {

			@Override
			public void done(Questionnaire qnaire, AVException arg1) {
				if (arg1 == null) {
					question_title.setText(qnaire.getQuestionnaireName());
					question_date.setText("发表:"
							+ from.format(qnaire.getEffectiveDate()));
					question_aword.setText("奖励：" + qnaire.getAward() + "積分");
					question_deadline.setText("截止:"
							+ from.format(qnaire.getDeadline()));
					question_Quota.setText("限额：" + qnaire.getQuota() + "份");
					brief_introducion_descont.setText(qnaire.getSummary());
					getTopicFromLeanCloud(qnaire.getTopic());
				} else {

				}
			}
		});
	}

	private void getTopicFromLeanCloud(AVRelation<AVObject> relation) {
		if (relation != null) {

		}

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
