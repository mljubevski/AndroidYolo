package com.mljubevski.yolo.views;

import android.content.Intent;
import android.media.Image;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mljubevski.yolo.R;
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
        this.activity = activity;
        items = new ArrayList<>();
        drawerLayout = (DrawerLayout) activity.findViewById(R.id.drawer_layout);
        navDrawerView = (ViewGroup) activity.findViewById(R.id.nav_drawer);

        if (drawerLayout == null || navDrawerView == null)
        {
            throw new RuntimeException("To use this class you must have views with ids of drawer_layout and nav_drawer");
        }

        Toolbar toolbar = activity.getToolbar();
        toolbar.setNavigationIcon(R.drawable.ic_action_image_dehaze);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOpen(!isOpen());
            }
        });
    }

    public void addItem(NavDrawerItem item)
    {
        items.add(item);
        item.navDrawer = this;
    }

    public boolean isOpen()
    {
        return drawerLayout.isDrawerOpen(Gravity.START);
    }

    public void setOpen(boolean isOpen)
    {
        if(isOpen)
        {
            drawerLayout.openDrawer(Gravity.START);
        }
        else
        {
            drawerLayout.closeDrawer(Gravity.START);
        }
    }

    public void setSelectedItem(NavDrawerItem item)
    {
        if(selectedItem != null)
        {
            selectedItem.setSelected(false);
        }

        selectedItem = item;
        selectedItem.setSelected(true);
    }

    public void create()
    {
        LayoutInflater inflater = activity.getLayoutInflater();

        for(NavDrawerItem item : items)
        {
            item.inflate(inflater, navDrawerView);
        }
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
            this.title = title;
            this.badge = badge;
            this.iconDrawable = iconDrawable;
            this.containerID = containerID;
        }

        // setters

        public void setTitle(String title)
        {
            this.title = title;

            if(view != null)
            {
                titleTextView.setText(title);
            }
        }

        public void setBadge(String badge)
        {
            this.badge = badge;

            if(view != null)
            {
                if(badge != null)
                {
                    badgeTextView.setText(badge);
                    badgeTextView.setVisibility(View.VISIBLE);
                }
                else
                {
                    badgeTextView.setVisibility(View.GONE);
                }
            }
        }

        public void setIcon(int iconDrawable)
        {
            this.iconDrawable = iconDrawable;

            if(view != null)
            {
                icon.setImageResource(iconDrawable);
            }
        }

        // inherited methods

        @Override
        public void onClick(View v)
        {
            navDrawer.setSelectedItem(this);
        }

        @Override
        public void inflate(LayoutInflater inflater, ViewGroup navDrawerView)
        {
            ViewGroup container = (ViewGroup) navDrawerView.findViewById(containerID);

            if(container == null)
            {
                throw new RuntimeException("Nav drawer item " + title + " could not be attached to VIewGroup. View not found");
            }

            view = inflater.inflate(R.layout.list_item_nav_drawer, container);
            view.setOnClickListener(this);

            icon = (ImageView) view.findViewById(R.id.list_item_nav_drawer_iconImageView);
            titleTextView = (TextView) view.findViewById(R.id.list_item_nav_drawer_titleTextView);
            badgeTextView = (TextView) view.findViewById(R.id.list_item_nav_drawer_badgeTextView);

            defaultTextColor = titleTextView.getCurrentTextColor();

            icon.setImageResource(iconDrawable);
            titleTextView.setText(title);

            if(badge != null)
            {
                badgeTextView.setText(badge);
            }
            else
            {
                badgeTextView.setVisibility(View.GONE);
            }
        }

        @Override
        public void setSelected(boolean isSelected)
        {
            if(isSelected)
            {
                view.setBackgroundResource(R.drawable.list_item_nav_drawer_selected_item_background);
                titleTextView.setTextColor(navDrawer.activity.getResources().getColor(R.color.list_item_nav_drawer_selected_item_text_color));
            }
            else
            {
                view.setBackground(null);
                titleTextView.setTextColor(defaultTextColor);
            }
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

        @Override
        public void inflate(LayoutInflater inflater, ViewGroup navDrawerView)
        {
            super.inflate(inflater, navDrawerView);

            if(this.navDrawer.activity.getClass() == targetActivity)
            {
                this.navDrawer.setSelectedItem(this);
            }
        }

        @Override
        public void onClick(View sender)
        {
            navDrawer.setOpen(false);

            if(navDrawer.activity.getClass() == targetActivity)
            {
                return;
            }

            super.onClick(sender);

            // TODO: animations
            navDrawer.activity.startActivity(new Intent(navDrawer.activity, targetActivity));
            navDrawer.activity.finish();

        }
    }
}









