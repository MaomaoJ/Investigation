package com.investigation.utils;

import android.provider.SyncStateContract.Constants;

import com.investigation.biz.Question;
import com.investigation.biz.imp.CheckQuestion;
import com.investigation.biz.imp.EditQuestion;
import com.investigation.biz.imp.PhotoQuestion;
import com.investigation.biz.imp.RadioQuestion;
import com.investigation.config.Constants.Home;

/**
 * author：qiuchunjia time：上午10:24:11 类描述：这个类是实现
 *
 */

public class QuestionFactory {
	public static Question createQuestion(int type) {
		Question question = null;
		switch (type) {
		case Home.question_content_type_radio:
			question = new RadioQuestion();
			break;

		case Home.question_content_type_checkbox:
			question = new CheckQuestion();
			break;
		case Home.question_content_type_anwer:
			question = new EditQuestion();
			break;
		case Home.question_content_type_photo:
			question = new PhotoQuestion();
			break;
		}
		return question;

	}

}
