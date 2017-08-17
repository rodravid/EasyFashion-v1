package com.experience.totvs.easyfashion_v1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.experience.totvs.easyfashion_v1.domain.user.User;

import java.util.ArrayList;
import java.util.List;

public class FollowingListActivity extends AppCompatActivity {

    private ListView usersList;
    private List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_following_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        usersList = ((ListView) findViewById(R.id.following_list_view));

        users = new ArrayList<User>();
        users.add(new User("Wendel", 26, "male", "Hippie"));
        users.add(new User("Paulo T.", 29, "male", "Hippie"));
        users.add(new User("Luiza", 24, "female", "Hippie"));
        users.add(new User("Gabrielle", 21, "female", "Dark"));
        users.add(new User("Nathália", 22, "female", "Hippie"));
        users.add(new User("Rodrigo Snow", 19, "male", "Rock"));

//        findViewById(R.id.following_list_add_user).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent formIntent = new Intent(FollowingListActivity.this, SearchUserActivity.class);
//                startActivity(formIntent);
//            }
//        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        ArrayAdapter<User> usersArrayAdapter =
                new ArrayAdapter<User>(this, android.R.layout.simple_list_item_1, users);
        usersList.setAdapter(usersArrayAdapter);
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        this.users.add(user);
    }
}
