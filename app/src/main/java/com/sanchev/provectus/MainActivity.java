package com.sanchev.provectus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView usersList = (RecyclerView) findViewById(R.id.usersList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        usersList.setLayoutManager(layoutManager);

        List<User> users = UserStorage.getInstance(this).getUsers();
        UserAdapter userAdapter = new UserAdapter(this, new OnClickListener() {
            @Override
            public void onClick(View view) {
                int itemPosition = usersList.getChildLayoutPosition(view);
                Intent intent = new Intent(getApplicationContext(), UserActivity.class);
                intent.putExtra(UserStorage.USER_INDEX, itemPosition);
                startActivity(intent);
            }
        }, users);

        usersList.setAdapter(userAdapter);
    }
}