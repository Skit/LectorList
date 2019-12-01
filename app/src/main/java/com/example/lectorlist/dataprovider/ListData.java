package com.example.lectorlist.dataprovider;

import com.example.lectorlist.models.Lecture;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class ListData {
    private LinkedHashSet<Lecture> lecturesData = new LinkedHashSet<>();

    public ListData () {
        lecturesData.add(new Lecture("12.11.2019", "Вводное занятие", "Соколов"));
        lecturesData.add(new Lecture("14.11.2019", "View, Layouts", "Соколов"));
        lecturesData.add(new Lecture("16.11.2019", "Drawables", "Соколов"));
        lecturesData.add(new Lecture("19.11.2019", "Activity", "Сафарян"));
        lecturesData.add(new Lecture("21.11.2019", "Адаптеры", "Чумак"));
        lecturesData.add(new Lecture("23.11.2019", "UI: практика", "Кудрявцев"));
        lecturesData.add(new Lecture("26.11.2019", "Custom View", "Кудрявцев"));
        lecturesData.add(new Lecture("28.11.2019", "Touch events", "Бильчук"));
        lecturesData.add(new Lecture("30.11.2019", "Сложные жесты", "Соколов"));
        lecturesData.add(new Lecture("03.12.2019", "Layout & Measurement", "Кудрявцев"));
        lecturesData.add(new Lecture("05.12.2019", "Custom ViewGroup", "Кудрявцев"));
        lecturesData.add(new Lecture("07.12.2019", "Анимации", "Чумак"));
        lecturesData.add(new Lecture("10.12.2019", "Практика View", "Соколов"));
        lecturesData.add(new Lecture("12.12.2019", "Фрагменты: база", "Бильчук"));
        lecturesData.add(new Lecture("14.12.2019", "Фрагменты: практика", "Соколов"));
        lecturesData.add(new Lecture("17.12.2019", "Фоновая работа", "Чумак"));
        lecturesData.add(new Lecture("19.12.2019", "Абстракции фон/UI", "Леонидов"));
        lecturesData.add(new Lecture("21.12.2019", "Фон: практика", "Чумак"));
        lecturesData.add(new Lecture("14.01.2020", "BroadcastReceiver", "Бильчук"));
        lecturesData.add(new Lecture("16.01.2020", "Runtime permissions", "Кудрявцев"));
        lecturesData.add(new Lecture("18.01.2020", "Service", "Леонидов"));
        lecturesData.add(new Lecture("21.01.2020", "Service: практика", "Леонидов"));
        lecturesData.add(new Lecture("23.01.2020", "Service: биндинг", "Леонидов"));
        lecturesData.add(new Lecture("25.01.2020", "Preferences", "Сафарян"));
        lecturesData.add(new Lecture("28.01.2020", "SQLite", "Бильчук"));
        lecturesData.add(new Lecture("30.01.2020", "SQLite: Room", "Соколов"));
        lecturesData.add(new Lecture("01.02.2020", "ContentProvider", "Сафарян"));
        lecturesData.add(new Lecture("04.02.2020", "FileProvider", "Соколов"));
        lecturesData.add(new Lecture("06.02.2020", "Геолокация", "Леонидов"));
        lecturesData.add(new Lecture("08.02.2020", "Material", "Чумак"));
        lecturesData.add(new Lecture("11.02.2020", "UI-тесты", "Сафарян"));
        lecturesData.add(new Lecture("13.02.2020", "Финал", "Соколов"));
    }

    public List<Lecture> getAll() {
        return new ArrayList<>(lecturesData);
    }
}
