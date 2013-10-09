package com.example.myfirstapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener{

	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		View buttonAbout = findViewById(R.id.button_about);
		buttonAbout.setOnClickListener(this);
		
		View buttonSend = findViewById(R.id.button_send);
		buttonSend.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}
	
	public void sendMessage(View view) {
		
	}

	@Override
	public void onClick(View v) {
		Intent i;
		
		switch(v.getId()) {
		case R.id.button_about:
			i = new Intent(this, AboutActivity.class);
			startActivity(i);
			break;
		case R.id.button_send:
			i = new Intent(this, DisplayMessageActivity.class);
			EditText editText = (EditText) findViewById(R.id.edit_message);
			String message = editText.getText().toString();
			i.putExtra(EXTRA_MESSAGE, message);
			startActivity(i);
			break;
		}
	}

}
