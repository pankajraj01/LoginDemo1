package com.example.logindemo1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class homepage extends AppCompatActivity {

    TextView tv_fname, tv_lname, tv_email, tv_phone;
    String str_fname, str_lname, str_email, str_phone;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        tv_fname = (TextView)findViewById(R.id.tv_fname);
        tv_lname = (TextView)findViewById(R.id.tv_lname);
        tv_email = (TextView)findViewById(R.id.tv_email);
        tv_phone = (TextView)findViewById(R.id.tv_phone);


        intent = getIntent();
        if (intent != null) {
            str_fname = intent.getStringExtra("fname");
            tv_fname.setText(str_fname);
            str_lname = intent.getStringExtra("lname");
            tv_lname.setText(str_lname);
            str_email = intent.getStringExtra("email");
            tv_email.setText(str_email);
            str_phone = intent.getStringExtra("phone");
            tv_phone.setText(str_phone);
        }

    }
}
