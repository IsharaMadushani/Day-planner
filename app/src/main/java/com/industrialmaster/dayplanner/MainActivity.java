package com.industrialmaster.dayplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*@Override
    protected void onResume() {
        super.onResume();

        SharedPreferences profile = getSharedPreferences("profile", Context.MODE_PRIVATE);

        TextView tvName = findViewById(R.id.my_name);
        TextView tvEmail = findViewById(R.id.my_email);
        TextView tvMobile = findViewById(R.id.my_mobile);

        String name = profile.getString("name","");
        String email = profile.getString("email","");
        String mobile = profile.getString("mobile","");

        tvName.setText(name);
        tvEmail.setText(email);
        tvMobile.setText(mobile);
    }*/
    public void meetings(View v){
        Intent intent = new Intent(this,MeetingsActivity.class);
        startActivity(intent);

    }

    public void appointment(View v){
        Intent intent = new Intent(this, DoctorAppointmentActivity.class);
        startActivity(intent);
    }
    public void tasks(View v){
        Intent intent = new Intent(this, OfficeTaskActivity.class);
        startActivity(intent);
    }


    public void contacts(View v){
        Intent intent = new Intent(this, SpecialContactsActivity.class);
        startActivity(intent);
    }

    public void profile(View v){
        Intent intent = new Intent(this, MyProfileActivity.class);
        startActivity(intent);
    }
}
