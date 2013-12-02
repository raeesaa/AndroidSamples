package com.example.samplesqllitedbwithtouchlistener;

import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Point;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

public class MainActivity extends Activity implements PointCollectorInterface{

	private ImageView img_lighthouse;
	
	public static final String LOG_TAG = "My Tag";
	
	PointCollector pointCollector = new PointCollector();
	private Database db = new Database(this);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		img_lighthouse = (ImageView) findViewById(R.id.img_lighthouse);
		
		addTouchListener();
		
		pointCollector.setListener(this);
	}
	
	private void addTouchListener()
	{
		img_lighthouse.setOnTouchListener(pointCollector);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void pointsCollected(List<Point> points) {
		Log.d(LOG_TAG, "Size of Collected Points : " + points.size());
		db.storePoints(points);
		
		List<Point> fetchedPoints = db.getPoints();
		
		for(Point point : fetchedPoints)
		{
			Log.d(LOG_TAG, "Retrieved Point : " + point.toString());
		}
	}

}
