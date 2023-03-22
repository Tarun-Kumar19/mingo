package com.example.allinone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;

public class angry extends AppCompatActivity {
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angry);
        YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                if(count%5==0) {
                    String videoId = "LU-smxT1czo";
                    youTubePlayer.cueVideo(videoId, 0);
                    count=count+1;
                }
                else if(count%5==1) {
                    String videoId = "BsVq5R_F6RA";
                    youTubePlayer.cueVideo(videoId, 0);
                    count=count+1;
                }
                else if(count%5==2) {
                    String videoId = "8_FMxPo4xDM";
                    youTubePlayer.cueVideo(videoId, 0);
                    count=count+1;
                }
                else if(count%5==3) {
                    String videoId = "kmTEyxWg7Hs";
                    youTubePlayer.cueVideo(videoId, 0);
                    count=count+1;
                }
                else if(count%5==4) {
                    String videoId = "38y_1EWIE9I";
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