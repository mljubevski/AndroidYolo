package com.mljubevski.yolo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.mljubevski.yolo.R;

/**
 * Created by Milos on 12-Mar-17.
 */

public class LoginActivity extends BaseActivity implements View.OnClickListener
{
    private View loginButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        loginButton = findViewById(R.id.activity_login_loginButton);

        if(loginButton != null)
        {
            loginButton.setOnClickListener(this);
        }
    }

    // OnClickListener implementation


    @Override
    public void onClick(View sender)
    {
        if(sender == loginButton)
        {
            startActivity(new Intent(this, LoginNarrowActivity.class));
        }
    }
}
