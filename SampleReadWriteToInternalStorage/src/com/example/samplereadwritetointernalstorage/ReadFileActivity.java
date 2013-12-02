package com.example.samplereadwritetointernalstorage;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

public class ReadFileActivity extends Activity {
	
	private EditText edit_text;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_readfile);
		
		edit_text = (EditText) findViewById(R.id.edit_text);
		
		loadFileData();
	}
	
	private void loadFileData()
	{
		try {
			FileInputStream fis = openFileInput(MainActivity.FILENAME);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(new DataInputStream(fis)));
			
			String line;
			while((line = br.readLine()) != null)
			{
				edit_text.append(line);
				edit_text.append("\n");
			}
				
			fis.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
