package com.mw.android.musicplayer.myplayer;

/**
 * Created by manan on 30-01-2015.
 */
public class Songs {
    private long id;
    private String title;
    private String artist;

    public Songs(long songID, String SongTitle, String SongArtist){
        id= songID;
        title = SongTitle;
        artist = SongArtist;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }
}
