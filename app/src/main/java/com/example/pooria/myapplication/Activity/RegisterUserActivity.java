package com.example.pooria.myapplication.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pooria.myapplication.R;
import com.example.pooria.myapplication.model;

import io.realm.Realm;
import io.realm.RealmResults;

public class RegisterUserActivity extends AppCompatActivity {

    Button btnSave,show;
    EditText edt_name, edt_family,edt_phone,edt_email,edt_codemelli,edt_address,edt_codeposty,edt_username,edt_userpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindCOntrols();

        final Realm realm = Realm.getDefaultInstance();
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                realm.executeTransactionAsync(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {

                        String name = edt_name.getText().toString();
                        String family = edt_family.getText().toString();
                        String email = edt_email.getText().toString();
                        String address = edt_address.getText().toString();
                        String username = edt_username.getText().toString();
                        String userpass = edt_userpass.getText().toString();
                        Long phone = Long.valueOf(edt_phone.getText().toString());
                        Long codemelli = Long.valueOf(edt_codemelli.getText().toString());
                        Long codeposty = Long.valueOf(edt_codeposty.getText().toString());

                        model model = realm.createObject(model.class);
                        model.setName(name);
                        model.setFamily(family);
                        model.setPhone(phone);
                        model.setEmail(email);
                        model.setCodemelli(codemelli);
                        model.setAddress(address);
                        model.setCodeposty(codeposty);
                        model.setUsername(username);
                        model.setUserpass(userpass);
                    }
                }, new Realm.Transaction.OnSuccess() {
                    @Override
                    public void onSuccess() {
                        Log.i("test12", "Saved Dates");
                        Toast.makeText(RegisterUserActivity.this, "Insert Compeleted : ) ", Toast.LENGTH_SHORT).show();
                    }
                }, new Realm.Transaction.OnError() {
                    @Override
                    public void onError(Throwable error) {
                        Log.i("test12","error");
                        Toast.makeText(RegisterUserActivity.this, "Insert Failed : ( ", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });



        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                RealmResults<model> results = realm.where(model.class).equalTo("name",edt_name.getText().toString()).findAll();

                for (int i = 0 ; i<results.size() ; i++ ){
                    Toast.makeText(RegisterUserActivity.this,"row:"+results.get(i).getPhone(),Toast.LENGTH_LONG).show();

                }


            }
        });
    }

    private void bindCOntrols() {
        btnSave = findViewById(R.id.btnSave);
        show = findViewById(R.id.show);
        edt_name = findViewById(R.id.edt_name);
        edt_family = findViewById(R.id.edt_family);
        edt_phone = findViewById(R.id.edt_phone);
        edt_email = findViewById(R.id.edt_email);
        edt_codemelli = findViewById(R.id.edt_codemelli);
        edt_address = findViewById(R.id.edt_address);
        edt_codeposty = findViewById(R.id.edt_codeposty);
        edt_username = findViewById(R.id.edt_username);
        edt_userpass = findViewById(R.id.edt_userpass);

    }
}
