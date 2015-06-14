package com.investigation.entity.base;
import java.util.List;

import com.investigation.entity.CategorysEntity;



/**
 * ���صĴ��json�ķ�װ ����
 * @author maojie
 *
 */
public abstract class BaseResponseData {
	 
	private long date;				//创建时间
	private List<CategorysEntity> categorys;	//分类
	public long getDate() {
		return date;
	}
	public void setDate(long date) {
		this.date = date;
	}
	public List<CategorysEntity> getCategorys() {
		return categorys;
	}
	public void setCategorys(List<CategorysEntity> categorys) {
		this.categorys = categorys;
	}
	

}
