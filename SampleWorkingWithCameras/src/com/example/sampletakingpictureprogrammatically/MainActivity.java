package com.example.sampletakingpictureprogrammatically;

import java.io.File;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{
	
	private Button btn_take_photo;
	private ImageView img_photo;
	
	private File imageFile;
	private static final int PICTURE_TAKEN = 99;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btn_take_photo = (Button) findViewById(R.id.btn_take_photo);
		img_photo = (ImageView) findViewById(R.id.new_img);
		
		btn_take_photo.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		
		File picDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES); 
		imageFile = new File(picDirectory, "passpoints_image.jpg"); //File name should normally be unique(e.g "pic"+systemtTime+".jpg")
																		 //Here every image taken will have name same name and hence whenever an image will be captured, it will override previous image and thereby delete previous image 						
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(imageFile)); //saves image captured
		startActivityForResult(intent, PICTURE_TAKEN);
		
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		
		if(requestCode == PICTURE_TAKEN)
		{
			//Code for displaying image
			Bitmap photo = BitmapFactory.decodeFile(imageFile.getAbsolutePath());
			
			if(photo != null)
			{
				img_photo.setImageBitmap(photo);
			}
			else
			{
				Toast.makeText(this, "Unable to save file or display image", Toast.LENGTH_SHORT).show();
			}
		}
		
	}

}
