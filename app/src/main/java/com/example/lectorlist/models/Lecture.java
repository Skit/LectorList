package com.example.lectorlist.models;

import androidx.annotation.NonNull;

public class Lecture {

    private String date;
    private String theme;
    private String lector;
    private int number;

    public Lecture(int n, @NonNull String d, @NonNull String t, @NonNull String l) {
        number = n;
        date = d;
        theme = t;
        lector = l;
    }

    public String getLector() {
        return lector;
    }

    public String getTheme() {
        return theme;
    }

    @NonNull
    public String getDate() {
        return date;
    }

    public int getNumber() {
        return number;
    }

}
