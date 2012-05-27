package com.cr5315.AOKPCB;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class WebsiteFragment extends Fragment {
	
	public void onAttach() {
		Log.i("AOKPCB", "onAttach");
		//Not called
	}
	
	public void onCreate() {
		Log.i("AOKPCB", "onCreate");
		//Not called
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.website, container, false);
        //Works fine
    }
	
	public void onActivityCreated() {
		Log.i("AOKPCB", "onActivityCreated");
		//Not called
	}
	
	@Override
	public void onStart() {
		Log.i("AOKPCB", "onStart");
		//Causes crash
	}
	
	@Override
	public void onResume() {
		Log.i("AOKPCB", "onResume");
		//Causes crash
	}
	

    
}
