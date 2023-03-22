package com.example.allinone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public class splashActivity extends AppCompatActivity {
    TextView tv1;
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    RelativeLayout relmain;
    Animation txtanimation,layoutanimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        gso=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc= GoogleSignIn.getClient(this,gso);
        GoogleSignInAccount acct=GoogleSignIn.getLastSignedInAccount(this);

        txtanimation= AnimationUtils.loadAnimation(splashActivity.this,R.anim.bottom_top);
        layoutanimation=AnimationUtils.loadAnimation(splashActivity.this,R.anim.fall_down);

        tv1=findViewById(R.id.tv1);
        relmain=findViewById(R.id.relmain);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                relmain.setVisibility(View.VISIBLE);
                relmain.setAnimation(layoutanimation);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        tv1.setVisibility(View.VISIBLE);
                        tv1.setAnimation(txtanimation);
                    }
                },40);
            }
        },10);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                relmain.setVisibility(View.VISIBLE);
                relmain.setAnimation(layoutanimation);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        relmain.setVisibility(View.VISIBLE);
                        relmain.setAnimation(layoutanimation);
                    }
                },200);
            }
        },40);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(splashActivity.this, "hello", Toast.LENGTH_SHORT).show();
                if (acct!=null){
                    Intent intent= new Intent(splashActivity.this,loggedA.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Intent intent = new Intent(splashActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        },4000);

    }

    @Override
    public void finish() {
        super.finish();
        for (int i=0;i<10000;i++)
            for(int j=0;j<1000;j++);
    }
}