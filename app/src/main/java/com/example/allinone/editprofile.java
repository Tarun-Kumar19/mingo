package com.example.allinone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class editprofile extends AppCompatActivity {
    DBHelper db;
    EditText pno,email;
    Button change;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofile);
        db=new DBHelper(editprofile.this,"PERSONDB",null,1);
        pno=findViewById(R.id.pno);
        change=findViewById(R.id.change);
        email=findViewById(R.id.email);
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneno=pno.getText().toString();
                String mailid=email.getText().toString();
                int res=db.updates(mailid,phoneno);
                Cursor c=db.send(mailid);
                c.moveToFirst();
                String pnooo=c.getString(1);

            }
        });
    }
}