package com.example.thuchanh1.model;

import android.database.Cursor;

import com.example.thuchanh1.BaseClass;

public class ItemRC extends BaseClass {
    private int imageRC;
    private String title;
    private String content;

    public ItemRC()
    {

    }

    public ItemRC(int imageRC, String title, String content) {
        this.imageRC = imageRC;
        this.title = title;
        this.content = content;
    }

    public int getImageRC() {
        return imageRC;
    }

    public void setImageRC(int imageRC) {
        this.imageRC = imageRC;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    protected void initWithCursor(Cursor cursor)
    {
        this.id = cursor.getInt(0);
        this.imageRC = cursor.getInt(2);
        this.title = cursor.getString(3);
        this.content = cursor.getString(1);
    }
}
