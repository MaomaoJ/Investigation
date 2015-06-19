package com.investigation.biz.imp;

import com.investigation.biz.Question;
import com.investigation.config.Constants.Home;

/**
 * author：qiuchunjia time：下午10:18:55 类描述：这个类是实现
 *
 */

public class PhotoQuestion extends Question {

	public PhotoQuestion() {
		mType = Home.question_content_type_photo;
	}
}
