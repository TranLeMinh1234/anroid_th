package com.example.thuchanh1.model;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.thuchanh1.DatabaseGenericHelper;
import com.example.thuchanh1.MainActivity;
import com.example.thuchanh1.R;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemVIewHolder>{

    private List<ItemRC> list;
    private DatabaseGenericHelper databaseGenericHelper;
    private Context context;

    public ItemAdapter(Context context, DatabaseGenericHelper databaseGenericHelper, List<ItemRC> reList)
    {
        this.list = reList;
        this.databaseGenericHelper = databaseGenericHelper;
        this.context = context;
    }

    public void reloadList(List<ItemRC> reList)
    {
        this.list = reList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ItemVIewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyleview,parent,false);
        return new ItemVIewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemVIewHolder holder, int position) {
        ItemRC itemRC = list.get(position);
        holder.image.setImageResource(itemRC.getImageRC());
        holder.content.setText(itemRC.getContent());
        holder.title.setText(itemRC.getTitle());
        holder.btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deteleItem(itemRC.getId());
            }
        });
        holder.item_RC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = (SharedPreferences.Editor) ((MainActivity)context).getSharedPreferences("tlminh",Context.MODE_PRIVATE);
                editor.putInt("id",itemRC.getId());
                editor.putString("")
                ((MainActivity)context).viewPager.setCurrentItem(1);
            }
        });
    }

    private void deteleItem(int id)
    {
        this.databaseGenericHelper.deleteById(id);
        list = (List<ItemRC>) this.databaseGenericHelper.getList(null);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ItemVIewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView title,content;
        Button btnXoa;
        LinearLayoutCompat item_RC;
        public ItemVIewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            image = itemView.findViewById(R.id.image);
            content = itemView.findViewById(R.id.content);
            item_RC = itemView.findViewById(R.id.item_rc);
            btnXoa = itemView.findViewById(R.id.btnXoa);
        }
    }
}
