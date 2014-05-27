package com.example.afragmentclass;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class Select_Emoji_Activity extends Activity implements OnItemClickListener{
    ListView lstviewemojis;
    Custom_List_Emoji cstlistemoji;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emojis);
        lstviewemojis=(ListView)findViewById(R.id.lstviewemojis);
        lstviewemojis.setOnItemClickListener(this);
        cstlistemoji=new Custom_List_Emoji(this);
        lstviewemojis.setAdapter(cstlistemoji);
    }
    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        // TODO Auto-generated method stub
        SharedPreferences myPrefs = this.getSharedPreferences("myPrefs", MODE_WORLD_READABLE);
        SharedPreferences.Editor prefsEditor = myPrefs.edit();
        System.out.println("Emoji is:- " +arg2);
        prefsEditor.putInt("key1", arg2);
        prefsEditor.commit();
        finish();
    }
}
