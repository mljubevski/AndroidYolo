package com.mljubevski.yolo.activities;

import android.app.Application;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.mljubevski.yolo.R;

/**
 * Created by Milos on 14-Mar-17.
 */

public class RegisterActivity extends BaseActivity implements View.OnClickListener
{
    private EditText usernameEditText;
    private EditText emailEditText;
    private EditText passwordEditText;
    private Button registerButton;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);

        usernameEditText = (EditText) findViewById(R.id.activity_register_usernameEditText);
        emailEditText = (EditText)findViewById(R.id.activity_register_emailEditText);
        passwordEditText = (EditText)findViewById(R.id.activity_register_passwordEditText);
        registerButton = (Button)findViewById(R.id.activity_register_registerButton);
        progressBar = (ProgressBar)findViewById(R.id.activity_register_progressBar);

        registerButton.setOnClickListener(this);
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onClick(View sender)
    {
        if(sender == registerButton)
        {
            application.getAuth().getUser().setLoggedIn(true);

            setResult(RESULT_OK);
            finish();
        }
    }
}




































