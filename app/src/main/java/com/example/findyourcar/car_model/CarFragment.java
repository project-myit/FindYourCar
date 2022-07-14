package com.example.findyourcar.car_model;

import android.icu.text.Transliterator;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.findyourcar.R;


public  class CarFragment extends Fragment {
    int position;
    public void cursorPosition (int position) { this.position = position; }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_car2, container, false);
    }
}