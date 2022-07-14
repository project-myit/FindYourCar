package com.example.findyourcar;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.List;

public class ListViewDialog {

    private List<String> list;
    private Context context;
    private Dialog dialog;
    private View view;
    private ListView listView;
    private Button buttonDismiss;

    public ListViewDialog(Context context, List<String> list){
        this.context = context;
        this.list = list;
        setupDialog();
        setupUI();
   setButtonClickListener();
    }

    public void showDialog(){
        dialog.show();
    }

    private void setupDialog(){
        dialog = new Dialog(context);
        view = LayoutInflater.from(context).inflate(R.layout.listview_dialog, null);
        dialog.setContentView(view);
    }

    private void setupUI(){
        listView = view.findViewById(R.id.listView);
        buttonDismiss = view.findViewById(R.id.buttonDismiss);
    }



    private void setButtonClickListener() {
        buttonDismiss.setOnClickListener(e -> dialog.dismiss());
    }
}