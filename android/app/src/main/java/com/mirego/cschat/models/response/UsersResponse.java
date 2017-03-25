package com.mirego.cschat.models.response;

import com.mirego.cschat.models.Conversation;
import com.mirego.cschat.models.User;

import java.util.List;

public class UsersResponse {

    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
