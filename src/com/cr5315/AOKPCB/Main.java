package com.cr5315.AOKPCB;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main extends Activity {
	
	String log = "AOKPCB";
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        TextView version = (TextView) findViewById(R.id.currentVersion);
        TextView device = (TextView) findViewById(R.id.deviceText);
        
        version.setText(getResources().getString(R.string.current_version) + " " + Build.DISPLAY);
        device.setText(getResources().getString(R.string.device) + " " + Build.DEVICE);
        
        Button nightly = (Button) findViewById(R.id.nightlyButton);
        nightly.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent nIntent = new Intent (Main.this, Nightly.class);
				startActivity(nIntent);
				finish();
			}
		});
    }
}