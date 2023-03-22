package com.example.allinone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class focus extends AppCompatActivity {

    CardView cv,sleepcard,sptcard,anxietycard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_focus);
        cv=findViewById(R.id.stresscard);
        sleepcard = findViewById(R.id.cardsleep);
        sptcard = findViewById(R.id.cardspritiual);
        anxietycard = findViewById(R.id.anxietycard);
        cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(focus.this,stress.class);
                startActivity(i);
            }
        });
        sleepcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(focus.this,sleep.class);
                startActivity(i2);
            }
        });
        sptcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(focus.this,spiritual.class);
                startActivity(i2);
            }
        });
        anxietycard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(focus.this,anxiety.class);
                startActivity(i2);
            }
        });
    }
}