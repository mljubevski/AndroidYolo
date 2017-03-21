package com.mljubevski.yolo.views;

import android.media.Image;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mljubevski.yolo.activities.BaseActivity;

import java.util.ArrayList;

/**
 * Created by milos on 3/21/17.
 */

public class NavDrawer
{
    private ArrayList<NavDrawerItem> items;
    private NavDrawerItem selectedItem;


    protected BaseActivity activity;
    protected DrawerLayout drawerLayout;
    protected ViewGroup navDrawerView;


    public NavDrawer(BaseActivity activity)
    {

    }

    public void addItem(NavDrawerItem item)
    {

    }

    public boolean isOpen()
    {
        return false;
    }

    public void setOpen(boolean isOpen)
    {

    }

    public void setSelectedItem(NavDrawerItem item)
    {

    }

    public void create()
    {

    }

    public static abstract class NavDrawerItem
    {
        protected NavDrawer navDrawer;

        public abstract void inflate(LayoutInflater inflater, ViewGroup container);
        public abstract void setSelected(boolean isSelected);
    }

    public static class BasicNavDrawerItem extends NavDrawerItem implements View.OnClickListener
    {
        private String title;
        private String badge;
        private int iconDrawable;
        private int containerID;

        private ImageView icon;
        private TextView titleTextView;
        private TextView badgeTextView;
        private View view;
        private int defaultTextColor;

        public BasicNavDrawerItem(String title, String badge, int iconDrawable, int containerID)
        {

        }

        // setters

        public void setTitle(String title)
        {
            this.title = title;
        }

        public void setBadge(String badge)
        {
            this.badge = badge;
        }

        public void setIcon(int iconDrawable)
        {
            this.iconDrawable = iconDrawable;
        }

        // inherited methods

        @Override
        public void onClick(View v) {

        }

        @Override
        public void inflate(LayoutInflater inflater, ViewGroup container) {

        }

        @Override
        public void setSelected(boolean isSelected) {

        }


    }

    public static class  ActivityNavDrawerItem extends BasicNavDrawerItem
    {
        private final Class targetActivity;

        public ActivityNavDrawerItem(Class targetActivity, String title, String badge, int iconDrawable, int containerID)
        {
            super(title, badge, iconDrawable, containerID);
            this.targetActivity = targetActivity;
        }
    }
}









