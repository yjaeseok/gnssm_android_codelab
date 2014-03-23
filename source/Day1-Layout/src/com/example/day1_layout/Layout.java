package com.example.day1_layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Layout extends Activity implements OnClickListener {
	
	private Button btn_linearlayout;
	private Button btn_relativelayout;
	private Button btn_framelayout;
	private Button btn_linearlayout2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.layout);
		
		btn_linearlayout = (Button)findViewById(R.id.btn_linearlayout);
		btn_relativelayout = (Button)findViewById(R.id.btn_relativelayout);
		btn_framelayout = (Button)findViewById(R.id.btn_framelayout);
		btn_linearlayout2 = (Button)findViewById(R.id.btn_linearlayout2);
		
		btn_linearlayout.setOnClickListener(this);
		btn_relativelayout.setOnClickListener(this);
		btn_framelayout.setOnClickListener(this);
		btn_linearlayout2.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		switch(view.getId()){
		case R.id.btn_linearlayout:
			Intent linearIntent = new Intent(Layout.this, LinearLayout.class);
			startActivity(linearIntent);
			break;
		case R.id.btn_relativelayout:
			Intent relativeIntent = new Intent(Layout.this, RelativeLayout.class);
			startActivity(relativeIntent);
			break;
		case R.id.btn_framelayout:
			Intent frameIntent = new Intent(Layout.this, FrameLayout.class);
			startActivity(frameIntent);
			break;
		case R.id.btn_linearlayout2:
			Intent linearIntent2 = new Intent(Layout.this, LinearLayout2.class);
			startActivity(linearIntent2);
			break;
		}
	}
}
