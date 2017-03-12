package com.mljubevski.yolo.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.mljubevski.yolo.infrastructure.YoloApplication;

/**
 * Created by Milos on 12-Mar-17.
 */

public class BaseActivity extends AppCompatActivity
{
    protected YoloApplication application;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        application = (YoloApplication)getApplication();
    }
}
