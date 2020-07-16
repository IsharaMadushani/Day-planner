package com.industrialmaster.dayplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.industrialmaster.dayplanner.R;

public class DoctorAppointmentAddActivity extends AppCompatActivity {
    EditText etName,etDate,etTime,etPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_appointment_add);
        etName = findViewById(R.id.lbl_appointment_name);
        etDate = findViewById(R.id.lbl_appointment_date);
        etTime = findViewById(R.id.lbl_appointment_time);
        etPerson = findViewById(R.id.lbl_appointment_person);
    }

    public void save(View v){
        String name=etName.getText().toString();
        String date=etDate.getText().toString();
        String time=etTime.getText().toString();
        String person=etPerson.getText().toString();
        DBHelper helper =  new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();

        String sql = "INSERT INTO appointments(name,date,time,person,complete)VALUES('"+name+"','"+date+"','"+time+"','"+person+"','false')";
        db.execSQL(sql);

        Toast.makeText(this, "saved",Toast.LENGTH_SHORT).show();
    }
}
