package com.cr5315.AOKPCB;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class Main extends FragmentActivity {

	private static final String [] TITLES = {
		"AOKPCB",
		"ROM DOWNLOADS",
		"ABOUT",
	};

	private SwipeyTabs mTabs;
	private ViewPager mViewPager;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_swipeytab);

		mViewPager = (ViewPager) findViewById(R.id.viewpager);
		mTabs = (SwipeyTabs) findViewById(R.id.swipeytabs);

		SwipeyTabsPagerAdapter adapter = new SwipeyTabsPagerAdapter(this,
				getSupportFragmentManager());
		mViewPager.setAdapter(adapter);
		mTabs.setAdapter(adapter);
		mViewPager.setOnPageChangeListener(mTabs);
		mViewPager.setCurrentItem(0);
	}

	private class SwipeyTabsPagerAdapter extends FragmentPagerAdapter implements
			SwipeyTabsAdapter {
		
		private final Context mContext;

		public SwipeyTabsPagerAdapter(Context context, FragmentManager fm) {
			super(fm);

			this.mContext = context;
		}

		@Override
		public Fragment getItem(int position) {
			return SwipeyTabFragment.newInstance(TITLES[position]);
		}

		@Override
		public int getCount() {
			return TITLES.length;
		}

		public TextView getTab(final int position, SwipeyTabs root) {
			TextView view = (TextView) LayoutInflater.from(mContext).inflate(
					R.layout.swipey_tab_indicator, root, false);
			view.setText(TITLES[position]);
			view.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					mViewPager.setCurrentItem(position);
				}
			});
			
			return view;
		}

	}

}
