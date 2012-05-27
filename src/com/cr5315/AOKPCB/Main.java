package com.cr5315.AOKPCB;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment; 
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class Main extends Activity {
	
	String log = "AOKPCB";

	public static Context appContext;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        appContext = getApplicationContext();

       //ActionBar
        ActionBar actionbar = getActionBar();
        actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        
        ActionBar.Tab WebsiteTab = actionbar.newTab().setText(R.string.website);
        ActionBar.Tab DownloadTab = actionbar.newTab().setText(R.string.download);
        ActionBar.Tab AboutTab = actionbar.newTab().setText(R.string.about);
        
        Fragment WebsiteFragment = new WebsiteFragment();
        Fragment DownloadFragment = new DownloadFragment();
        Fragment AboutFragment = new AboutFragment();

        WebsiteTab.setTabListener(new MyTabsListener(WebsiteFragment));
        DownloadTab.setTabListener(new MyTabsListener(DownloadFragment));
        AboutTab.setTabListener(new MyTabsListener(AboutFragment));

        actionbar.addTab(WebsiteTab);
        actionbar.addTab(DownloadTab);
        actionbar.addTab(AboutTab);
        
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("tab", getActionBar().getSelectedNavigationIndex());
    }
    
    public void nightlyButtonClick(View v) {
		Log.i("AOKPCB", "nightlyButtonClick()");
		Intent nIntent = new Intent(Main.this, Nightly.class);
		startActivity(nIntent);
		finish();
	}
    
    public void officialButtonClick(View v) {
		Log.i("AOKPCB", "officialButtonClick()");
		Intent oIntent = new Intent(Main.this, Official.class);
		startActivity(oIntent);
		finish();
    }
    
}



class MyTabsListener implements ActionBar.TabListener {
	public Fragment fragment;

	public MyTabsListener(Fragment fragment) {
		this.fragment = fragment;
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		Toast.makeText(Main.appContext, "Reselected!", Toast.LENGTH_LONG).show();
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		ft.replace(R.id.fragment_container, fragment);
		Log.i("AOKPCB", "Tab:" + " " + tab);
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		ft.remove(fragment);
	}
}





