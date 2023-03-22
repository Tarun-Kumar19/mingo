package com.example.allinone;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.Lottie;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.InputStream;

import de.hdodenhof.circleimageview.CircleImageView;

public class loggedA extends AppCompatActivity {
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    String src;
    LottieAnimationView music;
    CircleImageView photos;
    String welcome,x;
    TextView tv;
    CardView med,lonely,happy,sadc,angryc,relaxc,therapist,quote,news;
    ImageView sad;
    ScrollView sc;
    private BottomNavigationView bottomNavigationView;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged);
        sc=findViewById(R.id.scrollv);
        lonely=findViewById(R.id.lonelycard);
        happy=findViewById(R.id.cardView);
        sadc=findViewById(R.id.sadcard);
        angryc=findViewById(R.id.angrycard);
        relaxc=findViewById(R.id.relaxcard);
        quote=findViewById(R.id.card1);
        music=findViewById(R.id.music);
        therapist=findViewById(R.id.card2);
        news=findViewById(R.id.kitcard1);

        db=new DBHelper(loggedA.this,"PERSONDB",null,1);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        boolean switchState = getIntent().getBooleanExtra("switchback", false);
        View rootView = getWindow().getDecorView().getRootView();

        if (switchState) {
            sc.setBackgroundColor(Color.DKGRAY);
        } else {
            sc.setBackgroundColor(Color.BLACK);
        }
        welcome = "Welcome back,";
        x="";
        sad=findViewById(R.id.sadimage);
        tv = findViewById(R.id.wlcmtxt);
        gso=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().requestProfile().build();
        gsc= GoogleSignIn.getClient(this,gso);
        photos=findViewById(R.id.photo);
        GoogleSignInAccount acct=GoogleSignIn.getLastSignedInAccount(this);
        if (acct!=null){
            String x=acct.getDisplayName();
            String emails=acct.getEmail();
            lonely.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i1= new Intent(loggedA.this, lonely.class);
                    startActivity(i1);
                }
            });
            long res=db.insertemail(emails);
            if (res == -1){
            }
            else
            if (acct.getPhotoUrl()!=null)
            {
                src= acct.getPhotoUrl().toString();
                Log.e("info",src+"");
                new DownloadImageTask().execute(src);
            }
            tv.setText(welcome+x);
        }
        quote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(loggedA.this,quoteoftheday.class);
                startActivity(i);
            }
        });
        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(loggedA.this,news.class);
                startActivity(i);
            }
        });
        sadc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(loggedA.this,SAD.class);
                startActivity(intent);
            }
        });
        photos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(loggedA.this,profilepage.class);
                startActivity(i);
            }
        });
        med = findViewById(R.id.focuscard);
        med.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(loggedA.this,focus.class);
                startActivity(i);
            }
        });
        happy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(loggedA.this, happy.class);
                startActivity(i);

            }
        });
        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(loggedA.this,aichatbot.class);
                startActivity(i);
            }
        });
        angryc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(loggedA.this, angry.class);
                startActivity(i);
            }
        });
        relaxc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(loggedA.this, relax.class);
                startActivity(i);
            }
        });
        therapist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(loggedA.this,therapist.class);
                startActivity(i);
            }
        });


}
    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {

        protected Bitmap doInBackground(String... urls) {
            String imgUrl = urls[0];
            Bitmap bitmap = null;
            try {
                InputStream in = new java.net.URL(imgUrl).openStream();
                bitmap = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        protected void onPostExecute(Bitmap result) {
            photos.setImageBitmap(result);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK){
            finish();
        }
    }
}