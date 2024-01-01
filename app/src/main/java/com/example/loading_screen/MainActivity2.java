package com.example.loading_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
TextView text_main2,text_main2_username;
Button city_ok,booknowbtn_home;
Spinner city_home;
ProgressBar progressbar_home;
    @SuppressLint({"MissingInflatedId", "ResourceType"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        text_main2=findViewById(R.id.text_main2);
        text_main2_username=findViewById(R.id.text_main2_username);
        city_home=findViewById(R.id.city_home);

        booknowbtn_home=findViewById(R.id.booknowbtn_home);
        progressbar_home=findViewById(R.id.progressbar_home);
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs",MODE_PRIVATE);
        String storedEmail = sharedPreferences.getString("email", null);
        String storedname=sharedPreferences.getString("name",null);
        if (storedEmail!=null){
            text_main2.setText(storedEmail.toString());
            text_main2_username.setText(storedname.toString());
        }





        ArrayList<String> spinnerarray=new ArrayList<>();
        spinnerarray.add("Hyderabad");
        spinnerarray.add("Siddipet");
        spinnerarray.add("Secunderabad");
        spinnerarray.add("Ahmedabad");
        spinnerarray.add("Bangalore");
        spinnerarray.add("Chennai");
        spinnerarray.add("Delhi");
        spinnerarray.add("Mumbai");
        spinnerarray.add("Pune");
        spinnerarray.add("Lucknow");
        spinnerarray.add("Kolkata");

        ArrayAdapter<String> spinnerarrayadapter=new ArrayAdapter<>(this, androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item,spinnerarray);
        city_home.setAdapter(spinnerarrayadapter);

        booknowbtn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressbar_home.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent i=new Intent(MainActivity2.this, MainActivity3.class);
                        startActivity(i);
                        progressbar_home.setVisibility(View.GONE);
                    }
                },1500);

            }
        });

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();

        finishAffinity();

    }
}