package com.example.findyourcar.dataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.findyourcar.R;

public class DataBase extends SQLiteOpenHelper {
    private final int DB_VERSION = 1;


    public DataBase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }




    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        updateMyDatabase(sqLiteDatabase,0,2);

      //  insertCar(sqLiteDatabase, 2,"Fera", "Italy",3650,"M2","VVV",R.drawable.ic_baseline_directions_car2_24);

        // insertCar(sqLiteDatabase,"Porshe","Italy",R.drawable.ferra);
        // insertCar(sqLiteDatabase,"WW","Germany",R.drawable.ferra);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {




    }

    private void updateMyDatabase(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion){

        sqLiteDatabase.execSQL("CREATE TABLE CARS (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NAME TEXT,"+"CREATOR TEXT,"+ "VALUE INTEGER,"+"MODEL TEXT,"+
                "DILER_CENTER TEXT,"+ "HEADLIGHTS TEXT,"+ "TRANSMISSIONON TEXT,"+
                "HELP_SYSTEMS TEXT,"+
                "SYSTEM_CRUISE_CONTROL BOOLEAN,"+
                "SYSTEM_REAR_VIEW_CAMERA BOOLEAN,"+
                "SYSTEM_PARKING_SENSORS BOOLEAN,"+
                "SYSTEM_ABS BOOLEAN,"+
                "SYSTEM_ESP BOOLEAN,"+
                "IMAGE_RESOURSE INTEGER);");






        insertCar(sqLiteDatabase, "CAR1", "RENAULT",36500,"LOGAN STEPWA","null", R.drawable.renault_logan);
        insertCar(sqLiteDatabase, "CAR2", "RENAULT",36500,"DUSTER","null", R.drawable.renault_duster);
        insertCar(sqLiteDatabase, "CAR3", "RENAULT",36500,"KAPTUR","null", R.drawable.renault_kaptur);
        insertCar(sqLiteDatabase, "CAR4", "RENAULT",36500,"ARKANA","null", R.drawable.renault_arkana);
        insertCar(sqLiteDatabase, "CAR5", "RENAULT",36500,"KOLEOS","null", R.drawable.renault_koleos);


    }
    private static  void insertCar(SQLiteDatabase db,String name,String creator,int value,String model,String diller,   int resourseId){

        ContentValues carValues = new ContentValues();

        carValues.put("NAME",name);
        carValues.put("CREATOR",creator);
        carValues.put("VALUE",value);
        carValues.put("MODEL",model);
        carValues.put("DILER_CENTER",diller);
        carValues.put("IMAGE_RESOURSE",resourseId);
      long i = db.insert("CARS",null, carValues);



    }


}

