package com.example.samplebrowsegallery;

import java.net.URI;

import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{

	private ImageView img_from_gallery;
	private Button btn_browse_gallery;
	
	private static final int BROWSE_GALLERY = 99;
	private static final String LOG_TAG = "My Tag";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		img_from_gallery = (ImageView) findViewById(R.id.img_from_gallery);
		btn_browse_gallery = (Button) findViewById(R.id.btn_browse_gallery);
		
		btn_browse_gallery.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		
		if(v.getId() == R.id.btn_browse_gallery)
		{
			Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
			startActivityForResult(intent, BROWSE_GALLERY); //Fire intent to browse gallery and select image
		}
		
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		
		if(requestCode == BROWSE_GALLERY)
		{
			//Display selected image in imageView
			Log.i(LOG_TAG,"Gallery Result : " + data.getData());
			
			String[] filePathColumns = {MediaStore.Images.Media.DATA}; 
			
			Uri imageUri = data.getData();
			
			Cursor cursor = getContentResolver().query(imageUri, filePathColumns, null, null, null);
			cursor.moveToFirst();
			
			int columnIndex = cursor.getColumnIndex(filePathColumns[0]);
			String path = cursor.getString(columnIndex);
			
			cursor.close();
			
			Bitmap bm = BitmapFactory.decodeFile(path);
			
			img_from_gallery.setImageBitmap(bm);
		}
		
	}

}
