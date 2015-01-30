package com.mw.android.musicplayer.myplayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by manan on 30-01-2015.
 */
public class SongAdapter extends BaseAdapter{
private ArrayList<Songs> songs;
private LayoutInflater songInf;
    public SongAdapter(Context c,ArrayList<Songs> song1){
        songs=song1;
        songInf=LayoutInflater.from(c);
    }
    @Override
    public int getCount() {
        return songs.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout songLayout = (LinearLayout)songInf.inflate(R.layout.song,parent,false);

        TextView songView = (TextView)songLayout.findViewById(R.id.song_title);
        TextView artistView = (TextView)songLayout.findViewById(R.id.song_artist);

        Songs current = songs.get(position);
        songView.setText(current.getTitle());
        artistView.setText(current.getArtist());

        songLayout.setTag(position);
        return songLayout;
    }
}
