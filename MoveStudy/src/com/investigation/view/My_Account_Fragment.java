package com.investigation.view;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.movestudy.R;
import com.investigation.baseAdapter.TmlsBasePageAdapter;
import com.investigation.entity.AccountListItemEntity;
import com.investigation.slidingmenu.SlidingActivityHelper;

@SuppressLint("ValidFragment")
public class My_Account_Fragment extends Fragment implements OnClickListener
{

	
	private String tag = "0";
	
	
	Activity myActivity;
	
	TmlsBasePageAdapter myAdapter;
	
	//private ImageView imgQuery;
    //private ImageView imgMore;
	private ImageView llGoHome;
	
	ListView listView;
	
	SlidingActivityHelper mHelper;
	TextView mAboveTitle;
	  

	public My_Account_Fragment(Activity activity,TmlsBasePageAdapter studyBasePageAdapter,SlidingActivityHelper mHelper){
		myActivity = activity;
		myAdapter = studyBasePageAdapter;
	    this.mHelper = mHelper;
		
	
	} 
	
	
	
	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		//webview = (WebView) getView().findViewById(R.id.webview);
	}
	//一个fragment里面至少要继承这些方法
		@Override
		public void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			//当创建fragment时, 系统调用该方法. 
			//在实现代码中,应当初始化想要在fragment中保持的必要组件, 当fragment被暂停或者停止后可以恢复.
			
			super.onCreate(savedInstanceState);
		}

		@Override
		public void onDestroy() {
			// TODO Auto-generated method stub
			super.onDestroy();
		}

		@Override
		public void onPause() {
			// TODO Auto-generated method stub
			//用户将要离开fragment时,系统调用这个方法作为第一个指示(然而它不总是意味着fragment将被销毁.) ---
			//在当前用户会话结束之前,通常应当在这里提交任何应该持久化的变化(因为用户有可能不会返回).
			super.onPause();
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
					
			//fragment第一次绘制它的用户界面的时候, 系统会调用此方法. 为了绘制fragment的UI,此方法必须返回一个View,-----
			// 这个view是你的fragment布局的根view. 如果fragment不提供UI, 可以返回null.
			// 填充一个布局View到ViewGrope中
			
			 View view = (View)inflater.inflate(R.layout.menu_fragment_myacount, null, false);
			 listView = (ListView)view.findViewById(R.id.account_list);
			 
			 mAboveTitle = (TextView)view.findViewById(R.id.tv_above_title);
			 mAboveTitle.setText("我的账户");
			 llGoHome = (ImageView)view.findViewById(R.id.Linear_above_toHome);
			llGoHome.setVisibility(View.INVISIBLE);
			
		    List<AccountListItemEntity> value = new ArrayList<AccountListItemEntity>();
		    AccountListItemEntity item1 = new AccountListItemEntity();
		    item1.setCount(88);
		    value.add(item1);
		    AccountListItemEntity item2 = new AccountListItemEntity();
		    item2.setCount(77);
		    value.add(item2);
		    AccountListItemEntity item3 = new AccountListItemEntity();
		    item3.setCount(66);
		    value.add(item3);
		    AccountListAdapter adapter = new AccountListAdapter(value,myActivity);
		    listView.setAdapter(adapter);
			 return view;
		}
		


		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
            case R.id.Linear_above_toHome://监听above_title中的控件
                mHelper.showMenu();//调出菜单栏
                break;
			}
		}
		
}


class AccountListAdapter extends BaseAdapter{

	private LayoutInflater mInflater;
	List<AccountListItemEntity> value;
	public AccountListAdapter(List<AccountListItemEntity> value,Context context){
		this.value = value;
		 mInflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		System.out.println(">>>>>>>+++"+value.size());
		return value.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View view, ViewGroup arg2) {
		// TODO Auto-generated method stub
		view = (View)mInflater.inflate(R.layout.account_list_item, null);
		ImageView account_item_image = (ImageView)view.findViewById(R.id.account_list_item_image);
		TextView account_item_text = (TextView)view.findViewById(R.id.account_list_item_text);
		account_item_image.setImageResource(R.drawable.account_image);
		String texString = null;
		if (arg0 == 0) {
			texString = "已入账["+value.get(arg0).getCount()+"]";
		}else if(arg0 == 1){
			texString = "审核中["+value.get(arg0).getCount()+"]";
		}else if(arg0 == 2){
			texString = "不通过["+value.get(arg0).getCount()+"]";
		}
		account_item_text.setText(texString);
		return view;
	}
	
}

