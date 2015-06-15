package com.investigation.ui;

import com.example.movestudy.R;
import com.investigation.ui.Vote_MainActivity;
import com.investigation.ui.base.BaseActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LoginActivity extends BaseActivity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		Button but3 =(Button) findViewById(R.id.tml_login);

		
		but3.setOnClickListener(this);
		
		
		
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
	
			openActivity(Vote_MainActivity.class);
		
	}






}
