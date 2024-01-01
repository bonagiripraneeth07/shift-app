package com.example.loading_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class getstarted_page extends AppCompatActivity {
Button getstarted_btn;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getstarted_page);
        getstarted_btn=findViewById(R.id.getstarted_btn);
        getstarted_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getstarted_page.this, Login_activity.class);
                startActivity(i);
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