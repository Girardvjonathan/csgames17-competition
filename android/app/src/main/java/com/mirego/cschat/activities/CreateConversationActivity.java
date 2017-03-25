package com.mirego.cschat.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mirego.cschat.CSChatApplication;
import com.mirego.cschat.R;
import com.mirego.cschat.adapters.ConversationAdapter;
import com.mirego.cschat.adapters.CreateConversationAdapter;
import com.mirego.cschat.controller.ConversationsController;
import com.mirego.cschat.controller.CreateConversationController;
import com.mirego.cschat.controller.LoginController;
import com.mirego.cschat.models.User;
import com.mirego.cschat.viewdatas.ConversationViewData;
import com.mirego.cschat.viewdatas.UserViewData;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class CreateConversationActivity extends BaseActivity implements CreateConversationAdapter.CreateConversationAdapterListener {

    @BindView(R.id.create_conversation_root)
    ViewGroup root;

    @BindView(R.id.rv_create_conversation)
    RecyclerView rvCreateConversation;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Inject
    CreateConversationController createConversationController;

    private CreateConversationAdapter createConversationAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_conversation);
        ((CSChatApplication) getApplication()).component().inject(this);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        toolbar.setTitle(getString(R.string.create_conversation_title));
        configureCreateConversationRecyclerView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        fetchUsers();
    }

    private void configureCreateConversationRecyclerView() {
        createConversationAdapter = new CreateConversationAdapter(this, this);
        rvCreateConversation.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        itemDecoration.setDrawable(getResources().getDrawable(R.drawable.list_spacing, null));
        rvCreateConversation.addItemDecoration(itemDecoration);
        rvCreateConversation.setAdapter(createConversationAdapter);
    }

    private void fetchUsers() {
        createConversationController.getUsers()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<List<UserViewData>>() {
                    @Override
                    public void accept(@NonNull List<UserViewData> userViewDatas) throws Exception {
                        createConversationAdapter.populateUsers(userViewDatas);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        Snackbar.make(root, R.string.network_error, Snackbar.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public void onUserClicked(UserViewData userViewData) {
        List<User> users = new ArrayList<User>();
        //users.add(stor);
        //startActivity(ConversationActivity.intent(this, userViewData.getUser().getId()));
    }

}
