package com.mirego.cschat.controller;


import android.content.Context;
import android.util.Log;

import com.mirego.cschat.models.Conversation;
import com.mirego.cschat.models.User;
import com.mirego.cschat.models.response.ConversationsResponse;
import com.mirego.cschat.models.response.UsersResponse;
import com.mirego.cschat.services.CSChatService;
import com.mirego.cschat.services.StorageService;
import com.mirego.cschat.viewdatas.ConversationViewData;
import com.mirego.cschat.viewdatas.UserViewData;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

public class CreateConversationController {

    private final CSChatService chatService;
    private final StorageService storageService;
    private Context context;

    public CreateConversationController(CSChatService chatService, StorageService storageService, Context context) {
        this.chatService = chatService;
        this.storageService = storageService;
        this.context = context;
    }

    public Flowable<List<UserViewData>> getUsers() {
        return chatService.fetchUsers()
                .map(new Function<List<User>, List<UserViewData>>() {
                    @Override
                    public List<UserViewData> apply(@NonNull List<User> users) throws Exception {
                        List<UserViewData> userViewDatum = new ArrayList<>();
                        for (User user : users) {
                            if(user.getId() != storageService.currentUserId()){
                                userViewDatum.add(new UserViewData(user, context));
                            }
                        }
                        return userViewDatum;
                    }
                });
    }
}
