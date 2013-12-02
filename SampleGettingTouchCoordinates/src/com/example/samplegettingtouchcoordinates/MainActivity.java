package com.example.samplegettingtouchcoordinates;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

public class MainActivity extends Activity {

	private ImageView img_lighthouse;
	
	private static final String LOG_TAG = "My Tag";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		img_lighthouse = (ImageView) findViewById(R.id.img_lighthouse);
		
		addTouchListener();
	}
	
	private void addTouchListener()
	{
		img_lighthouse.setOnTouchListener(new OnTouchListener() {
		
		@Override
		public boolean onTouch(View v, MotionEvent event) {
				
				float x = event.getX();
				float y = event.getY();
				
				String message = String.format("Touched Coordinates are (%.2f, %.2f)", x, y);
				
				Log.d(LOG_TAG, message);
			
				return false;
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
