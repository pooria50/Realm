package com.example.pooria.myapplication.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pooria.myapplication.R;
import com.example.pooria.myapplication.model;

import io.realm.Realm;
import io.realm.RealmResults;

public class LoginUserActivity extends AppCompatActivity {
    EditText edt_username,edt_userpass;
    Button btn_Login,btn_Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);
        getContorls();

        final Realm realm = Realm.getDefaultInstance();


        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RealmResults<model> results = realm.where(model.class).equalTo(
                        "username",edt_username.getText().toString()).findAll();

                for (int i = 0 ; i<results.size() ; i++ ){
                    Toast.makeText(LoginUserActivity.this,"row:"+results.get(i).getPhone(),Toast.LENGTH_LONG).show();

                }
            }
        });

        btn_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginUserActivity.this, RegisterUserActivity.class);
                startActivity(intent);
            }
        });
    }

    private void getContorls() {
        edt_username = findViewById(R.id.edt_username);
        edt_userpass = findViewById(R.id.edt_userpass);
        btn_Login = findViewById(R.id.btn_Login);
        btn_Register = findViewById(R.id.btn_Register);
    }
}
