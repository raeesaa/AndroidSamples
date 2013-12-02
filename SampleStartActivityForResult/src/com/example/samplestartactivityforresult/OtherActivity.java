package com.example.samplestartactivityforresult;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class OtherActivity extends Activity implements OnClickListener{
	
	Button btn_quit;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_other);
		
		btn_quit = (Button) findViewById(R.id.btn_quit);
		
		btn_quit.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		setResult(RESULT_OK); //Result to be returned to calling activity
		finish();
		
	}

}
