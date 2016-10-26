package com.android.baseproject.utils;

import android.content.Context;

import com.android.baselibrary.utils.DataBaseHelper;
import com.android.baseproject.R;


/**
 * Created by 15596 on 2016/10/24.
 */

public class DbHelper extends DataBaseHelper {
    private static DbHelper mDbHelper;

    public DbHelper(Context context) {
        super(context);
    }

    public static DbHelper getInstance(Context context){
        if (mDbHelper==null){
            synchronized (DataBaseHelper.class){
                if (mDbHelper==null){
                    mDbHelper = new DbHelper(context);
                    if (mDbHelper.getDB()==null||!mDbHelper.getDB().isOpen()){
                        mDbHelper.open();
                    }
                }
            }
        }
        return mDbHelper;

    }



    @Override
    protected int getMDbVersion(Context context) {

        return Integer.valueOf(context.getResources().getStringArray(R.array.DATABASE_INFO)[1]);
    }

    @Override
    protected String getDbName(Context context) {

        return context.getResources().getStringArray(R.array.DATABASE_INFO)[0];
    }

    @Override
    protected String[] getDbCreateSql(Context context) {
        return context.getResources().getStringArray(R.array.CREATE_TABLE_SQL);
    }

    @Override
    protected String[] getDbUpdateSql(Context context) {

        return context.getResources().getStringArray(R.array.UPDATE_TABLE_SQL);
    }
}
