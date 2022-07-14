package com.example.findyourcar.dataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import androidx.annotation.Nullable;

import com.example.findyourcar.R;

public class GpsDataBase extends SQLiteOpenHelper {

    public GpsDataBase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        updateMyDatabase(sqLiteDatabase,0,2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        updateMyDatabase(sqLiteDatabase,i,i1);


    }

    private void updateMyDatabase(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion){
        //sqLiteDatabase.delete("GPS",null,null);
        sqLiteDatabase.execSQL("CREATE TABLE GPS (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NAME TEXT,"+
                "X_DILER_CENTER_GPS DOUBLE,"+
                "Y_DILER_CENTER_GPS DOUBLE,"+
                "DILER_CENTER_DRAWABLE INTEGER);");
        insertGps(sqLiteDatabase,"Renault",52.11105,23.75624, R.drawable.renault);
        insertGps(sqLiteDatabase,"Nissan",52.11090,23.75601,R.drawable.nissan);
        insertGps(sqLiteDatabase,"SKODA",52.121861,23.771285,R.drawable.skoda);
        insertGps(sqLiteDatabase,"KIA MOTORS",52.076428,23.739745,R.drawable.kia);
        insertGps(sqLiteDatabase,"Geely",52.075395,23.730597,R.drawable.geely);

    }
    private static  void insertGps(SQLiteDatabase db, String name, double x , double y,int drawable){

        ContentValues gpsValues = new ContentValues();

     gpsValues.put("NAME", name);
     gpsValues.put("X_DILER_CENTER_GPS",x);
     gpsValues.put("Y_DILER_CENTER_GPS",y);
     gpsValues.put("DILER_CENTER_DRAWABLE",drawable);
        long i=db.insert("GPS",null, gpsValues);
        Log.e( "***",Long.toString(i));


    }


}

