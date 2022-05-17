package com.example.thuchanh1;

import android.database.Cursor;

public class BaseClass {
    protected int id;

    protected void initWithCursor(Cursor cursor)
    {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

