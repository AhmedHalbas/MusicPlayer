package com.example.android.musicplayer;

import org.parceler.Parcel;

@Parcel


public class MySong {

    private int mSongImage;
    private String mSongName;
    private String mArtistName;
    private String mAlbumName;
    private int mSong;

    public MySong() {
    }

    public MySong(int songImage, int song, String songName, String artistName, String albumName) {
        this.mSongImage = songImage;
        this.mSong = song;
        this.mSongName = songName;
        this.mArtistName = artistName;
        this.mAlbumName = albumName;
    }


    public int getSongImage() {
        return mSongImage;
    }

    public String getSongName() {
        return mSongName;
    }

    public String getArtistName() {
        return mArtistName;
    }

    public String getAlbumName() {
        return mAlbumName;
    }

    public int getSong() {
        return mSong;
    }
}
