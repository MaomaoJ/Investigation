package com.investigation.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author qcj
 *
 */
public class QuestionItemEntity implements Parcelable {
	private String question_title;
	private String question_date;
	private String question_aword;
	private String question_deadline;
	private String question_Quota;
	private String question_limit;

	public String getQuestion_title() {
		return question_title;
	}

	public void setQuestion_title(String question_title) {
		this.question_title = question_title;
	}

	public String getQuestion_date() {
		return question_date;
	}

	public void setQuestion_date(String question_date) {
		this.question_date = question_date;
	}

	public String getQuestion_aword() {
		return question_aword;
	}

	public void setQuestion_aword(String question_aword) {
		this.question_aword = question_aword;
	}

	public String getQuestion_deadline() {
		return question_deadline;
	}

	public void setQuestion_deadline(String question_deadline) {
		this.question_deadline = question_deadline;
	}

	public String getQuestion_Quota() {
		return question_Quota;
	}

	public void setQuestion_Quota(String question_Quota) {
		this.question_Quota = question_Quota;
	}

	public String getQuestion_limit() {
		return question_limit;
	}

	public void setQuestion_limit(String question_limit) {
		this.question_limit = question_limit;
	}

	// 实现的接口
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(question_title);
		dest.writeString(question_date);
		dest.writeString(question_aword);
		dest.writeString(question_deadline);
		dest.writeString(question_Quota);
		dest.writeString(question_limit);

	}

	public static final Parcelable.Creator<QuestionItemEntity> CREATOR = new Parcelable.Creator<QuestionItemEntity>() {
		public QuestionItemEntity createFromParcel(Parcel in) {
			QuestionItemEntity entity = new QuestionItemEntity();
			entity.question_title = in.readString();
			entity.question_date = in.readString();
			entity.question_aword = in.readString();
			entity.question_deadline = in.readString();
			entity.question_Quota = in.readString();
			entity.question_limit = in.readString();
			return entity;
		}

		public QuestionItemEntity[] newArray(int size) {
			return new QuestionItemEntity[size];
		}
	};

}
