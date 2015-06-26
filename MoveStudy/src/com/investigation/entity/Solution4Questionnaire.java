package com.investigation.entity;

import java.util.Date;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVGeoPoint;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVRelation;

/**
 * author：qiuchunjia time：下午6:44:01 类描述：这个类是实现Solution4Questionnaire
 *
 */
@AVClassName("Solution4Questionnaire")
public class Solution4Questionnaire extends AVObject {
	// ---------------------------------------------------
	public void setUser(User value) {
		put("user", value);
	}

	public String getUser() {
		return getUser();
	}

	// ---------------------------------------------------
	public void setQusetionnaire(Questionnaire value) {
		put("questionnaire", value);
	}

	public AVGeoPoint getQusetionnaire() {
		return getAVGeoPoint("questionnaire");
	}

	// ---------------------------------------------------
	public void setSolutions(AVGeoPoint value) {
		put("solutions", value);
	}

	public AVGeoPoint getSubjectType() {
		return getAVGeoPoint("solutions");
	}

	// ---------------------------------------------------
	public void setIsComplete(boolean value) {
		put("isComplete", value);
	}

	public boolean getIsComplete() {
		return getBoolean("isComplete");
	}

}
