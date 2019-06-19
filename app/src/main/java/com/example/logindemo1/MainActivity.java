package com.example.logindemo1;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_email, et_password, et_phone;
    Button btn_login;
    ImageView eye;
    TextView tv_forgot, tv_term;
    FloatingActionButton fbtn_register;

    String str_email, str_password, str_phone, str_fname, str_lname;

    Intent intent;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_email = (EditText) findViewById(R.id.et_email);
        et_password = (EditText) findViewById(R.id.et_password);
        et_phone = (EditText) findViewById(R.id.et_phone);
        btn_login = (Button) findViewById(R.id.bt_login);
        eye = (ImageView) findViewById(R.id.btn_eye);
        tv_forgot = (TextView) findViewById(R.id.tv_forgot);
        tv_term = (TextView) findViewById(R.id.tv_terms);
        fbtn_register = (FloatingActionButton) findViewById(R.id.fbtn_register);

        // et_email.setEnabled(false);

        intent = getIntent();
        if (intent != null) {
            str_email = intent.getStringExtra("email");
            et_email.setText(str_email);
            str_password = intent.getStringExtra("password");
            et_password.setText(str_password);
            str_phone = intent.getStringExtra("phone");
            et_phone.setText(str_phone);
            str_fname = intent.getStringExtra("fname");
            str_lname = intent.getStringExtra("lname");
        }

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                str_email = et_email.getText().toString().trim();
                str_password = et_password.getText().toString().trim();
                str_phone = et_phone.getText().toString().trim();


                if (str_phone.equals("")) {
                    Toast.makeText(MainActivity.this, "Please enter your Phone Number", Toast.LENGTH_LONG).show();
                } else if (str_email.equals("")) {
                    Toast.makeText(MainActivity.this, "Please enter your email.", Toast.LENGTH_LONG).show();
                } else if (str_password.equals("")) {
                    Toast.makeText(MainActivity.this, "Please enter your Password", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Welcome to home Screen", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this, homepage.class);
                    intent.putExtra("email", str_email);
                    intent.putExtra("password", str_password);
                    intent.putExtra("phone", str_phone);
                    intent.putExtra("fname", str_fname);
                    intent.putExtra("lname", str_lname);
                    startActivity(intent);
                }
            }
        });

        fbtn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, signup.class);
                startActivity(intent);
            }
        });


    }
}
