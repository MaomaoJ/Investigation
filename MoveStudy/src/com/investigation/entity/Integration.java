package com.investigation.entity;

import java.util.Date;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVGeoPoint;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVRelation;

/**
 * author：qiuchunjia time：下午6:44:01 类描述：这个类是实现Integration
 *
 */
@AVClassName("Integration")
public class Integration extends AVObject {
	// ---------------------------------------------------
	public void setUser(User value) {
		put("user", value);
	}

	public String getUser() {
		return getUser();
	}

	// ---------------------------------------------------
	public void setCount(int value) {
		put("count", value);
	}

	public int getCount() {
		return getInt("count");
	}

	// ---------------------------------------------------
	public void setReason(String value) {
		put("reason", value);
	}

	public String getReason() {
		return getString("reason");
	}

	// ---------------------------------------------------
	public void setDate(Date value) {
		put("date", value);
	}

	public Date getDate() {
		return getDate("date");
	}

}
