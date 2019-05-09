package com.example.android.musicplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.parceler.Parcels;

public class NowPlayingActivity extends AppCompatActivity {

    private TextView artistName, songName;
    private ImageView songImage;
    private SeekBar seekBar;
    private ImageButton playSong, pauseSong, stopSong;
    private MediaPlayer mMediaPlayer;
    private final Handler mHandler = new Handler();



    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        artistName = findViewById(R.id.artist_name);
        songImage = findViewById(R.id.song_image);
        songName = findViewById(R.id.song_name);
        seekBar = findViewById(R.id.seekBar);
        seekBar.setEnabled(false);
        playSong = findViewById(R.id.play);
        pauseSong = findViewById(R.id.pause);
        stopSong = findViewById(R.id.stop);


       final MySong nowPlayingSong = Parcels.unwrap(getIntent().getParcelableExtra(MainActivity.KEY_POSITION));


            artistName.setText(nowPlayingSong.getArtistName());

            Glide.with(this).load(nowPlayingSong.getSongImage()).into(songImage);


            songName.setText(nowPlayingSong.getSongName());



        playSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                seekBar.setEnabled(true);


                if (mMediaPlayer == null) {

                    mMediaPlayer = MediaPlayer.create(NowPlayingActivity.this, nowPlayingSong.getSong());

                    mMediaPlayer.start();
                    seekBar.setMax(mMediaPlayer.getDuration() / 1000);

                } else {
                    mMediaPlayer.start();
                    seekBar.setMax(mMediaPlayer.getDuration() / 1000);
                }


                NowPlayingActivity.this.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        if (mMediaPlayer != null) {
                            int mCurrentPosition = mMediaPlayer.getCurrentPosition() / 1000;
                            seekBar.setProgress(mCurrentPosition);
                        }
                        mHandler.postDelayed(this, 1000);
                    }
                });


            }
        });


        pauseSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                seekBar.setEnabled(false);

                if (mMediaPlayer != null) {
                    mMediaPlayer.pause();
                }


            }
        });


        stopSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                seekBar.setEnabled(false);
                seekBar.setProgress(0);

                if (mMediaPlayer != null) {
                    mMediaPlayer.stop();
                    releaseMediaPlayer();
                }


            }
        });


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int seeked_progess;

            @Override
            public void onProgressChanged(final SeekBar seekBar, int i, boolean b) {

                seeked_progess = i;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {


            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                mMediaPlayer.seekTo((seeked_progess * 1000) % (mMediaPlayer.getDuration()));

            }
        });


    }


    private void releaseMediaPlayer() {

        if (mMediaPlayer != null) {

            mMediaPlayer.release();


            mMediaPlayer = null;

        }
    }


    @Override
    public void onBackPressed() {

        releaseMediaPlayer();
        finish();

    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return false;
    }





}
