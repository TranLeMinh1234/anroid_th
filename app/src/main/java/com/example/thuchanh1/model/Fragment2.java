package com.example.thuchanh1.model;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.thuchanh1.DatabaseGenericHelper;
import com.example.thuchanh1.R;

import java.util.List;

public class Fragment2 extends Fragment {

    Spinner spinnerEdit;
    EditText titleEdit,contentEdit;
    DatabaseGenericHelper databaseGenericHelper;
    Button btnAdd, btnUpdate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment2,container,false);
        databaseGenericHelper = new DatabaseGenericHelper(getContext(),new ItemRC());

        spinnerEdit = view.findViewById(R.id.spinnerEdit);
        titleEdit = view.findViewById(R.id.titleEdit);
        contentEdit = view.findViewById(R.id.contentEdit);

        btnAdd = view.findViewById(R.id.btnAdd);
        btnUpdate = view.findViewById(R.id.btnUpdate);
        SpinnerAdapter spinnerAdapter = new SpinnerAdapter(getContext());
        spinnerEdit.setAdapter(spinnerAdapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ItemRC itemRC = new ItemRC(Integer.parseInt(spinnerEdit.getSelectedItem().toString()),titleEdit.getText().toString(),contentEdit.getText().toString());
                databaseGenericHelper.insertRecord(itemRC);
                Toast.makeText(getContext(), "Them thanh cong", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
