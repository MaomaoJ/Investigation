package com.investigation.biz.imp;

import android.provider.SyncStateContract.Constants;
import android.widget.RadioButton;

import com.investigation.biz.Question;
import com.investigation.config.Constants.Home;

/**
 * author：qiuchunjia time：下午10:18:55 类描述：这个类是实现
 *
 */

public class RadioQuestion extends Question {
	public RadioQuestion() {
		mType = Home.question_content_type_radio;
	}

}
