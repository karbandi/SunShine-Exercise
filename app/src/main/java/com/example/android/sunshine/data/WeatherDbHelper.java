package com.example.android.sunshine.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class WeatherDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="weather.db";
    private static final int DATABASE_VERSION=2;
    public WeatherDbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String Create="create table "+WeatherContract.WeatherEntry.TABLE_NAME+"(" +
                WeatherContract.WeatherEntry._ID+" integer primary key autoincrement ," +
                WeatherContract.WeatherEntry.COLUMN_DATE +" integer not null,"+
                WeatherContract.WeatherEntry.COLUMN_WEATHER_ID +" integer not null,"+
                WeatherContract.WeatherEntry.COLUMN_MAX_TEMP +" Real not null,"+
                WeatherContract.WeatherEntry.COLUMN_MIN_TEMP +" Real not null,"+
                WeatherContract.WeatherEntry.COLUMN_DEGREES +" Real not null,"+
                WeatherContract.WeatherEntry.COLUMN_HUMIDITY +" Real not null,"+
                WeatherContract.WeatherEntry.COLUMN_PRESSURE +" Real not null,"+
                WeatherContract.WeatherEntry.COLUMN_WIND_SPEED +" Real  not null "
                + ");";
        sqLiteDatabase.execSQL(Create);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists "+ WeatherContract.WeatherEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);

    }
}
