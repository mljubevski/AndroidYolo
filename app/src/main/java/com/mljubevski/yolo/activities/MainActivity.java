package com.mljubevski.yolo.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.mljubevski.yolo.R;
import com.mljubevski.yolo.views.MainNavDrawer;

/**
 * Created by Milos on 12-Mar-17.
 */

public class MainActivity extends BaseAuthenticatedActivity
{

    @Override
    protected void onYoloCreate(@Nullable Bundle savedInstanceState)
    {
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Inbox");
        setNavDrawer(new MainNavDrawer(this));
    }
}
