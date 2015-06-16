package com.investigation.biz;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;

import com.investigation.entity.AShoppingResponseEntity;
import com.investigation.entity.AccountResponseEntity;
import com.investigation.entity.CategorysEntity;

public class AShoppingDao extends BaseDao{
	
	private AShoppingResponseEntity aShoppingRespose;
	List<CategorysEntity> tabs = new ArrayList<CategorysEntity>();
	
	public AShoppingResponseEntity getStudyRespose() {
		return aShoppingRespose;
	}
	
	public void setStudyRespose(AShoppingResponseEntity aShoppingRespose) {
		this.aShoppingRespose = aShoppingRespose;
	}

	public AShoppingDao(Activity mActivity){
		super(mActivity);
		
	}
	//��ȡ���
	public AShoppingResponseEntity mapperJson(boolean useCache) {
		// TODO Auto-generated method stub

		
		//��������
		aShoppingRespose = new AShoppingResponseEntity();
		
	return aShoppingRespose;

	}
	
	public List<CategorysEntity> getCategorys() {
		CategorysEntity cate1 = new CategorysEntity();
		cate1.setName("ѡ��Ҫ�����ģ��");
		tabs.add(cate1);
		return tabs;
	}
}
