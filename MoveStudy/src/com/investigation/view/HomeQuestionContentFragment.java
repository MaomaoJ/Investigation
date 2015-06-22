package com.investigation.view;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.movestudy.R;
import com.investigation.biz.Question;
import com.investigation.config.Constants.Home;
import com.investigation.utils.ToastUtil;

/**
 * author：qiuchunjia time：下午8:32:05 类描述：这个类是实现
 *
 */

public class HomeQuestionContentFragment extends Fragment {
	private View mView;
	private TextView mTitle;
	private LinearLayout mFragmentll;
	private Question mQuestion;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mView = inflater.inflate(R.layout.home_question_content_fragment, null);
		return mView;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		initView();
		bindDatatoView(mQuestion);
	}

	private void bindDatatoView(Question question) {
		mTitle.setText(question.getTitle());
		switch (question.mType) {
		case Home.question_content_type_radio:
			createRadioButton(mQuestion.mContent);
			break;

		case Home.question_content_type_checkbox:
			ToastUtil.toast(getActivity(), "到了复选框了");
			createCheckButton(mQuestion.mContent);
			break;
		case Home.question_content_type_anwer:
			createCheckButton();
			break;
		case Home.question_content_type_photo:
			createPhotoButon();
			break;
		}
	}

	private void addViewToView(View view) {
		mFragmentll.addView(view);
	}

	private void initView() {
		Bundle bundle = getArguments();
		mTitle = (TextView) mView.findViewById(R.id.fragment_tv);
		mFragmentll = (LinearLayout) mView.findViewById(R.id.fragment_ll);
		mQuestion = bundle.getParcelable(Home.home_bundle_ToFragment);
	}

	// 创建单选框按鈕
	public void createRadioButton(String[] array) {
		RadioGroup group = new RadioGroup(getActivity());
		for (int i = 0; i < array.length; i++) {
			RadioButton radio = new RadioButton(getActivity());
			radio.setText(array[i]);
			group.addView(radio);
		}
		addViewToView(group);
	}

	// 创建復選框按鈕
	public void createCheckButton(String[] array) {
		for (int i = 0; i < array.length; i++) {
			CheckBox radio = new CheckBox(getActivity());
			radio.setText(array[i]);
			mFragmentll.addView(radio);
		}
	}

	// 创建输入框
	public void createCheckButton() {
		EditText editText = new EditText(getActivity());
		addViewToView(editText);
	}

	// 创建拍照按钮以及拍照后把照片显示到上面
	public void createPhotoButon() {
		RelativeLayout layout = (RelativeLayout) mView
				.findViewById(R.id.fragment_rl);
		layout.setVisibility(View.VISIBLE);
	}
}
