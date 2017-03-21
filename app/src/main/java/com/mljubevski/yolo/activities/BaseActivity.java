package com.mljubevski.yolo.activities;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mljubevski.yolo.R;
import com.mljubevski.yolo.infrastructure.YoloApplication;
import com.mljubevski.yolo.views.NavDrawer;

/**
 * Created by Milos on 12-Mar-17.
 */

public class BaseActivity extends AppCompatActivity
{
    protected YoloApplication application;
    protected Toolbar toolbar;
    protected NavDrawer navDrawer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        application = (YoloApplication)getApplication();
    }


    @Override
    public void setContentView(@LayoutRes int layoutResID)
    {
        super.setContentView(layoutResID);
        toolbar = (Toolbar) findViewById(R.id.include_toolbar);

        if(toolbar != null)
        {
            setSupportActionBar(toolbar);
        }

    }

    protected void setNavDrawer(NavDrawer draver)
    {
        this.navDrawer = draver;
        this.navDrawer.create();
    }
}
