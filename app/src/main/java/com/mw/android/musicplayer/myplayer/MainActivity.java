package com.mw.android.musicplayer.myplayer;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class MainActivity extends ActionBarActivity {
    private ArrayList<Songs> songList;
    private ListView songView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        songView = (ListView)findViewById(R.id.song_list);
        songList = new ArrayList<Songs>();
        getSongList();

        Collections.sort(songList,new Comparator<Songs>() {
            @Override
            public int compare(Songs a, Songs b) {
                return a.getTitle().compareTo(b.getTitle());
            }
        });

        SongAdapter songAdap = new SongAdapter(this,songList);
        songView.setAdapter(songAdap);

    }
    public void getSongList(){
        ContentResolver musicResolver = getContentResolver();
        Uri musicUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        Cursor musicCursor = musicResolver.query(musicUri,null,null,null,null);
        if(musicCursor != null && musicCursor.moveToFirst()){
            int titleColumn =  musicCursor.getColumnIndex(MediaStore.Audio.Media.TITLE);
            int idCloumn = musicCursor.getColumnIndex(MediaStore.Audio.Media._ID);
            int artistColumn = musicCursor.getColumnIndex(MediaStore.Audio.Media.ARTIST);
            do{
                long thisId = musicCursor.getLong(idCloumn);
                String thisTitle = musicCursor.getString(titleColumn);
                String thisArtist = musicCursor.getString(artistColumn);
            }
            while(musicCursor.moveToNext());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /*@Override+
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}
