package com.example.logindemo1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class signup extends AppCompatActivity {

    EditText et_email, et_password, et_fname, et_lname, et_phone;
    Button btn_register;
    ImageView eye;
    TextView tv_cancel;

    String str_email, str_password, str_fname, str_lname,str_phone;
    boolean showpass = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        et_fname = (EditText) findViewById(R.id.et_first);
        et_lname = (EditText) findViewById(R.id.et_last);
        et_email = (EditText) findViewById(R.id.et_email);
        et_password = (EditText) findViewById(R.id.et_password);
        et_phone = (EditText)findViewById(R.id.et_phone);
        btn_register = (Button) findViewById(R.id.btn_register);
        eye = (ImageView) findViewById(R.id.btn_eye);
        tv_cancel = (TextView) findViewById(R.id.tv_cancel);


        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str_email = et_email.getText().toString().trim();
                str_password = et_password.getText().toString().trim();
                str_fname = et_fname.getText().toString().trim();
                str_lname = et_lname.getText().toString().trim();
                str_phone = et_phone.getText().toString().trim();

                if (str_fname.equals("")) {
                    Toast.makeText(signup.this, "Please enter your First Name.", Toast.LENGTH_LONG).show();
                } else if (str_lname.equals("")) {
                    Toast.makeText(signup.this, "Please enter your Last Name.", Toast.LENGTH_LONG).show();
                } else if (str_email.equals("")) {
                    Toast.makeText(signup.this, "Please enter your Email.", Toast.LENGTH_LONG).show();
                } else if (str_password.equals("")) {
                    Toast.makeText(signup.this, "Please enter your Password.", Toast.LENGTH_LONG).show();
                } else if (str_phone.equals("")) {
                    Toast.makeText(signup.this, "Please enter your Phone Number.", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(signup.this, "You are Sign up Sucessfully.", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(signup.this, MainActivity.class);
                    intent.putExtra("email", str_email);
                    intent.putExtra("password", str_password);
                    intent.putExtra("phone", str_phone);
                    intent.putExtra("fname",str_fname);
                    intent.putExtra("lname",str_lname);
                    startActivity(intent);
                    finish();
                }

            }
        });

        eye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(signup.this, "eye", Toast.LENGTH_LONG).show();
                showPassword();
            }
        });

    }

    public void showPassword() {
        Log.d("showpass", showpass + "");
        if (showpass == true) {
            et_password.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
            showpass = false;
        } else {
            et_password.setInputType(InputType.TYPE_CLASS_TEXT);
            showpass = true;
        }
    }


}
