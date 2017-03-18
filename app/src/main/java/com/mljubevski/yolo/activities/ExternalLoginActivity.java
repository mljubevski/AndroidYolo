package com.mljubevski.yolo.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

import com.mljubevski.yolo.R;

/**
 * Created by milos on 3/17/17.
 */

public class ExternalLoginActivity extends BaseActivity implements View.OnClickListener {
    public static final String EXTRA_EXTERNAL_SERVICE = "EXTRA_EXTERNAL_SERVICE";
    private Button externalLoginButton;
    private WebView webView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_external_login);

        externalLoginButton = (Button) findViewById(R.id.activity_external_login_loginButton);
        webView = (WebView) findViewById(R.id.activity_external_login_webView);

        externalLoginButton.setOnClickListener(this);
        externalLoginButton.setText("Login with: " + getIntent().getStringExtra(EXTRA_EXTERNAL_SERVICE));
    }

    @Override
    public void onClick(View sender)
    {
        if(sender == externalLoginButton)
        {
            application.getAuth().getUser().setLoggedIn(true);
            setResult(RESULT_OK);
            finish();
        }
    }
}
