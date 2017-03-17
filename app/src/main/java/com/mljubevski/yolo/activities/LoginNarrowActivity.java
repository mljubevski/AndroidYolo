package com.mljubevski.yolo.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.mljubevski.yolo.R;
import com.mljubevski.yolo.fragments.LoginFragment;

/**
 * Created by milos on 3/13/17.
 */

public class LoginNarrowActivity extends BaseActivity implements LoginFragment.Callbacks
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login_narrow);
    }

    @Override
    public void onLoggedIn()
    {
        setResult(RESULT_OK);
        finish();
    }
}
