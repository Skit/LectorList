package com.example.lectorlist.adapters;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lectorlist.R;
import com.example.lectorlist.dataprovider.ListData;
import com.example.lectorlist.models.Group;
import com.example.lectorlist.models.Lecture;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class LecturesAdapter extends RecyclerView.Adapter<LecturesAdapter.BaseViewHolder> {

    private static final int ITEM_VIEW_TYPE_LECTURE = 0;
    private static final int ITEM_VIEW_TYPE_WEEK = 1;

    private List<Object> adapterItems;
    private List<Lecture> lectures;
    private final Resources resources;
    private Group group = Group.UNGROUPED;

    public LecturesAdapter(Resources r) {
        resources = r;
    }

    @NonNull
    @Override
    public LecturesAdapter.BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case ITEM_VIEW_TYPE_LECTURE: {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_lecture, parent, false);
                return new LectureHolder(view);
            }
            case ITEM_VIEW_TYPE_WEEK: {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_week, parent, false);
                return new WeekHolder(view);
            }
            default:
                throw new IllegalArgumentException("ViewType " + viewType + " is not supported");
        }
    }

    @Override
    public void onBindViewHolder(@NonNull LecturesAdapter.BaseViewHolder holder, int position) {
        Object item = adapterItems.get(position);
        switch (getItemViewType(position)) {
            case ITEM_VIEW_TYPE_LECTURE:
                ((LectureHolder) holder).bindView((Lecture) item);
                break;
            case ITEM_VIEW_TYPE_WEEK:
                ((WeekHolder) holder).bindView((String) item);
                break;
            default:
                throw new RuntimeException("The following item is not supported by adapter: " + item);
        }
    }

    @Override
    public int getItemCount() {
        return adapterItems == null ? 0 : adapterItems.size();
    }

    public void setLectures(@Nullable List<Lecture> lcs) {

        if (lectures == null) {
            lectures = new ArrayList<>();
        }

        lectures = new ArrayList<>(lcs);
        switch (group) {
            case BY_WEEK:
                groupByWeek(lcs);
                break;
            case UNGROUPED:
            default:
                adapterItems = new ArrayList<Object>(lcs);
        }

        notifyDataSetChanged();
    }

    private void groupByWeek(@NonNull List<Lecture> lectures) {
        adapterItems = new ArrayList<>();
        int week = 0;
        int curWeek;
        int startWeek = 0;
        for (Lecture lecture : lectures) {
            curWeek = getWeekOfYear(lecture);

            if (curWeek != week) {
                week = curWeek;
                startWeek++;
            }
            adapterItems.add(resources.getString(R.string.week_number, startWeek));
            adapterItems.add(lecture);
        }
    }

    public void setGroup(@NonNull Group g) {
        group = g;
        setLectures(lectures);
    }

    static abstract class BaseViewHolder extends RecyclerView.ViewHolder {
        BaseViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    private int getWeekOfYear(Lecture l) {
        int week = 0;
        SimpleDateFormat df = new SimpleDateFormat(ListData.getDataFormat());
        try {
            Date date = df.parse(l.getDate());
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            week = cal.get(Calendar.WEEK_OF_MONTH);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return week;
    }

    @Override
    public int getItemViewType(int position) {
        Object item = adapterItems.get(position);
        if (item instanceof Lecture) {
            return ITEM_VIEW_TYPE_LECTURE;
        } else if (item instanceof String) {
            return ITEM_VIEW_TYPE_WEEK;
        } else {
            throw new RuntimeException("The following item is not supported by adapter: " + item);
        }
    }

    private static class LectureHolder extends BaseViewHolder {
        private final TextView lector;
        private final TextView date;
        private final TextView theme;
        private final TextView number;

        private LectureHolder(@NonNull View itemView) {
            super(itemView);
            lector = itemView.findViewById(R.id.lector);
            theme = itemView.findViewById(R.id.theme);
            date = itemView.findViewById(R.id.date);
            number = itemView.findViewById(R.id.number);
        }

        private void bindView(Lecture lecture) {
            date.setText(lecture.getDate());
            theme.setText(lecture.getTheme());
            lector.setText(lecture.getLector());
            number.setText(String.valueOf(lecture.getNumber()));
        }
    }

    private static class WeekHolder extends BaseViewHolder {
        private final TextView wEek;

        private WeekHolder(@NonNull View itemView) {
            super(itemView);
            wEek = itemView.findViewById(R.id.week);
        }

        private void bindView(String week) {
            wEek.setText(week);
        }
    }
}
