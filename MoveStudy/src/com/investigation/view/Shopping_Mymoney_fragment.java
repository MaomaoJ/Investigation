package com.investigation.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

import com.example.movestudy.R;

@SuppressLint("ValidFragment")
public class Shopping_Mymoney_fragment extends Fragment {
	/**
	 * 作用：在线学习下的学习模块所要使用的fragment
	 */

	List<HashMap<String, Object>> top_list = new ArrayList<HashMap<String, Object>>();
	List<HashMap<String, Object>> blow_list = new ArrayList<HashMap<String, Object>>();
	public View view;
	public Activity activity;
	public ListView people_exchange_ListView;
	public ListView income_expenses_ListView;

	// 图片的文字标题

	public Shopping_Mymoney_fragment() {
		super();
	}

	public Shopping_Mymoney_fragment(Activity activity) {

		super();
		System.out.println(">>>>>测试");
		this.activity = activity;
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
		view = inflater.inflate(R.layout.shopping_mymoney, null, false);
		people_exchange_ListView = (ListView) view
				.findViewById(R.id.another_exchange_list);
		income_expenses_ListView = (ListView) view
				.findViewById(R.id.income_expenses_list);
		top_list = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> mapp1 = new HashMap<String, Object>();
		mapp1.put("people_number", "157XXXXX017");
		mapp1.put("people_award", "kindle电子阅读器");
		top_list.add(mapp1);
		AE_ListAdapter ae_ListAdapter = new AE_ListAdapter(top_list, this
				.getActivity().getApplicationContext());
		people_exchange_ListView.setAdapter(ae_ListAdapter);

		blow_list = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> mapie1 = new HashMap<String, Object>();
		mapie1.put("IE_source", "注册账号");
		mapie1.put("IE_time", "2015年6月19日");
		mapie1.put("IE_number", "88交易币");
		blow_list.add(mapie1);
		IE_ListAdapter ie_ListAdapter = new IE_ListAdapter(blow_list, this
				.getActivity().getApplicationContext());
		income_expenses_ListView.setAdapter(ie_ListAdapter);
		return view;
	}

}

class AE_ListAdapter extends BaseAdapter {

	private LayoutInflater inflater;
	private Context context;
	List<HashMap<String, Object>> list;

	public AE_ListAdapter(List<HashMap<String, Object>> list, Context context) {
		super();
		inflater = LayoutInflater.from(context);
		this.list = list;

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
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
	public View getView(int position, View view, ViewGroup arg2) {
		// TODO Auto-generated method stub
		view = inflater.inflate(R.layout.people_exchange_list_item, null);
		TextView people_number = (TextView) view
				.findViewById(R.id.people_number);
		TextView people_award = (TextView) view
				.findViewById(R.id.people_award_name);
		people_number.setText((CharSequence) list.get(position).get(
				"people_number"));
		people_award.setText((CharSequence) list.get(position).get(
				"people_award"));
		return view;
	}

}

class IE_ListAdapter extends BaseAdapter {

	private LayoutInflater inflater;
	private Context context;
	List<HashMap<String, Object>> list;

	public IE_ListAdapter(List<HashMap<String, Object>> list, Context context) {
		super();
		inflater = LayoutInflater.from(context);
		this.list = list;

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
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
	public View getView(int position, View view, ViewGroup arg2) {
		// TODO Auto-generated method stub
		view = inflater.inflate(R.layout.income_expenses_list_item, null);
		TextView IE_source = (TextView) view
				.findViewById(R.id.income_expenses_source);
		TextView IE_time = (TextView) view
				.findViewById(R.id.income_expenses_time);
		TextView IE_number = (TextView) view
				.findViewById(R.id.income_expenses_number);
		IE_source.setText((CharSequence) list.get(position).get("IE_source"));
		IE_time.setText((CharSequence) list.get(position).get("IE_time"));
		IE_number.setText((CharSequence) list.get(position).get("IE_number"));
		return view;
	}

}