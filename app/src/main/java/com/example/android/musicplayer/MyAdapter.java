package com.example.android.musicplayer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter<MySong> {

    public MyAdapter(Context context, ArrayList<MySong> mySongs) {
        super(context, 0, mySongs);

    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }


        MySong currentSong = getItem(position);

        ImageView songImage = listItemView.findViewById(R.id.song_image_list_item);
        TextView songName = listItemView.findViewById(R.id.song_name_list_item);
        TextView artistName = listItemView.findViewById(R.id.album_name_list_item);


        Glide.with(getContext()).load(currentSong.getSongImage()).into(songImage);
        songName.setText(currentSong.getSongName());
        artistName.setText(currentSong.getAlbumName());


        return listItemView;
    }
}
