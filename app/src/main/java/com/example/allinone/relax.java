package com.example.allinone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;

public class relax extends AppCompatActivity {
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relax);
        YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                if(count%5==0) {
                    String videoId = "nqye02H_H6I";
                    youTubePlayer.cueVideo(videoId, 0);
                    count=count+1;
                }
                else if(count%5==1) {
                    String videoId = "wKnS8VPxpHI";
                    youTubePlayer.cueVideo(videoId, 0);
                    count=count+1;
                }
                else if(count%5==2) {
                    String videoId = "1nZMwxWIuls";
                    youTubePlayer.cueVideo(videoId, 0);
                    count=count+1;
                }
                else if(count%5==3) {
                    String videoId = "40tPuU6jrgQ";
                    youTubePlayer.cueVideo(videoId, 0);
                    count=count+1;
                }
                else if(count%5==4) {
                    String videoId = "NACJwvt1dHI";
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