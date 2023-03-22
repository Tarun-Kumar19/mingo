package com.example.allinone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;

public class SAD extends AppCompatActivity {
int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sad);

        YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                if(count%5==0) {
                    String videoId = "PppkNH3bKV4";
                    youTubePlayer.cueVideo(videoId, 0);
                    count=count+1;
                }
                else if(count%5==1) {
                    String videoId = "hmlz8H8nBXs";
                    youTubePlayer.cueVideo(videoId, 0);
                    count=count+1;
                }
                else if(count%5==2) {
                    String videoId = "07d2dXHYb94";
                    youTubePlayer.cueVideo(videoId, 0);
                    count=count+1;
                }
                else if(count%5==3) {
                    String videoId = "Bl1FOKpFY2Q";
                    youTubePlayer.cueVideo(videoId, 0);
                    count=count+1;
                }
                else if(count%5==4) {
                    String videoId = "prE5HVLv_m4";
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