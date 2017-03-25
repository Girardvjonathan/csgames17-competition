package com.mirego.cschat.viewdatas;

import android.content.Context;

import com.mirego.cschat.models.Conversation;
import com.mirego.cschat.models.Message;
import com.mirego.cschat.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserViewData {

    private final User user;
    private Context context;

    public UserViewData(User user, Context context) {
        this.user = user;
        this.context = context;
    }

    public User getUser(){
        return user;
    }
}
