package com.mljubevski.yolo.infrastructure;

import android.app.Application;

/**
 * Created by Milos on 12-Mar-17.
 */

public class YoloApplication extends Application
{
    private Auth auth;

    @Override
    public void onCreate()
    {
        super.onCreate();
        auth = new Auth(this);
    }

    public Auth getAuth()
    {
        return auth;
    }
}
