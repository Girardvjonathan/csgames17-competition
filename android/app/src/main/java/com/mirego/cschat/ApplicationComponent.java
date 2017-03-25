package com.mirego.cschat;

import com.mirego.cschat.activities.ConversationActivity;
import com.mirego.cschat.activities.ConversationsActivity;
import com.mirego.cschat.activities.CreateConversationActivity;
import com.mirego.cschat.activities.HomeActivity;
import com.mirego.cschat.activities.LoginActivity;
import com.mirego.cschat.activities.RegisterActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = AndroidModule.class)
public interface ApplicationComponent {
    void inject(LoginActivity loginActivity);

    void inject(RegisterActivity registerActivity);

    void inject(HomeActivity homeActivity);

    void inject(ConversationsActivity conversationsActivity);

    void inject(ConversationActivity conversationActivity);

    void inject(CreateConversationActivity createConversationActivity);
}
