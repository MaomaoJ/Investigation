package com.investigation.entity;

import java.util.Date;

import android.os.Parcel;
import android.os.Parcelable;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVRelation;

/**
 * author：qiuchunjia time：下午6:44:01 类描述：这个类是实现Questionnaire
 *
 */
@AVClassName("Questionnaire")
public class Questionnaire extends AVObject {

	public void setQuestionnaireName(String value) {
		put("questionnaireName", value);
	}

	public void setQuota(int value) {
		put("quota", value);
	}

	public void setEffectiveDate(Date value) {
		put("effectiveDate", value);
	}

	public void setDeadline(Date value) {
		put("deadline", value);
	}

	public void setAward(int value) {
		put("award", value);
	}

	public void setSummary(String value) {
		put("summary", value);
	}

	public void setTopic(AVRelation<AVObject> value) {
		put("topic", value);
	}

	public void setOrder(int value) {
		put("order", value);
	}

	// ---------------------------------------------------
	public String getQuestionnaireName() {
		return getString("questionnaireName");
	}

	public int getQuota() {
		return getInt("quota");
	}

	public Date getEffectiveDate() {
		return getDate("effectiveDate");
	}

	public Date getDeadline() {
		return getDate("deadline");
	}

	public int getAward() {
		return getInt("award");
	}

	public String getSummary() {
		return getString("summary");
	}

	public AVRelation<AVObject> getTopic() {
		return getRelation("topic");
	}

	public int getOrder() {
		return getInt("order");
	}

}
