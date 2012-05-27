package com.cr5315.AOKPCB;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class WebsiteFragment extends Fragment {
	WebView webView;
		
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View V = inflater.inflate(R.layout.website, container, false);
		// Inflate the layout for this fragment
        webView = (WebView) V.findViewById(R.id.webView);
        webView.loadUrl("http://pcb.team.broc.co/li/aokpcb/");

        return V;
    }    
}
