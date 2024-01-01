package com.example.loading_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //SharedPreferences pref =getSharedPreferences("name",MODE_PRIVATE);
                //Boolean check = pref.getBoolean("flag",false);
                //Intent in;
                // Get the SharedPreferences object
                SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs",MODE_PRIVATE);

// Retrieve the stored email address
                String storedEmail = sharedPreferences.getString("email", null);
                Intent i;
                if (storedEmail != null) {
                    // Use the stored email address
                    // For example, you can set it to a TextView
                    i=new Intent(MainActivity.this, MainActivity2.class);


                } else {
                    // No stored email found
                    i=new Intent(MainActivity.this, getstarted_page.class);
                }
                startActivity(i);
                //if (check){
                  //  in=new Intent(MainActivity.this, MainActivity2.class);
                //}else {
                  //  in=new Intent(MainActivity.this, Login_activity.class);
                //}
               // startActivity(in);
               // Intent i = new Intent(MainActivity.this, Login_activity.class);
                //startActivity(i);
              // finish();
            }
        }, 2000);

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }
}