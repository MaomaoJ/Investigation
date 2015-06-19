package com.investigation.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.audiofx.Visualizer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

import com.example.movestudy.R;

@SuppressLint("ValidFragment")
public class Shopping_ExAward_Fragment extends Fragment{
	/**
	 * 作用：在线学习下的学习模块所要使用的fragment
	 */

	List<HashMap<String, Object>> top_list = new ArrayList<HashMap<String, Object>>();
	List<HashMap<String, Object>> blow_list = new ArrayList<HashMap<String, Object>>();
	public View view;
	public Activity activity;
	public ListView myListView;
	Handler handler;
	
	
	
	
	 private GridView top_gridView; 
	 private GridView blow_gridView; 
	    //图片的文字标题 
	   
	
	public Shopping_ExAward_Fragment(){
		super();
	}
	public Shopping_ExAward_Fragment(Activity activity,Handler handler){
		
		super();
		this.handler = handler;
		System.out.println(">>>>>测试");
		this.activity = activity;
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
			//设置WebView属性，能够执行Javascript脚本
			 view = inflater.inflate(R.layout.shopping_exchange_award, null, false);	
			 top_gridView = (GridView)view.findViewById(R.id.award_list_GridView_top); 
			 
		        HashMap<String, Object> map1 = new HashMap<String, Object>();
				HashMap<String, Object> map2 = new HashMap<String, Object>();
				map1.put("award_picture", R.drawable.award_gridview_top);
				map1.put("award_name", "亚马逊kiddle电子阅读器");
				map1.put("award_money", "89900兑换币");
				
				map2.put("award_picture", R.drawable.award_gridview_top);
				map2.put("award_name", "亚马逊kiddle电子阅读器");
				map2.put("award_money", "89900兑换币");
								
				top_list.clear();
				top_list.add(map1);//将map加到表中
				top_list.add(map2);
		        PictureAdapter adapter = new PictureAdapter(top_list,this.getActivity().getApplicationContext());
		        top_gridView.setAdapter(adapter); 
		 
		        top_gridView.setOnItemClickListener(new OnItemClickListener() 
		            { 
		                public void onItemClick(AdapterView<?> parent, View v, int position, long id) 
		                { 
		                	Message message = new Message();
	    					
	    		            message.what = 1; 

	    				
	    				
	    				handler.sendMessage(message);
		               
		                } 
		            }); 
		        
		        blow_gridView = (GridView)view.findViewById(R.id.award_list_GridView_blow); 
				 
		        HashMap<String, Object> mapb1 = new HashMap<String, Object>();
				HashMap<String, Object> mapb2 = new HashMap<String, Object>();
				HashMap<String, Object> mapb3 = new HashMap<String, Object>();
				HashMap<String, Object> mapb4 = new HashMap<String, Object>();
				mapb1.put("award_picture", R.drawable.award_gridview_blow);
				mapb1.put("award_name", "点点猫一对（蓝、白）");
				mapb1.put("award_money", "10000兑换币");
				
				mapb2.put("award_picture", R.drawable.award_gridview_blow);
				mapb2.put("award_name", "点点猫一对（蓝、白）");
				mapb2.put("award_money", "10000兑换币");
				
				mapb3.put("award_picture", R.drawable.award_gridview_blow);
				mapb3.put("award_name", "点点猫一对（蓝、白）");
				mapb3.put("award_money", "10000兑换币");
				
				mapb4.put("award_picture", R.drawable.award_gridview_blow);
				mapb4.put("award_name", "点点猫一对（蓝、白）");
				mapb4.put("award_money", "10000兑换币");
								
				blow_list.clear();
				blow_list.add(mapb1);//将map加到表中
				blow_list.add(mapb2);
				blow_list.add(mapb3);
				blow_list.add(mapb4);
		        PictureAdapter adapterb = new PictureAdapter(blow_list,this.getActivity().getApplicationContext());
		        blow_gridView.setAdapter(adapterb); 
		 
		        blow_gridView.setOnItemClickListener(new OnItemClickListener() 
		            { 
		                public void onItemClick(AdapterView<?> parent, View v, int position, long id) 
		                { 
		                	Message message = new Message();
		    					
		    		            message.what = 1; 

		    				
		    				
		    				handler.sendMessage(message);
		               
		                } 
		            }); 
		        blow_gridView.setOnTouchListener(new OnTouchListener() {


					@Override
					public boolean onTouch(View arg0, MotionEvent arg1) {
						// TODO Auto-generated method stub
						 return MotionEvent.ACTION_MOVE == arg1.getAction() ? true
	                              : false;
					}
		          });
			
//				StudyLearn_ListAdapter listAdapter = new StudyLearn_ListAdapter(myActivity.getApplicationContext(), list,
//						R.layout.lesson_recommend_item, new String[] { "lesson_imageview_head", "lesson_textview_name",
//						"lesson_textview_content","lesson_textview_time"},
//						new int[] {R.id.lesson_imageview_head,R.id.lesson_textview_name,R.id.lesson_textview_content,R.id.lesson_textview_time});
				//第三个参数（布局文件）代表list中每一行显示内容的格式
				//String里面的值必须和map里面键值对的键名一致，他的顺序就代表键值对的值放入List的后显示顺序
				//int []里面的值就是对应的布局文件里面控件的id，顺序就是Id的顺序
				
				
	        return view;
		}

}






class PictureAdapter extends BaseAdapter{ 
    private LayoutInflater inflater; 
    private Context context;
    List<HashMap<String, Object>> list;
 
    public PictureAdapter(List<HashMap<String, Object>> list, Context context) 
    { 
        super(); 
        inflater = LayoutInflater.from(context); 
        this.list = list;
		
    } 
 
    @Override
    public int getCount() 
    { 
        if (list.size() != 0) 
        { 
            return list.size(); 
        } else
        { 
            return 0; 
        } 
    } 
 
    @Override
    public Object getItem(int position) 
    { 
        return list.get(position); 
    } 
 
    @Override
    public long getItemId(int position) 
    { 
        return position; 
    } 
 
    @Override
    public View getView(int position, View convertView, ViewGroup parent) 
    { 
        ViewHolder viewHolder; 
        if (convertView == null) 
        { 
            convertView = inflater.inflate(R.layout.award_gridview_item, null); 
            viewHolder = new ViewHolder(); 
            viewHolder.name = (TextView) convertView.findViewById(R.id.award_gridview_item_name);
            viewHolder.money = (TextView) convertView.findViewById(R.id.award_gridview_item_money);
            viewHolder.image = (ImageView) convertView.findViewById(R.id.award_gridview_item_picture); 
            convertView.setTag(viewHolder); 
        } else
        { 
            viewHolder = (ViewHolder) convertView.getTag(); 
        } 
        viewHolder.name.setText((CharSequence) list.get(position).get("award_name")); 
        viewHolder.money.setText((CharSequence) list.get(position).get("award_money"));
        viewHolder.image.setImageResource((Integer) list.get(position).get("award_picture"));
        //viewHolder.image.setImageResource(pictures.get(position).getImageId()); 
        return convertView; 
    } 
 
} 


class ViewHolder 
{ 
    public TextView name;
    public TextView money;
    public ImageView image; 
} 
