package com.example.thuchanh1.model;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thuchanh1.DatabaseGenericHelper;
import com.example.thuchanh1.ParamFilterQuery;
import com.example.thuchanh1.R;

import java.util.ArrayList;
import java.util.List;

public class Fragment3 extends Fragment {

    DatabaseGenericHelper databaseGenericHelper;
    RecyclerView recyclerView;
    SearchView searchView;
    List<ItemRC> list;
    ItemAdapter itemAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment3,container,false);

        recyclerView = view.findViewById(R.id.rcSearch);
        searchView = view.findViewById(R.id.searchView);
        databaseGenericHelper = new DatabaseGenericHelper(getContext(),new ItemRC());
        list = (List<ItemRC>) databaseGenericHelper.getList(null);
        itemAdapter = new ItemAdapter(getContext(),databaseGenericHelper,list);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),1));
        recyclerView.setAdapter(itemAdapter);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                List<ParamFilterQuery> listParamFilter = new ArrayList<ParamFilterQuery>();
                listParamFilter.add(new ParamFilterQuery("title",query,"LIKE"));
                list = (List<ItemRC>) databaseGenericHelper.getList(listParamFilter);
                itemAdapter.reloadList(list);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(newText.length() == 0)
                {
                    list = (List<ItemRC>) databaseGenericHelper.getList(null);
                    itemAdapter.reloadList(list);
                }
                return true;
            }
        });

        return view;
    }
}
