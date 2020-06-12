package com.example.android.musicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Player extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        String musicName, artistName = null, albumName = null;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                musicName= null;
            } else {
                musicName= extras.getString("musicName");
                artistName= extras.getString("artistName");
                albumName= extras.getString("albumName");
            }
        } else {
            musicName= (String) savedInstanceState.getSerializable("musicName");
            artistName= (String) savedInstanceState.getSerializable("artistName");
            albumName= (String) savedInstanceState.getSerializable("albumName");
        }
        TextView musicNameView = findViewById(R.id.music_name);
        musicNameView.setText(musicName);
        TextView artistNameView = findViewById(R.id.artist_name);
        artistNameView.setText(artistName);
        TextView albumNameView = findViewById(R.id.album_name);
        albumNameView.setText(albumName);

        // set variable image source according to the music name
        ImageView musicIconView = findViewById(R.id.music_icon);
        Resources resources = getResources();
        final int resourceId = resources.getIdentifier(musicName.toLowerCase(),
                "drawable", getPackageName());
        musicIconView.setImageResource(resourceId);
    }

}