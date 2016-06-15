package com.yourpanache.crmpanache;

import android.app.Application;
import android.content.Context;

/**
 * Created by user on 15-Jun-16.
 */
public class ApplicationClass extends Application {

    private static Context mContext;

    public void onCreate(){
        super.onCreate();
        this.mContext = this;
    }

    public static Context getContext(){
        return mContext;
    }

}
