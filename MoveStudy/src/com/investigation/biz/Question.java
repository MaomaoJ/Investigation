package com.investigation.biz;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * author：qiuchunjia time：下午10:10:38 类描述：这个类是声明问题卷的超類
 *
 */

public class Question implements Parcelable {
	public int mType = -1;
	public String mTitle;
	public String[] mContent;

	public void setTitle(String str) {
		this.mTitle = str;
	}

	// 设置数据
	public void setData(String[] str) {
		mContent = str;
	}

	// 获取类型
	public int getType() {
		return mType;
	}

	public String getTitle() {
		return mTitle;
	}

	// 获取内容
	public String[] getData() {
		return mContent;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(mType);
		dest.writeString(mTitle);
		dest.writeStringArray(mContent);
	}

	public static final Parcelable.Creator<Question> CREATOR = new Parcelable.Creator<Question>() {
		public Question createFromParcel(Parcel in) {
			Question entity = new Question();
			entity.mType = in.readInt();
			entity.mTitle = in.readString();
			entity.mContent = in.createStringArray();
			return entity;
		}

		public Question[] newArray(int size) {
			return new Question[size];
		}
	};
}
