package com.example.lectorlist;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.example.lectorlist.models.Lecture;
import java.util.List;

public class LecturesAdapter extends RecyclerView.Adapter<LecturesAdapter.BaseViewHolder> {

    private List<Lecture> lectures;
    private List<Lecture> adapterItems;
    private final Resources resources;

    LecturesAdapter(Resources r) {
        resources = r;
    }

    @NonNull
    @Override
    public LecturesAdapter.BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lecture, parent, false);
        return new LectureHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LecturesAdapter.BaseViewHolder holder, int position) {
        Lecture item = adapterItems.get(position);
        ((LectureHolder) holder).bindView(item);
    }

    @Override
    public int getItemCount() {
        return adapterItems == null ? 0 : adapterItems.size();
    }

    void setLectures(@Nullable List<Lecture> lcs) {
        lectures = lcs;
        adapterItems = lcs;
        notifyDataSetChanged();
    }

    static abstract class BaseViewHolder extends RecyclerView.ViewHolder {

        BaseViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    private static class LectureHolder extends BaseViewHolder {
        private final TextView lector;

        private LectureHolder(@NonNull View itemView) {
            super(itemView);
            lector = itemView.findViewById(R.id.lector);
        }

        private void bindView(Lecture lecture) {
            lector.setText(lecture.getLector());
        }
    }
}
