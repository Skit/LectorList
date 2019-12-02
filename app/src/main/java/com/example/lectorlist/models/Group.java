package com.example.lectorlist.models;

import androidx.annotation.StringRes;
import com.example.lectorlist.R;

public enum Group {

    UNGROUPED(R.string.prompt),
    BY_WEEK(R.string.by_week);

    @StringRes
    private final int stringResourceId;

    Group(@StringRes int sri) {
        stringResourceId = sri;
    }

    @StringRes
    public int getStringResourceId() {
        return stringResourceId;
    }
}
