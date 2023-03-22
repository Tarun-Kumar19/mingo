package com.example.allinone;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class bubbleburst extends AppCompatActivity {
    private BubbleAdapter bubbleAdapter;
    GridView bubbleGrid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bubbleburst);
        // Find the bubble grid in the layout and set its adapter to a new BubbleAdapter
        bubbleGrid = (GridView) findViewById(R.id.bubble_grids);
        bubbleAdapter = new BubbleAdapter(this, 20, 140, Color.RED, Color.GREEN);
        bubbleGrid.setAdapter(bubbleAdapter);
        Toast.makeText(this, "hey babe", Toast.LENGTH_SHORT).show();

        // Set a click listener on each bubble view to burst the clicked bubble
        bubbleGrid.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(bubbleburst.this, "heeeee", Toast.LENGTH_SHORT).show();
                bubbleAdapter.burstBubble(position);
                bubbleburst.this.notify();
            }

        });
    }
}