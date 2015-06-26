package com.investigation.biz.imp;

import android.os.Parcel;
import android.os.Parcelable;

import com.investigation.biz.Question;
import com.investigation.config.Constants.Home;
import com.investigation.entity.QuestionItemEntity;

/**
 * author：qiuchunjia time：下午10:18:55 类描述：这个类是实现
 *
 */

public class CheckQuestion extends Question {

	public CheckQuestion() {
		mType = Home.question_content_type_checkbox;
	}


}
