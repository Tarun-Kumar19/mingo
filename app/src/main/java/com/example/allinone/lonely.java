package com.example.allinone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.Toast;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;

public class lonely extends AppCompatActivity {
     int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lonely);
        YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                if(count%5==0) {
                    String videoId = "BRLmzQH-Hd4";
                    youTubePlayer.cueVideo(videoId, 0);
                    count=count+1;
                }
                else if(count%5==1) {
                    String videoId = "Icx7hBWeULM";
                    youTubePlayer.cueVideo(videoId, 0);
                    count=count+1;
                }
                else if(count%5==2) {
                    String videoId = "HEVimVj5K9U";
                    youTubePlayer.cueVideo(videoId, 0);
                    count=count+1;
                }
                else if(count%5==3) {
                    String videoId = "zON0wDD7VJY";
                    youTubePlayer.cueVideo(videoId, 0);
                    count=count+1;
                }
                else if(count%5==4) {
                    String videoId = "E7Mf7RLaitA";
                    youTubePlayer.cueVideo(videoId, 0);
                    count=count+1;
                }
                else{
                    count=0;
                }
            }
        });
    }

}