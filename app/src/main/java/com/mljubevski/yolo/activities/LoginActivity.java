package com.mljubevski.yolo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.mljubevski.yolo.R;
import com.mljubevski.yolo.fragments.LoginFragment;

import static android.R.attr.data;

/**
 * Created by Milos on 12-Mar-17.
 */

public class LoginActivity extends BaseActivity implements View.OnClickListener, LoginFragment.Callbacks
{
    private static final int REQUEST_NARROW_LOGIN = 1;
    private static final int REQUEST_REGISTER = 2;
    private static final int REQUEST_EXTERNAL_REGISTER = 3;

    private View loginButton;
    private View registerButton;
    private View facebookLoginButton;
    private View googleLoginButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        loginButton = findViewById(R.id.activity_login_loginButton);
        registerButton = findViewById(R.id.activity_login_registerButton);
        facebookLoginButton = findViewById(R.id.activity_login_facebookButton);
        googleLoginButton = findViewById(R.id.activity_login_googleButton);

        if(loginButton != null)
        {
            loginButton.setOnClickListener(this);
        }
        registerButton.setOnClickListener(this);
        facebookLoginButton.setOnClickListener(this);
        googleLoginButton.setOnClickListener(this);
    }

    // OnClickListener implementation

    @Override
    public void onClick(View sender)
    {
        if (sender == loginButton)
        {
            startActivityForResult(new Intent(this, LoginNarrowActivity.class), REQUEST_NARROW_LOGIN);
        }

        if (sender == registerButton)
        {
            startActivityForResult(new Intent(this, RegisterActivity.class), REQUEST_REGISTER);
        }

        if (sender == facebookLoginButton || sender == googleLoginButton)
        {
            Intent intent = new Intent(this, ExternalLoginActivity.class);
            intent.putExtra(ExternalLoginActivity.EXTRA_EXTERNAL_SERVICE, (sender == facebookLoginButton) ? "Facebook" : "Google");
            startActivityForResult(intent, REQUEST_EXTERNAL_REGISTER);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (resultCode != RESULT_OK)
        {
            return;
        }

        if (requestCode == REQUEST_NARROW_LOGIN ||
                requestCode == REQUEST_REGISTER ||
                requestCode == REQUEST_EXTERNAL_REGISTER)
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
    public void onLoggedIn()
    {
        finishLogin();
    }
}
