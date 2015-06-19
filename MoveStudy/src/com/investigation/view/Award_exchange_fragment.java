package com.investigation.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.movestudy.R;

@SuppressLint("ValidFragment")
public class Award_exchange_fragment extends Fragment implements OnClickListener{
	/**
	 * 作用：在线学习下的学习模块所要使用的fragment
	 */

	List<HashMap<String, Object>> top_list = new ArrayList<HashMap<String, Object>>();
	List<HashMap<String, Object>> blow_list = new ArrayList<HashMap<String, Object>>();
	public View view;
	public Activity activity;
	public ListView people_exchange_ListView;
	public ListView income_expenses_ListView;
	Handler handler ;

	// 图片的文字标题

	public Award_exchange_fragment() {
		super();
	}

	public Award_exchange_fragment(Activity activity,Handler handler) {

		super();
		System.out.println(">>>>>测试");
		this.activity = activity;
		this.handler = handler;
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		// webview = (WebView) getView().findViewById(R.id.webview);
	}

	// 一个fragment里面至少要继承这些方法
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		// 当创建fragment时, 系统调用该方法.
		// 在实现代码中,应当初始化想要在fragment中保持的必要组件, 当fragment被暂停或者停止后可以恢复.

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
		// 用户将要离开fragment时,系统调用这个方法作为第一个指示(然而它不总是意味着fragment将被销毁.) ---
		// 在当前用户会话结束之前,通常应当在这里提交任何应该持久化的变化(因为用户有可能不会返回).
		super.onPause();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// fragment第一次绘制它的用户界面的时候, 系统会调用此方法. 为了绘制fragment的UI,此方法必须返回一个View,-----
		// 这个view是你的fragment布局的根view. 如果fragment不提供UI, 可以返回null.
		// 填充一个布局View到ViewGrope中
		// 设置WebView属性，能够执行Javascript脚本
		view = inflater.inflate(R.layout.fragment_award_exchange, null, false);
		Button return_shopping = (Button) view.findViewById(R.id.button_return_shopping);
		return_shopping.setOnClickListener(this);
		return view;
	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch (view.getId()) {
		case R.id.button_return_shopping:
			Message message = new Message();
			
            message.what = 2; 
		    handler.sendMessage(message);
			break;

		default:
			break;
		}
	}


}