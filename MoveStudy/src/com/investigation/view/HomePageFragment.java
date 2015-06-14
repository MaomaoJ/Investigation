package com.investigation.view;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;





import com.example.movestudy.R;
import com.investigation.baseAdapter.ImageAdapter;
import com.investigation.baseAdapter.TmlsBasePageAdapter;
import com.investigation.slidingmenu.SlidingActivityHelper;
import com.investigation.widget.CircleFlowIndicator;
import com.investigation.widget.ViewFlow;


@SuppressLint("ValidFragment")
public class HomePageFragment extends Fragment implements OnClickListener
{

	
	private String tag = "0";
	ViewFlow viewflow;
	CircleFlowIndicator viewflowIndicator;

	RelativeLayout newsLayout;
	TextView tvNewsItem;

	RelativeLayout repertoryLayout;

	TableLayout table;
	
	Activity myActivity;
	
	TmlsBasePageAdapter myAdapter;
	
	//private ImageView imgQuery;
    //private ImageView imgMore;
	private LinearLayout llGoHome;
	
	SlidingActivityHelper mHelper;
	TextView mAboveTitle;
	  
	@SuppressLint("ValidFragment")
	public HomePageFragment(Activity activity,TmlsBasePageAdapter studyBasePageAdapter,SlidingActivityHelper mHelper){
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
			
			 View view = (View)inflater.inflate(R.layout.fragment_main, null, false);
			// 鐢�viewflow 瀹炵幇鑷姩婊氬姩鍥剧墖
				viewflow = (ViewFlow)view.findViewById(R.id.viewflow);
				viewflow.setAdapter(new ImageAdapter(getActivity()));
				viewflowIndicator = (CircleFlowIndicator)view.findViewById(R.id.viewflowindicator);
				viewflow.setFlowIndicator(viewflowIndicator);
				viewflow.setTimeSpan(1000 * 3);
				viewflow.startAutoFlowTimer();
				
				 mAboveTitle = (TextView)view.findViewById(R.id.tv_above_title);
				 mAboveTitle.setText("主页");
				llGoHome = (LinearLayout)view.findViewById(R.id.Linear_above_toHome);
				llGoHome.setOnClickListener(this);

				// 璁剧疆鏂伴椈
				int[] tvid = { R.id.news_item1, R.id.news_item2, R.id.news_item3,
						R.id.news_item4, R.id.news_item5 };
				List<String> content = new ArrayList<String>();
				content.add("鎮ㄧ殑鍥涙湀浠介攢鍞垎鏋愭姤鍛婂凡鐢熸垚锛�?��鍑绘煡鐪�?[2015/4/22]");
				content.add("闆姳鍟ら厭鍥涘窛鏂版槬璁㈣揣浼氬渾婊＄粨鏉�?[2015/4/22]");
				content.add("鎶婇吙閰掑笀鎷夎繘鏈嬪弸鍦� [2015/4/22]");
				content.add("闆姳鍟ら厭锛氭崸鎶�兘鈥滄槑鏄熲�锛岄吙缁忓吀鍝佽�? [2015/4/22]");
				content.add("闆姳鍟ら厭锛氬ソ闆囦富浼氳�?��犲湪鈥滀换鎬р�鍜屸�闊ф�鈥濅腑鎴愰暱  [2015/4/22]");

				for (int i = 0; i < 5; i++) {
					newsLayout = (RelativeLayout)view.findViewById(tvid[i]);
					tvNewsItem = (TextView) newsLayout.findViewById(R.id.tv_new_item);
					tvNewsItem.setText(content.get(i));
				}

				
				//濉厖搴撳瓨
				//LayoutInflater inflater = getLayoutInflater();

				repertoryLayout = (RelativeLayout) inflater.inflate(
						R.layout.repertory_item, null);
				ImageView iv = (ImageView) repertoryLayout
						.findViewById(R.id.iv_product);
				iv.setImageDrawable(getResources().getDrawable(R.drawable.beer1));
				TextView name = (TextView) repertoryLayout
						.findViewById(R.id.tv_proname);
				name.setText("鍕囬棷澶╂动250ml");
				
				TextView status = (TextView) repertoryLayout
						.findViewById(R.id.tv_status);
				status.setText("搴撳瓨鍏呰冻");

				table = (TableLayout)view.findViewById(R.id.tr_table);
				TableRow row = new TableRow(getActivity());
				row.addView(repertoryLayout);
				table.addView(row);
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
		
		


