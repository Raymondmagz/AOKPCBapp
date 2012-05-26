package com.cr5315.AOKPCB;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Nightly extends Main {
	
	String log = "AOKPCB";
	WebView webView;
	String device = Build.DEVICE;
	String nightlyUrl = "http://aokpcb.boomm.net/nightlies/";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nightly);
		
		setTitle(R.string.nightly_title);
				
		webView = (WebView) findViewById(R.id.nightlyWebView);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.loadUrl(nightlyUrl + device);
		webView.setWebViewClient(new HelloWebViewClient());
		
	}
	
	private class HelloWebViewClient extends WebViewClient {
	    @Override
	    public boolean shouldOverrideUrlLoading(WebView view, String url) {
	        view.loadUrl(url);
	        return true;
	    }
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	    if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack() == true) {
	        webView.goBack();
	        return true;
	    }
	    else if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack() == false) {
	    	Intent hIntent = new Intent (Nightly.this, Main.class);
	    	startActivity(hIntent);
	    	finish();
	    }
	    return super.onKeyDown(keyCode, event);
	}

}
