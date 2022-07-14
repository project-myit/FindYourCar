package com.example.findyourcar.car_model;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.findyourcar.dataBase.DataBase;
import com.example.findyourcar.R;

import java.util.ArrayList;

public class ListViewCarFragment extends Fragment {
Cursor cursor;
    View view;
    SQLiteDatabase database;
    ArrayList<Cars> cars = new ArrayList<Cars>();  @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setInitialData();


    }
    private void setInitialData(){
        getContext().deleteDatabase("CARS1");
        SQLiteOpenHelper helper = new DataBase(getActivity(), "CARS1", null, 1);
        SQLiteDatabase database = helper.getReadableDatabase();
        Cursor cursor = database.query("CARS", new String[]{"MODEL","CREATOR","VALUE","IMAGE_RESOURSE"}, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {

                cars.add(new Cars(

                        cursor.getString(1),     // title
                        cursor.getString(0)    ,

                        cursor.getInt(2),
                        2000,
                        cursor.getInt(3)
                ));

            } while (cursor.moveToNext());
        }

    }


    public ListViewCarFragment() {

    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_list_view_car, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.list);

        CarAdapter adapter = new CarAdapter(getLayoutInflater(), cars);
        recyclerView.setAdapter(adapter);
        return view;
    }
}