package com.investigation.biz;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;

import com.investigation.entity.CategorysEntity;
import com.investigation.entity.HomeResponseEntity;

/**
 * ���ã�������������ѧϰ��������Ӧ�÷ŵ����ݡ�
 * @return
 */
public class HomeDao extends BaseDao{
	
	private HomeResponseEntity homeRespose;
	List<CategorysEntity> tabs = new ArrayList<CategorysEntity>();
	
	public HomeResponseEntity getStudyRespose() {
		return homeRespose;
	}
	
	public void setStudyRespose(HomeResponseEntity homeRespose) {
		this.homeRespose = homeRespose;
	}

	public HomeDao(Activity mActivity){
		super(mActivity);
		
	}
	//��ȡ���
	public HomeResponseEntity mapperJson(boolean useCache) {
		// TODO Auto-generated method stub

		
		//��������
		homeRespose = new HomeResponseEntity();
		
	return homeRespose;

	}
	
	public List<CategorysEntity> getCategorys() {
		CategorysEntity cate1 = new CategorysEntity();
		cate1.setName("ѡ��Ҫ�����ģ��");
		tabs.add(cate1);
		return tabs;
	}
}