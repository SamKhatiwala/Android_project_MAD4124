package com.example.macstudent.c0696397_test1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import io.realm.Realm;

/**
 * Created by macstudent on 2017-08-04.
 */

public class Signup extends AppCompatActivity {
    EditText uname,password;
    Button btn;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        uname = (EditText) findViewById(R.id.uname);
        password = (EditText) findViewById(R.id.password);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Realm.init(getApplicationContext());
                realm=Realm.getDefaultInstance();
                UserData obj=new UserData();
                obj.username=uname.getText().toString();
                obj.password=password.getText().toString();
                realm.beginTransaction();
                realm.copyToRealm(obj);
                realm.commitTransaction();
                Toast.makeText(Signup.this, "Saved To Realm", Toast.LENGTH_SHORT).show();
               sendMessage(view);

            }
        });
    }

        public void sendMessage(View view) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
}
