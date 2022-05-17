package com.example.thuchanh1.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.thuchanh1.R;

import java.util.zip.Inflater;

public class SpinnerAdapter extends BaseAdapter {

    private int[] listImage = new int[]{R.drawable.anh1,R.drawable.anh2,R.drawable.anh3};
    Context context;

    public SpinnerAdapter(Context context)
    {
        this.context = context;
    }

    @Override
    public int getCount() {
        return listImage.length;
    }

    @Override
    public Object getItem(int i) {
        return listImage[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View itemView = LayoutInflater.from(context).inflate(R.layout.item_spinner,viewGroup,false);
        ImageView imageView = itemView.findViewById(R.id.image_spinner);
        imageView.setImageResource(listImage[i]);
        return itemView;
    }
}
