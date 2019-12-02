package com.example.lectorlist;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.lectorlist.adapters.LecturesAdapter;
import com.example.lectorlist.adapters.SpinnerAdapter;
import com.example.lectorlist.adapters.SpinnerGroupAdapter;
import com.example.lectorlist.dataprovider.ListData;
import com.example.lectorlist.models.Group;
import com.example.lectorlist.models.Lecture;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int PROMPT = 0;

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

        Spinner spinner = findViewById(R.id.lectors_spinner);
        final List<String> spinnerItems = listData.getAllLectors();
        Collections.sort(spinnerItems);
        spinnerItems.add(PROMPT, getResources().getString(R.string.prompt));
        SpinnerAdapter adapter = new SpinnerAdapter(spinnerItems);
        spinner.setAdapter(adapter);

        Spinner spinner2 = findViewById(R.id.mode_spinner);
        spinner2.setAdapter(new SpinnerGroupAdapter());


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                final List<Lecture> lectures = position == PROMPT ?
                        listData.getAll() :
                        listData.filter(spinnerItems.get(position));
                lecturesAdapter.setLectures(lectures);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Group selectedGroup = Group.values()[position];
                lecturesAdapter.setGroup(selectedGroup);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
