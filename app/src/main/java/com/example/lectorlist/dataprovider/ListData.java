package com.example.lectorlist.dataprovider;

import com.example.lectorlist.models.Lecture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListData {
    private List<Lecture> lecturesData = Arrays.asList(
            new Lecture(1, "12.11.2019", "Вводное занятие", "Соколов"),
            new Lecture(2, "14.11.2019", "View, Layouts", "Соколов"),
            new Lecture(3, "16.11.2019", "Drawables", "Соколов"),
            new Lecture(4, "19.11.2019", "Activity", "Сафарян"),
            new Lecture(5, "21.11.2019", "Адаптеры", "Чумак"),
            new Lecture(6, "23.11.2019", "UI: практика", "Кудрявцев"),
            new Lecture(7, "26.11.2019", "Custom View", "Кудрявцев"),
            new Lecture(8, "28.11.2019", "Touch events", "Бильчук"),
            new Lecture(9, "30.11.2019", "Сложные жесты", "Соколов"),
            new Lecture(10, "03.12.2019", "Layout & Measurement", "Кудрявцев"),
            new Lecture(11, "05.12.2019", "Custom ViewGroup", "Кудрявцев"),
            new Lecture(12, "07.12.2019", "Анимации", "Чумак"),
            new Lecture(13, "10.12.2019", "Практика View", "Соколов"),
            new Lecture(14, "12.12.2019", "Фрагменты: база", "Бильчук"),
            new Lecture(15, "14.12.2019", "Фрагменты: практика", "Соколов"),
            new Lecture(16, "17.12.2019", "Фоновая работа", "Чумак"),
            new Lecture(17, "19.12.2019", "Абстракции фон/UI", "Леонидов"),
            new Lecture(18, "21.12.2019", "Фон: практика", "Чумак"),
            new Lecture(19, "14.01.2020", "BroadcastReceiver", "Бильчук"),
            new Lecture(20, "16.01.2020", "Runtime permissions", "Кудрявцев"),
            new Lecture(21, "18.01.2020", "Service", "Леонидов"),
            new Lecture(22, "21.01.2020", "Service: практика", "Леонидов"),
            new Lecture(23, "23.01.2020", "Service: биндинг", "Леонидов"),
            new Lecture(24, "25.01.2020", "Preferences", "Сафарян"),
            new Lecture(25, "28.01.2020", "SQLite", "Бильчук"),
            new Lecture(26, "30.01.2020", "SQLite: Room", "Соколов"),
            new Lecture(27, "01.02.2020", "ContentProvider", "Сафарян"),
            new Lecture(28, "04.02.2020", "FileProvider", "Соколов"),
            new Lecture(29, "06.02.2020", "Геолокация", "Леонидов"),
            new Lecture(30, "08.02.2020", "Material", "Чумак"),
            new Lecture(31, "11.02.2020", "UI-тесты", "Сафарян"),
            new Lecture(32, "13.02.2020", "Финал", "Соколов")
    );

    public List<Lecture> getAll() {
        return new ArrayList<>(lecturesData);
    }

    public List<String> getAllLectors() {
        Set<String> lectorsSet = new HashSet<>();
        for (Lecture lecture : lecturesData) {
            lectorsSet.add(lecture.getLector());
        }

        return new ArrayList<>(lectorsSet);
    }

    public List<Lecture> filter(String lectorName) {
        List<Lecture> result = new ArrayList<>();
        for (Lecture lecture : lecturesData) {

            if (lecture.getLector().equals(lectorName)) {
                result.add(lecture);
            }
        }

        return result;
    }

    public static String getDataFormat() {
        return "dd.MM.yyyy";
    }
}
