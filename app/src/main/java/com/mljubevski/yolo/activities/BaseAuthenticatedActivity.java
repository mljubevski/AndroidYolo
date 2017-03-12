package com.mljubevski.yolo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by Milos on 12-Mar-17.
 */

public abstract class BaseAuthenticatedActivity extends BaseActivity
{
    @Override
    protected final void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        if(!application.getAuth().getUser().isLoggedIn())
        {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
            return;
        }

        this.onYoloCreate(savedInstanceState);
    }

    protected abstract void onYoloCreate(@Nullable Bundle savedInstanceState);
}
