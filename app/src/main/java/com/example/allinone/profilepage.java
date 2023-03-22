package com.example.allinone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.io.InputStream;

import kotlin.io.LineReader;

public class profilepage extends AppCompatActivity {
    int nightcount = 0;
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    ImageView photo;
   LinearLayout about;
    ScrollView sc;
    Button edit;
    TextView number;
    String src;
    DBHelper db;
    TextView nametext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilepage);
        db = new DBHelper(profilepage.this, "PERSONDB", null, 1);
        about=findViewById(R.id.about);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        photo = findViewById(R.id.profilephoto);
        edit = findViewById(R.id.edit);
        nametext=findViewById(R.id.nametext);
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().requestProfile().build();
        gsc = GoogleSignIn.getClient(this, gso);
        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct != null) {
            String name=acct.getDisplayName();
            nametext.setText(name);
            if (acct.getPhotoUrl() != null) {
                src = acct.getPhotoUrl().toString();
                Log.e("info", src + "");
                new DownloadImageTask().execute(src);
            }

        }
        number = findViewById(R.id.number);
        Cursor c = db.check();
        c.moveToFirst();
        String pnos = c.getString(1);
        number.setText(pnos);


        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(profilepage.this,aboutus.class);
                startActivity(i);
            }
        });
        sc = findViewById(R.id.scrollv);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(profilepage.this, editprofile.class);
                startActivity(i);
            }
        });
        LinearLayout signOutButton = findViewById(R.id.logout);
        signOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();

            }
        });
    }
    private void signOut() {
        gsc.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                        Toast.makeText(profilepage.this, "Signed out successfully!", Toast.LENGTH_SHORT).show();
                        // Start a new activity or clear the current activity stack
                        Intent intent = new Intent(profilepage.this, MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        finish();
                    } else {
                        // Handle sign-out failure
                        Toast.makeText(profilepage.this, "Sign out failed!", Toast.LENGTH_SHORT).show();
                    }
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
            photo.setImageBitmap(result);
        }
    }
}