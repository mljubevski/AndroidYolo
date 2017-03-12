package com.mljubevski.yolo.infrastructure;

import android.content.Context;

/**
 * Created by Milos on 12-Mar-17.
 */

public class Auth
{
    private final Context context;
    private User user;

    public Auth(Context context)
    {
        this.context = context;
        this.user = new User();
    }

    public User getUser()
    {
        return user;
    }
}
