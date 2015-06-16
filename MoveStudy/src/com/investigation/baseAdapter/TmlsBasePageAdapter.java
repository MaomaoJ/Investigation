package com.investigation.baseAdapter;

import java.util.ArrayList;
import java.util.List;










import com.investigation.entity.AShoppingResponseEntity;
import com.investigation.entity.AccountResponseEntity;
import com.investigation.entity.CategorysEntity;
import com.investigation.entity.HomeResponseEntity;
import com.investigation.entity.base.BaseResponseData;
import com.investigation.slidingmenu.SlidingActivityHelper;
import com.investigation.ui.Vote_MainActivity.MyTask;
import com.investigation.view.Accumulated_Shopping_Fragment;
import com.investigation.view.HomePageFragment;
import com.investigation.view.My_Account_Fragment;

import android.R.integer;
import android.app.Activity;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;


/*
 * ��viewpager�з���fragment
 */

public class TmlsBasePageAdapter extends FragmentStatePagerAdapter {
	
//��viewpager�������fragment
	private MyTask myTask;
	Handler myHandler ;
	public ArrayList<Fragment> mFragments = new ArrayList<Fragment>();;
	public List<CategorysEntity> tabs = new ArrayList<CategorysEntity>();
	SlidingActivityHelper mHelper;
	//public StudyDao myStudyDao;
	//public StudyResponseEntity myrespResponseEntity;

	private Activity mActivity;

	public TmlsBasePageAdapter(FragmentActivity activity,MyTask myTask,Handler myHandler,SlidingActivityHelper mHelper) {
		super(activity.getSupportFragmentManager());
		this.myTask = myTask;
		this.mActivity = activity;
		this.myHandler = myHandler;
		this.mHelper = mHelper;
	}

	/**
	 * ������listview�ּ��� tabs
	 * @param listObject
	 */
	public void addFragment(List<CategorysEntity> mList, BaseResponseData baseResponseData) {
	
		if(baseResponseData instanceof HomeResponseEntity){
			tabs = mList;
			addTab(new HomePageFragment(mActivity,this,mHelper));
		}
		else if(baseResponseData instanceof AccountResponseEntity){
			tabs = mList;
			addTab(new My_Account_Fragment(mActivity,this,mHelper));
		}
		else if(baseResponseData instanceof AShoppingResponseEntity){
			tabs = mList;
			addTab(new Accumulated_Shopping_Fragment(mActivity,this,mHelper));
		}
		}

	/**
	 * ֻ����listview���� tabs
	 * @param listObject
	 */
	public void addFragment( List<Object> listObject) {


	}

	public void addNullFragment() {
		CategorysEntity cate = new CategorysEntity();
		cate.setName("���Ӵ���");
		tabs.add(cate);
		//addTab(new HttpErrorFragment());
	}

	//���fragment���
	public void Clear() {
		mFragments.clear();
		tabs.clear();
	}

	public void addTab(Fragment fragment) {
		mFragments.add(fragment);
		notifyDataSetChanged();
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return tabs.get(position).getName();
	}

	@Override
	public Fragment getItem(int arg0) {
		return mFragments.get(arg0);
	}

	@Override
	public int getCount() {
		return mFragments.size();
	}

	@Override
	public int getItemPosition(Object object) {
		return POSITION_NONE;
	}

	//

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		// TODO Auto-generated method stub
		super.destroyItem(container, position, object);
	}
}
