package com.investigation.entity;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVRelation;

/**
 * author：qiuchunjia time：下午6:44:01 类描述：这个类是实现Topic
 *
 */
@AVClassName("Topic")
public class Topic extends AVObject {

	public void setSubject(String value) {
		put("subject", value);
	}

	public void setIsOptional(boolean value) {
		put("isOptional", value);
	}

	public void setSubjectType(int value) {
		put("subjectType", value);
	}

	public void setOptions(AVRelation<AVObject> value) {
		put("options", value);
	}

	public void setOrder(int value) {
		put("order", value);
	}

	// ---------------------------------------------------
	public String getSubject() {
		return getString("subject");
	}

	public boolean getIsOptional() {
		return getBoolean("isOptional");
	}

	public int getSubjectType() {
		return getInt("subjectType");
	}

	public AVRelation<AVObject> getOptions() {
		return getRelation("options");
	}

	public int getOrder() {
		return getInt("order");
	}

}
