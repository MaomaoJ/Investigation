package com.investigation.biz;

import org.codehaus.jackson.map.ObjectMapper;

import android.app.Activity;

public  class BaseDao {
	/**
	 * ���ã�dao�Ļ���
	 */
	ObjectMapper mObjectMapper = new ObjectMapper();

	protected Activity mActivity;
	
	public BaseDao(){};
	
	public BaseDao(Activity activity)
	{
		mActivity=activity;
	}

	
}
