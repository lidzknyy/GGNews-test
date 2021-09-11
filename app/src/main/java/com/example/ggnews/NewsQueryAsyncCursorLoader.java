package com.example.ggnews;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.loader.content.CursorLoader;

public class NewsQueryAsyncCursorLoader extends CursorLoader {
    private Context mContext;

    public NewsQueryAsyncCursorLoader(Context context){
        super(context);
        mContext = context;
    }

    //@Override
    protected void onStarLoading(){
        forceLoad();
    }

    @Override
    public Cursor loadInBackground(){
        MySQLiteOpenHelper dbOpenHelper = new MySQLiteOpenHelper(mContext);
        SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
        Cursor cursor = db.query(
                NewsContract.NewsEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                NewsContract.NewsEntry._ID + " DESC");

        return cursor;
    }
}
