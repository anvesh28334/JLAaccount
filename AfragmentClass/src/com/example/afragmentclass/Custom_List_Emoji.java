package com.example.afragmentclass;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Custom_List_Emoji extends BaseAdapter {

    public Activity context;
    public LayoutInflater inflater;

    public Custom_List_Emoji(Activity context) {
        // TODO Auto-generated constructor stub
        this.context = context;
        this.inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return emojis.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        String temp = emojis[position];
        return temp;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    TextView txtview1;
    ImageView image;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.custom_emojis, null);
            txtview1 = (TextView) convertView.findViewById(R.id.txtviewemojis);
            image = (ImageView) convertView.findViewById(R.id.imgviewemoji);
        }

        image.setImageResource(images[position]);
        txtview1.setText(emojis[position]);
        return convertView;
    }

    public final int[] images = new int[] { R.drawable.emo_im_happy,
            R.drawable.emo_im_sad, R.drawable.emo_im_winking,
            R.drawable.emo_im_tongue_sticking_out, R.drawable.emo_im_surprised,
            R.drawable.emo_im_kissing, R.drawable.emo_im_yelling,
            R.drawable.emo_im_cool, R.drawable.emo_im_money_mouth,
            R.drawable.emo_im_foot_in_mouth, R.drawable.emo_im_embarrassed,
            R.drawable.emo_im_angel, R.drawable.emo_im_undecided,
            R.drawable.emo_im_crying, R.drawable.emo_im_lips_are_sealed,
            R.drawable.emo_im_laughing, R.drawable.emo_im_wtf };
    public final String[] _strEmoticonLabels = new String[] { "Happy", "Sad",
            "Winking", "Tongue sticking out", "Surprised", "Kissing",
            "Yelling", "Cool", "Money Mouth", "Foot in mouth", "Embarrased",
            "Angel", "Undecided", "Crying", "Lips are sealed", "Laughing",
            "Confused" };
    public final String[] emojis = new String[] { ":-)", ":-(", ";-)", ":-P",
            "=-O", ":-*", ":O", "B-)", ":-$", ":-!", ":-[", "O:-)", ":-\\",
            ":'(", ":-X", ":-D", "o_O" };

}
