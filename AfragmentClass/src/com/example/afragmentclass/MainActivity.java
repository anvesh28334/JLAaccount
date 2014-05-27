package com.example.afragmentclass;

import android.annotation.TargetApi;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class MainActivity extends Activity implements OnClickListener {
	 EditText edttxtemoji;
	    Button btnsubmit, btnselectemoji;
	    TextView txtviewdisplay;
	    CharSequence cs;
	    Custom_List_Emoji cstlistemoji;
	    int index;
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_main);
		 // ActionBar
        android.app.ActionBar actionbar = getActionBar();
        actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // create the fragments
        Fragment mFindFragment = new FindFragment();
        Fragment mChatFragment = new ChatFragment();
        Fragment mMeetFragment = new MeetFragment();
        Fragment mPartyFragment = new PartyFragment();
        
        
        
        // create new tabs and set up the titles of the tabs
        Tab mFindTab = actionbar.newTab().setText("find");
        Tab mChatTab = actionbar.newTab().setText("Chat");
        Tab mMeetTab = actionbar.newTab().setText("meet");
        Tab mPartyTab = actionbar.newTab().setText("party");

        // bind the fragments to the tabs - set up tabListeners for each tab
        mFindTab.setTabListener(new MyTabsListener(mFindFragment,
                                getApplicationContext()));
        mChatTab.setTabListener(new MyTabsListener(mChatFragment,
                                getApplicationContext()));
        mMeetTab.setTabListener(new MyTabsListener(mMeetFragment,
                                getApplicationContext()));
        mPartyTab.setTabListener(new MyTabsListener(mPartyFragment,
                                getApplicationContext()));

        // add the tabs to the action bar
        actionbar.addTab(mFindTab);
        actionbar.addTab(mChatTab);
        actionbar.addTab(mMeetTab);
        actionbar.addTab(mPartyTab);
        
        
        
        edttxtemoji = (EditText) findViewById(R.id.edttxtemoji);
        btnsubmit = (Button) findViewById(R.id.btnok);
        btnsubmit.setOnClickListener(this);
        btnselectemoji = (Button) findViewById(R.id.btnselect);
        btnselectemoji.setOnClickListener(this);
        txtviewdisplay = (TextView) findViewById(R.id.txtviewdisplay);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v == btnsubmit) {
            txtviewdisplay.setText(edttxtemoji.getText());
        } else if (v == btnselectemoji) {
            Intent in = new Intent(this, Select_Emoji_Activity.class);
            startActivity(in);
        }
	}
	 @Override
	    protected void onRestart() {
	        // TODO Auto-generated method stub
	        super.onRestart();

	        cstlistemoji = new Custom_List_Emoji(this);
	        @SuppressWarnings("static-access")
	        SharedPreferences myPrefs = this.getSharedPreferences("myPrefs",
	                this.MODE_WORLD_READABLE);
	        index = myPrefs.getInt("key1", 0);
	        System.out.println("Pref Data index is:- " + index);
	        ImageGetter imageGetter = new ImageGetter() {
	            public Drawable getDrawable(String source) {
	                Drawable d = getResources().getDrawable(
	                        cstlistemoji.images[index]);
	                d.setBounds(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight());
	                return d;
	            }
	        };
	        cs = Html.fromHtml(
	                "<img src='"
	                        + getResources()
	                                .getDrawable(cstlistemoji.images[index])
	                        + "'/>", imageGetter, null);
	        System.out.println("cs is:- " + cs);
	        edttxtemoji.setText(cs);
	    }

}
