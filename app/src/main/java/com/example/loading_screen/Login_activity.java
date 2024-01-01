package com.example.loading_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Login_activity extends AppCompatActivity {
EditText email,name,phnum;
    Button btn;
    ProgressBar loading_bar_login;
TextView emailshow,nameshow;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
email=findViewById(R.id.email);
btn=findViewById(R.id.btn);
name=findViewById(R.id.name);
nameshow=findViewById(R.id.nameshow);
phnum=findViewById(R.id.phonenum);
        loading_bar_login=findViewById(R.id.loading_bar_login);
btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if (email.getText().toString().length()!= 0&&phnum.getText().toString().length()!=0&&name.getText().toString().length()!=0) {
           // SharedPreferences pref =getSharedPreferences("name",MODE_PRIVATE);
            //SharedPreferences.Editor editor= pref.edit();
            //editor.putBoolean("flag",true);
            //editor.apply();
            // Get the SharedPreferences object
            loading_bar_login.setVisibility(View.VISIBLE);
            SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

// Get the SharedPreferences editor to write data
            SharedPreferences.Editor editor = sharedPreferences.edit();

// Store the email address
            String userEmail =email.getText().toString();
            String username=name.getText().toString();
            String userphnum=phnum.getText().toString();

                                  // Replace this with the actual email
            editor.putString("email", userEmail);
            editor.putString("name",username);
            editor.putString("phnum",userphnum);
            editor.apply(); // Commit the changes
            Intent inext= new Intent(Login_activity.this, MainActivity2.class);
            startActivity(inext);
           emailshow = findViewById(R.id.emailshow);
            String emailstring = email.getText().toString();
            String namestring=name.getText().toString();

            //emailshow.setText("" + emailstring);
           // nameshow.setText(""+namestring);

        }else{
            Toast.makeText(Login_activity.this, "please fill the details", Toast.LENGTH_SHORT).show();
        }
    }
});
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(this, "loginFailed", Toast.LENGTH_SHORT).show();
        finishAffinity();
    }

}