package com.cr5315.AOKPCB;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DownloadFragment extends Fragment {
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {		
		// Inflate the layout for this fragment
		View V = inflater.inflate(R.layout.downloads, container, false);
        TextView deviceText = (TextView) V.findViewById(R.id.deviceText);
        deviceText.setText(getResources().getString(R.string.device) + " " +  Build.DEVICE);
        return V;
    }    
}
