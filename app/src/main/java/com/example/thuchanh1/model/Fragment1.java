package com.example.thuchanh1.model;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.thuchanh1.DatabaseGenericHelper;
import com.example.thuchanh1.R;

import java.util.List;

public class Fragment1 extends Fragment {

    private RecyclerView recyclerView;
    private DatabaseGenericHelper databaseGenericHelper;
    private List<ItemRC> list;
    private ItemAdapter itemAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment1,container,false);
        recyclerView = view.findViewById(R.id.recyleView);
        databaseGenericHelper = new DatabaseGenericHelper(getContext(),new ItemRC());

        list = (List<ItemRC>) databaseGenericHelper.getList(null);
        itemAdapter = new ItemAdapter(getContext(),databaseGenericHelper,list);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),1));
        recyclerView.setAdapter(itemAdapter);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        list = (List<ItemRC>) databaseGenericHelper.getList(null);
        itemAdapter.reloadList(list);
        Toast.makeText(getContext(), "heloo ádhkasjd", Toast.LENGTH_SHORT).show();
    }
}
