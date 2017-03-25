package com.mirego.cschat.controller;

import com.mirego.cschat.activities.BaseActivity;
import com.mirego.cschat.models.User;
import com.mirego.cschat.models.request.RegisterRequest;
import com.mirego.cschat.services.CSChatService;
import com.mirego.cschat.services.StorageService;

import io.reactivex.Flowable;

public class RegisterController extends BaseActivity {

    private final CSChatService chatService;
    private final StorageService storageService;

    public RegisterController(CSChatService chatService, StorageService storageService) {
        this.chatService = chatService;
        this.storageService = storageService;
    }

    public Flowable<User> register(String username, String password) {
        return chatService.register(new RegisterRequest(username, password));
    }

    public void logout() {
        storageService.clearUserId();
    }

    public void saveUserId(String userId) {
        storageService.storeUserId(userId);
    }

}
