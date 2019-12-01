package com.example.lectorlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.lectorlist.dataprovider.ListData;
import com.example.lectorlist.models.Lecture;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private ListData listData = new ListData();
    private LecturesAdapter lecturesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.lecture_item);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        lecturesAdapter = new LecturesAdapter(getResources());
        lecturesAdapter.setLectures(listData.getAll());
        recyclerView.setAdapter(lecturesAdapter);
    }
}
