package com.investigation.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.movestudy.R;
import com.investigation.baseAdapter.TmlsBasePageAdapter;
import com.investigation.slidingmenu.SlidingActivityHelper;

@SuppressLint("ValidFragment")
public class Accumulated_Shopping_Fragment extends Fragment implements OnClickListener
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
	private Handler mHandler;
	  
	@SuppressLint("ValidFragment")
	public Accumulated_Shopping_Fragment(Activity activity,TmlsBasePageAdapter studyBasePageAdapter,SlidingActivityHelper mHelper){
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
			
			 View view = (View)inflater.inflate(R.layout.fragment_accumulated_shopp, null, false);
			 
			 mAboveTitle = (TextView)view.findViewById(R.id.tv_above_title);
			 mAboveTitle.setText("积分商城");
			 llGoHome = (ImageView)view.findViewById(R.id.Linear_above_toHome);
			 llGoHome.setVisibility(View.INVISIBLE);
		
			 
			 mHandler = new Handler(){
		        	public void handleMessage(Message msg) {  
		        		android.support.v4.app.FragmentManager fm = getChildFragmentManager();
						// 开启事务
					 android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();//对fragment操作必要的东西
		                   switch (msg.what) {
		                   case 1:
		       				// 开启事务
		       			 ft.replace(R.id.shopping_fragment_content, new Award_exchange_fragment(myActivity,mHandler));
		       			 ft.commit();
		       			 break;
		                   case 2:
				       				// 开启事务
				       			 ft.replace(R.id.shopping_fragment_content, new Shopping_ExAward_Fragment(myActivity,mHandler));
				       			 ft.commit();
				       			 break;
		                   }
		        	}
		        	};
			 
			 android.support.v4.app.FragmentManager fm = getChildFragmentManager();
				// 开启事务
			 android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();//对fragment操作必要的东西
			 ft.replace(R.id.shopping_fragment_content, new Shopping_ExAward_Fragment(myActivity,mHandler));
			 ft.commit();
			 
			 Button button_exchange = (Button)view.findViewById(R.id.shopping_button_exchange);
			 button_exchange.setOnClickListener(this);
			 Button button_mymoney = (Button)view.findViewById(R.id.shopping_button_mymoney);
			 button_mymoney.setOnClickListener(this);
			 Button button_mygoods = (Button)view.findViewById(R.id.shopping_button_mygoods);
			 button_mygoods.setOnClickListener(this);
			
		
		   
			 return view;
		}
		


		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			// 获取FragmentManager对象
						
			 android.support.v4.app.FragmentManager fm = getChildFragmentManager();
				// 开启事务
			 android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();//对fragment操作必要的东西
			switch (v.getId()) {
            case R.id.shopping_button_exchange://监听above_title中的控件
            	// 替换R.id.content中的Fragment
            	
				ft.replace(R.id.shopping_fragment_content, new Shopping_ExAward_Fragment(myActivity,mHandler));
				ft.commit();
                break;
            case R.id.shopping_button_mymoney://监听above_title中的控件
            	System.out.println(">>>>>>测试1");
            	ft.replace(R.id.shopping_fragment_content, new Shopping_Mymoney_fragment(myActivity));
				ft.commit();
                break;
           case R.id.shopping_button_mygoods://监听above_title中的控件
    
                break;
			}
		}
		
}