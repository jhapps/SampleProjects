package com.jhapps.sampleprojects;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //Step 1: Global Variables
    EditText editText_Username;
    EditText editText_Password;
    Button button_Login;
    Button button_Register;

    SharedPreferences.Editor setPrefs;
    SharedPreferences getPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Step 2: Calling Views
        initialize();

        //Step 3: Handle Events
        handleevents();
    }

    protected void initialize(){
        editText_Username = findViewById(R.id.edittext_username);
        editText_Password = findViewById(R.id.edittext_password);
        button_Login = findViewById(R.id.button_login);
        button_Register = findViewById(R.id.button_register);

        setPrefs = getSharedPreferences("DatabasePrefs", MODE_PRIVATE).edit();
        getPrefs = getSharedPreferences("DatabasePrefs", MODE_PRIVATE);
    }

    protected void handleevents(){
        button_Login.setOnClickListener(this);
        button_Register.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        String username = getPrefs.getString("Username", null);
        String password = getPrefs.getString("Password", null);

        if(view == button_Login){
            if(editText_Username.getText().toString().equals(username)){
                if(editText_Password.getText().toString().equals(password)){
                    Toast.makeText(this, "Successful", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Invalid", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(this, "Username not exist", Toast.LENGTH_SHORT).show();
            }
        }

        if(view == button_Register){
            Intent intent = new Intent(MainActivity.this, Register.class);
            startActivity(intent);
        }
    }























    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
