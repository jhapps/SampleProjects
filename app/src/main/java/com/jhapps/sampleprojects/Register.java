package com.jhapps.sampleprojects;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity implements View.OnClickListener{

    //Step 1: Global Variables
    EditText editText_Username;
    EditText editText_Password;
    Button button_Register;

    SharedPreferences.Editor setPrefs;
    SharedPreferences getPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Step 2: Calling Views
        init();

        //Step 3: Handle Events
        handleevents();

    }

    protected void init(){
        editText_Username = findViewById(R.id.edittext_register_username);
        editText_Password = findViewById(R.id.edittext_register_password);
        button_Register = findViewById(R.id.button_register_register);

        setPrefs = getSharedPreferences("DatabasePrefs", MODE_PRIVATE).edit();
        getPrefs = getSharedPreferences("DatabasePrefs", MODE_PRIVATE);
    }

    protected void handleevents(){
        button_Register.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == button_Register){
            setPrefs.putString("Username", editText_Username.getText().toString());
            setPrefs.putString("Password", editText_Password.getText().toString());
            setPrefs.apply();
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
        }
    }
}
