package com.industrialmaster.dayplanner;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MeetingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meetings);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MeetingsActivity.this , MeetingsAddActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        ListView lv=findViewById(R.id.meeting_list);
        List<String> list = new ArrayList<>();

        DBHelper helper =new DBHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();

        String sql = "SELECT* FROM meetings WHERE complete='false'";
        Cursor cursor = db.rawQuery(sql, null);
        //cursor.moveToFirst();
        //while(cursor.isAfterLast()==false){

        //  String name=cursor.getString(1);
        //  String date=cursor.getString(2);
        //   list.add(name+" /" +date);
        //   cursor.moveToNext();

        {
        }
        //  int layout = android.R.layout.simple_list_item_1;
        // ArrayAdapter adapter =new ArrayAdapter(this,layout,list);
        int layout =  R.layout.singletask1;
        int[] views = {R.id.lbl_meeting_name,R.id.lbl_meeting_date,R.id.lbl_meeting_time,R.id.lbl_meeting_person,R.id.lbl_meeting_id}; //views 3 variable 3 kata nam karagannawa
        String[] cols = {"name","date","time","person","_id"};   //me colomns walin data aran uda tyna views walata set karanna oana


        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,layout,cursor,cols,views);

        lv.setAdapter(adapter);
    }
    public void complete(View v){

        LinearLayout layout =(LinearLayout) v.getParent();
        TextView tv = layout.findViewById(R.id.lbl_meeting_id);

        String id = tv.getText().toString();



        DBHelper myDB = new DBHelper(this);
        SQLiteDatabase db = myDB.getWritableDatabase();

        String sql ="UPDATE meetings SET complete='true' WHERE _id=' "+id+"'";
        db.execSQL(sql);

        Toast.makeText(this,"Meeting is completed !",Toast.LENGTH_SHORT).show();
        onResume();
    }
}
