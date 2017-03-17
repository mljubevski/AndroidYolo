package com.mljubevski.yolo.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mljubevski.yolo.R;

/**
 * Created by milos on 3/13/17.
 */

public class LoginFragment extends BaseFragment implements View.OnClickListener
{
    private Callbacks callbacks;
    private Button loginButton;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        loginButton = (Button) view.findViewById(R.id.activity_login_loginButton);
        loginButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);

        callbacks = (Callbacks)context;
    }

    @Override
    public void onDetach()
    {
        super.onDetach();

        callbacks = null;
    }

    @Override
    public void onClick(View sender)
    {
        if(sender == loginButton)
        {
            application.getAuth().getUser().setLoggedIn(true);
            callbacks.onLoggedIn();
        }
    }

    public interface Callbacks
    {
        void onLoggedIn();
    }
}























