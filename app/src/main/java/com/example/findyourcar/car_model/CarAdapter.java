package com.example.findyourcar.car_model;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.findyourcar.R;

import java.util.List;

public class CarAdapter extends  RecyclerView.Adapter<CarAdapter.ViewHolder>{

private final LayoutInflater inflater;
private final List<Cars> car;

    public CarAdapter(LayoutInflater inflater, List<Cars> car) {
        this.inflater = inflater;
        this.car = car;
    }




@Override
public CarAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
        }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(CarAdapter.ViewHolder holder, int position) {
        Cars cars = car.get(position);

        holder.CarView.setImageResource(cars.getCarResource());
        holder.YearView.setText(Integer.toString(cars.getYear()));
        holder.ValueView.setText(Integer.toString(cars.getValue()));
        holder.ModelView.setText(cars.getModel());
        holder.CreatorView.setText(cars.getCreator());
    }



@Override
public int getItemCount() {
        return car.size();
        }

public static class ViewHolder extends RecyclerView.ViewHolder {
    final ImageView CarView;
    final TextView CreatorView, ModelView,YearView,ValueView;
    ViewHolder(View view){
        super(view);

        CarView = view.findViewById(R.id.carView);
        CreatorView = view.findViewById(R.id.creator);
        YearView = view.findViewById(R.id.year);
        ModelView=view.findViewById(R.id.model);
        ValueView = view.findViewById(R.id.value);
        itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Log.e("*******",Integer.toString(getAdapterPosition()));
            }


        });
    }
}
}