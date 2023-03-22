package com.example.allinone;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class MainActivity extends AppCompatActivity {
    LottieAnimationView lv;
    EditText firstNameEditText, lastNameEditText, phoneNumberEditText;
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    CardView c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        lv=findViewById(R.id.imageView11);
        lv.playAnimation();
        lv.loop(true);
        c=findViewById(R.id.googlebtn);
        gso=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc= GoogleSignIn.getClient(this,gso);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });


//        insert.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String fnamee= firstNameEditText.getText().toString();
//                String lname = lastNameEditText.getText().toString();
//                String phone = phoneNumberEditText.getText().toString();
//                long res = db.insertD(fnamee,lname,phone);
//                if (res == -1){
//                    Toast.makeText(MainActivity.this, "Insert Failed", Toast.LENGTH_SHORT).show();
//                }
//                else
//                    Toast.makeText(MainActivity.this, "Insert successful", Toast.LENGTH_SHORT).show();
//
//            }
//        });
    }
    void signIn(){
        Intent signInIntent = gsc.getSignInIntent();
        startActivityForResult(signInIntent,1000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                task.getResult(ApiException.class);
                navigateToSecondActivity();
            } catch (ApiException e) {
                Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        }
    }
    void navigateToSecondActivity(){
        finish();
        Intent intent = new Intent(MainActivity.this,loggedA.class);
        startActivity(intent);
        finish();
    }
}
