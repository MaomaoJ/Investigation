package com.yitong.biz;

import org.codehaus.jackson.map.ObjectMapper;

import android.app.Activity;

public  class BaseDao {
	/**
	 * 作用：dao的基础类
	 */
	ObjectMapper mObjectMapper = new ObjectMapper();

	protected Activity mActivity;
	
	public BaseDao(){};
	
	public BaseDao(Activity activity)
	{
		mActivity=activity;
	}

	
}
