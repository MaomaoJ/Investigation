package com.investigation.entity;

import java.util.Date;

import com.avos.avoscloud.AVFile;
import com.avos.avoscloud.AVUser;

/**
 * author：qiuchunjia time：下午9:01:32 类描述：这个类是实现User
 *
 */

public class User extends AVUser {
	public void setNickName(String value) {
		put("nickName", value);
	}

	public String getNickName() {
		return getString("nickName");
	}

	// ---------------------------------------------------
	public void setUserName(String value) {
		put("username", value);
	}

	public String getUserName() {
		return getUsername();
	}

	// ---------------------------------------------------
	public void setHeadPortrait(AVFile value) {
		put("headPortrait", value);
	}

	public AVFile getHeadPortrait() {
		return getAVFile("headPortrait");
	}

	// ---------------------------------------------------
	public void setTrueName(String value) {
		put("trueName", value);
	}

	public String getTrueName() {
		return getString("trueName");
	}

	// ---------------------------------------------------
	public void setSex(int value) {
		put("sex", value);
	}

	public int getSex() {
		return getInt("sex");
	}

	// ---------------------------------------------------
	public void setBirthday(Date value) {
		put("birthday", value);
	}

	public Date getBirthday() {
		return getDate("birthday");
	}

	// ---------------------------------------------------
	public void setEmail(String value) {
		put("email", value);
	}

	public String getEmail() {
		return getString("email");
	}

	// ---------------------------------------------------
	public void setAlipayAccount(String value) {
		put("alipayAccount", value);
	}

	public String getAlipayAccount() {
		return getString("alipayAccount");
	}

	// ---------------------------------------------------
	public void setInvitationCode(String value) {
		put("invitationCode", value);
	}

	public String getInvitationCode() {
		return getString("invitationCode");
	}

}
