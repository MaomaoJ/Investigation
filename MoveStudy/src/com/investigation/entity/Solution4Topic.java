package com.investigation.entity;

import java.util.ArrayList;

import org.json.JSONArray;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVFile;
import com.avos.avoscloud.AVGeoPoint;
import com.avos.avoscloud.AVObject;

/**
 * author：qiuchunjia time：下午6:44:01 类描述：这个类是实现Solution4Topic
 *
 */
@AVClassName("Solution4Topic")
public class Solution4Topic extends AVObject {
	// ---------------------------------------------------
	public void setUser(User value) {
		put("user", value);
	}

	public String getUser() {
		return getUser();
	}

	// ---------------------------------------------------
	public void setTopic(Topic value) {
		put("topic", value);
	}

	public AVGeoPoint getTopic() {
		return getAVGeoPoint("Topic");
	}

	// ---------------------------------------------------
	public void setOptions(JSONArray value) {
		put("options", value);
	}

	public JSONArray getOptions() {
		return getJSONArray("options");
	}

	// ---------------------------------------------------
	public void setText(String value) {
		put("text", value);
	}

	public String getText() {
		return getString("text");
	}

	// ---------------------------------------------------
	public void setImage(AVFile value) {
		put("image", value);
	}

	public AVFile getImage() {
		return getAVFile("image");
	}

	// ---------------------------------------------------

}
