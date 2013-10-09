package com.example.myfirstapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
		
		getMenuInflater().inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.action_search:
	            //openSearch();
	            return true;
	        case R.id.action_settings:
	            //openSettings();
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
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
