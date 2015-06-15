package com.investigation.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.movestudy.R;
import com.investigation.baseAdapter.TmlsBasePageAdapter;
import com.investigation.slidingmenu.SlidingActivityHelper;
import com.investigation.widget.CircleFlowIndicator;
import com.investigation.widget.ViewFlow;

@SuppressLint("ValidFragment")
public class HomePageFragment extends Fragment implements OnClickListener {

	private Activity myActivity;
	private TmlsBasePageAdapter myAdapter;
	private SlidingActivityHelper mHelper;
	// -----------------------------------------------------------
	private ViewFlow mhome_viewflow;
	private CircleFlowIndicator mhome_viewflowindicator;
	private TextView mhome_iv_title;
	private TextView mhome_iv_more;
	private ListView mListView;

	private View mView;

	@SuppressLint("ValidFragment")
	public HomePageFragment(Activity activity,
			TmlsBasePageAdapter studyBasePageAdapter,
			SlidingActivityHelper mHelper) {
		myActivity = activity;
		myAdapter = studyBasePageAdapter;
		this.mHelper = mHelper;

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mView = inflater.inflate(R.layout.home, null);
		return mView;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		initView();
	}
	
	
	private void initView() {
		mhome_viewflow=(ViewFlow)mView.findViewById(R.id.home_viewflow);
		mhome_viewflowindicator=(CircleFlowIndicator)mView.findViewById(R.id.home_viewflowindicator);
		mhome_iv_title=(TextView)mView.findViewById(R.id.home_iv_title);
		mhome_iv_more=(TextView)mView.findViewById(R.id.home_iv_more);
		mListView=(ListView)mView.findViewById(R.id.home_listview);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}

}
