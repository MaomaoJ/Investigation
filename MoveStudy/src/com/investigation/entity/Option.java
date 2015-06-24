package com.investigation.entity;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;

/**
 * author：qiuchunjia time：下午6:44:01 类描述：这个类是实现Option
 *
 */
@AVClassName("Option")
public class Option extends AVObject {
	// ---------------------------------------------------
	public void setText(String value) {
		put("text", value); 
	}

	public String getText() {
		return getString("text");
	}

	// ---------------------------------------------------
	public void setIsTerminateOption(boolean value) {
		put("isTerminateOption", value);
	}
	

	public boolean getIsOptional() {
		return getBoolean("isTerminateOption");
	}

	// ---------------------------------------------------

}
