package com.example.lectorlist.models;

import androidx.annotation.NonNull;

public class Lecture {

    private String date;
    private String theme;
    private String lector;

    public Lecture(@NonNull String d, @NonNull String t, @NonNull String l) {
        date = d;
        theme = t;
        lector = l;
    }

    public String getLector() {
        return lector;
    }

}
