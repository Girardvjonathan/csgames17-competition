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
    private final String currentUserId;

    public UserViewData(User user, String currentUserId, Context context) {
        this.user = user;
        this.context = context;
        this.currentUserId = currentUserId;
    }

    public User getUser(){
        return user;
    }

    public String getCurrentUserId(){
        return currentUserId;
    }
}
