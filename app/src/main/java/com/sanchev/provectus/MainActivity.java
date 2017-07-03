package com.sanchev.provectus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserAdapter userAdapter = new UserAdapter(this, R.layout.user_item);

        ListView usersList = (ListView) findViewById(R.id.usersList);
        usersList.setAdapter(userAdapter);

        users = UserStorage.getInstance(this).getUsers();
        userAdapter.addAll(users);

        usersList.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        User user = users.get(i);
        Intent intent = new Intent(this, UserActivity.class);
        intent.putExtra(User.class.getCanonicalName(), user);
        startActivity(intent);
    }
}