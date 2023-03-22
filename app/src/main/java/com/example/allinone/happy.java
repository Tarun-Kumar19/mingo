package com.example.allinone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;

public class happy extends AppCompatActivity {
    static int count=0;
    CardView c1,c2,c3;
    ImageView p1,p2,p3,pa1,pa2,pa3;
    MediaPlayer mediaPlayer1,mediaPlayer2,mediaPlayer3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_happy);
        p1=findViewById(R.id.play);
        p2=findViewById(R.id.play2);
        p3=findViewById(R.id.play3);
        pa1=findViewById(R.id.pause);
        pa2=findViewById(R.id.pause2);
        pa3=findViewById(R.id.pause3);
        YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                if(count%5==0) {
                    String videoId = "ZLitZwNV_4I";
                    youTubePlayer.cueVideo(videoId, 0);
                    count=count+1;
                }
                else if(count%5==1) {
                    String videoId = "zcruIov45bI";
                    youTubePlayer.cueVideo(videoId, 0);
                    count=count+1;
                }
                else if(count%5==2) {
                    String videoId = "1P3ZgLOy-w8";
                    youTubePlayer.cueVideo(videoId, 0);
                    count=count+1;
                }
                else if(count%5==3) {
                    String videoId = "KGqBfyQFG_g";
                    youTubePlayer.cueVideo(videoId, 0);
                    count=count+1;
                }
                else if(count%5==4) {
                    String videoId = "7fcP64w7eBE";
                    youTubePlayer.cueVideo(videoId, 0);
                    count=count+1;
                }
                else{
                    count=0;
                }
            }
        });
        mediaPlayer1 = MediaPlayer.create(this, R.raw.chill);
        mediaPlayer2=MediaPlayer.create(this,R.raw.confi);
        mediaPlayer3=MediaPlayer.create(this,R.raw.relax);
        p1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer1.start();

            }
        });
        p2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer2.start();

            }
        });
        p3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer3.start();

            }
        });
        pa1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer1.pause();

            }
        });
        pa2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer2.pause();

            }
        });
        pa3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer3.pause();

            }
        });
    }
}