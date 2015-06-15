package com.investigation.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.example.movestudy.R;
import com.investigation.baseAdapter.TmlsBasePageAdapter;
import com.investigation.slidingmenu.SlidingActivityHelper;

@SuppressLint("ValidFragment")
public class HomePageFragment extends Fragment implements OnClickListener {

	private Activity myActivity;
	private TmlsBasePageAdapter myAdapter;
	private SlidingActivityHelper mHelper;
	//-----------------------------------------------------------


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
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}

}
