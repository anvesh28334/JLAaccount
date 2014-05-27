package com.example.afragmentclass;

import android.annotation.SuppressLint;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.widget.Toast;

@SuppressLint("NewApi")
public class MyTabsListener implements TabListener {


	 public Fragment fragment;
     public Context context;

     public MyTabsListener(Fragment frag, Context context) {
                 this.fragment = frag;
                 this.context = context;

     }

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		Toast.makeText(context, "Selected!", Toast.LENGTH_SHORT).show();
        ft.replace(R.id.fragment_container, fragment);
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		 Toast.makeText(context, "Unselected!", Toast.LENGTH_SHORT).show();
ft.remove(fragment);
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		 Toast.makeText(context, "onTabReselected!", Toast.LENGTH_SHORT).show();
	}

}
