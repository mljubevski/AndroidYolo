package com.mljubevski.yolo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.mljubevski.yolo.R;
import com.mljubevski.yolo.fragments.LoginFragment;

/**
 * Created by Milos on 12-Mar-17.
 */

public class LoginActivity extends BaseActivity implements View.OnClickListener, LoginFragment.Callbacks
{
    private static final int REQUEST_NARROW_LOGIN = 1;

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
            startActivityForResult(new Intent(this, LoginNarrowActivity.class), REQUEST_NARROW_LOGIN);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != RESULT_OK)
        {
            return;
        }

        if(requestCode == REQUEST_NARROW_LOGIN)
        {
            finishLogin();
        }
    }

    private void finishLogin()
    {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void onLoggedIn() {
        finishLogin();
    }
}
