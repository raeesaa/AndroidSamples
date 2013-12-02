package com.example.samplereadwritetointernalstorage;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener{

	private EditText edit_text;
	private Button btn_save;
	
	public static final String FILENAME = "myFile.txt";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		edit_text = (EditText) findViewById(R.id.edit_text);
		btn_save = (Button) findViewById(R.id.btn_save);
		
		btn_save.setOnClickListener(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {

		if(v.getId() == R.id.btn_save)
		{
			String text = edit_text.getText().toString();
			
			try {
				FileOutputStream fos = openFileOutput(FILENAME, MODE_PRIVATE);
				fos.write(text.getBytes());
				fos.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			Intent intent = new Intent(MainActivity.this, ReadFileActivity.class);
			startActivity(intent);
		}
		
	}

}
