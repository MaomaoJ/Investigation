package com.investigation.biz;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;

import com.investigation.entity.AccountResponseEntity;
import com.investigation.entity.CategorysEntity;
import com.investigation.entity.HomeResponseEntity;

public class AccountDao extends BaseDao{
	
	private AccountResponseEntity accountRespose;
	List<CategorysEntity> tabs = new ArrayList<CategorysEntity>();
	
	public AccountResponseEntity getStudyRespose() {
		return accountRespose;
	}
	
	public void setStudyRespose(AccountResponseEntity accountRespose) {
		this.accountRespose = accountRespose;
	}

	public AccountDao(Activity mActivity){
		super(mActivity);
		
	}
	//��ȡ���
	public AccountResponseEntity mapperJson(boolean useCache) {
		// TODO Auto-generated method stub

		
		//��������
		accountRespose = new AccountResponseEntity();
		
	return accountRespose;

	}
	
	public List<CategorysEntity> getCategorys() {
		CategorysEntity cate1 = new CategorysEntity();
		cate1.setName("ѡ��Ҫ�����ģ��");
		tabs.add(cate1);
		return tabs;
	}
}
