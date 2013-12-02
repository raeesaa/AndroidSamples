package com.example.samplestartactivityforresult;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{
	
	Button btn_start_activity;
	private static final int OTHER_ACTIVITY_CODE = 99;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btn_start_activity = (Button) findViewById(R.id.btn_other_activity);
		btn_start_activity.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		Intent intent = new Intent(MainActivity.this, OtherActivity.class);
		startActivityForResult(intent, OTHER_ACTIVITY_CODE);
		
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(requestCode == OTHER_ACTIVITY_CODE)
		{
			Toast.makeText(this, "Returned with result code " + resultCode, Toast.LENGTH_SHORT).show();
		}
	}

}
