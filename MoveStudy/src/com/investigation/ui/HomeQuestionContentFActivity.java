package com.investigation.ui;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ScrollView;

import com.example.movestudy.R;
import com.investigation.biz.Question;
import com.investigation.config.Constants.Home;
import com.investigation.utils.QuestionFactory;
import com.investigation.view.HomeQuestionContentFragment;

/**
 * author：qiuchunjia time：下午8:46:25 类描述：这个类是实现
 *
 */

public class HomeQuestionContentFActivity extends FragmentActivity implements
		OnClickListener {
	private ScrollView mScollView;
	private Button mBtnNext;
	private HomeQuestionContentFragment mFragment;
	List<Question> mQuestions = new ArrayList<Question>();
	private int mPivot = 0;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.home_question_content);
		initView();
		getData();// 获取数据
		addDataToFragment(mQuestions.get(mPivot));
		setFragment();
	}

	private void initView() {
		mScollView = (ScrollView) findViewById(R.id.question_content_scrollView);
		mBtnNext = (Button) findViewById(R.id.question_content_btn_next);
		mBtnNext.setOnClickListener(this);
	}

	// 把数据发送到fragment中去
	private void addDataToFragment(Question question) {
		mFragment = new HomeQuestionContentFragment();
		Bundle bundle = new Bundle();
		bundle.putParcelable(Home.home_bundle_ToFragment, question);
		mFragment.setArguments(bundle);
	}

	private void setFragment() {
		getSupportFragmentManager().beginTransaction()
				.add(R.id.question_content_scrollView, mFragment).commit();
	}

	private String[] getQuestion() {
		return new String[] { "张三", "李四", "王五", "呵呵", "嘻嘻" };
	}

	// 模拟数据
	private void getData() {
		Question question = QuestionFactory
				.createQuestion(Home.question_content_type_radio);
		question.setTitle("1:你的名字是？");
		question.setData(new String[] { "张三", "李四", "王五", "呵呵", "嘻嘻" });
		mQuestions.add(question);
		Question question1 = QuestionFactory
				.createQuestion(Home.question_content_type_checkbox);
		question1.setTitle("2:你的名字是？");
		question1.setData(new String[] { "张三", "李四", "王五", "呵呵", "嘻嘻" });
		mQuestions.add(question1);
		Question question2 = QuestionFactory
				.createQuestion(Home.question_content_type_anwer);
		question2.setTitle("3:请输入你的名字");
		mQuestions.add(question2);
		Question question3 = QuestionFactory
				.createQuestion(Home.question_content_type_photo);
		question3.setTitle("4:请留下你自拍");
		mQuestions.add(question3);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.question_content_btn_next:
			// TODO 以后实现获取答题结果
			getResponse();
			mPivot++;
			if (mPivot < mQuestions.size()) {
				// 实现销毁fragment，从新添加fragment
				addDataToFragment(mQuestions.get(mPivot));
				getSupportFragmentManager().beginTransaction()
						.replace(R.id.question_content_scrollView, mFragment)
						.commit();
				if (mPivot == mQuestions.size() - 1) {
					mBtnNext.setText(R.string.question_content_commit);
				}
			} else {
				// TODO 开线程上传回到的结果，然后關閉這個頁面
				finish();
			}

			break;

		default:
			break;
		}

	}

	private void getResponse() {

	}

}
