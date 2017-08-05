package com.example.macstudent.c0696397_test1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {
    EditText uname,password;
    Button login,signup;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uname = (EditText)findViewById(R.id.uname);
        password = (EditText)findViewById(R.id.password);
        login= (Button) findViewById(R.id.login);
        signup= (Button) findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Signup.class));
            }
        });

        login.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String user = uname.getText().toString();
                String pass = password.getText().toString();

                if (user=="admin" && pass=="admin123"){
                    Intent mIntent = new Intent(MainActivity.this, PostsActivity.class);
                    startActivity(mIntent);

                }
                else{

                }
            }
        });


    }



}
