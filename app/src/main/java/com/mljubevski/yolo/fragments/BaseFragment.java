package com.mljubevski.yolo.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.mljubevski.yolo.infrastructure.YoloApplication;

/**
 * Created by milos on 3/13/17.
 */

public class BaseFragment extends Fragment
{
    protected YoloApplication application;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        application = (YoloApplication)getActivity().getApplication();
    }
}
