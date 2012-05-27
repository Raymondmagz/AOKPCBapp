package com.cr5315.AOKPCB;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Nightly extends Activity {
	
	WebView webView;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nightly);
		
		ActionBar bar = getActionBar();
		bar.setHomeButtonEnabled(true);
		bar.setDisplayHomeAsUpEnabled(true);
		bar.setTitle(R.string.nightly);
		
		TextView deviceText = (TextView) findViewById(R.id.deviceText);
		deviceText.setText(getResources().getString(R.string.device) + " " + Build.DEVICE);
		
		Button downloadButton = (Button) findViewById(R.id.downloadNightlyButton);
		downloadButton.setText(getResources().getString(R.string.lnightly) + " " + Build.DEVICE);
		downloadButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				DownloadNightly();
			}
		});
		
		webView = (WebView) findViewById(R.id.nightlyWebView);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.setWebViewClient(new NightlyWebViewClient());
		webView.loadUrl("http://cr5315.com/AOKPCB/nightlyrss.html");
	}
	
	private class NightlyWebViewClient extends WebViewClient {
		@Override
	    public boolean shouldOverrideUrlLoading(WebView view, String url) {
	        view.loadUrl(url);
	        return true;
	    }
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.nightly, menu);
	    return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	        case android.R.id.home:
	            Intent hIntent = new Intent(Nightly.this, Main.class);
	            startActivity(hIntent);
	            finish();
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	
	  @Override
	    public boolean onKeyDown(int keyCode, KeyEvent event) {
	        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
	            Intent homeIntent = new Intent (Nightly.this, Main.class);
	            startActivity(homeIntent);
	            finish();
	            return true;
	        }
	        return super.onKeyDown(keyCode, event);
	    }
	  
	  public void DownloadNightly() {
		  Log.i("AOKPCB", "This will do something later");
		  Toast.makeText(this, "This will do something later", Toast.LENGTH_LONG).show();
	  }

}
