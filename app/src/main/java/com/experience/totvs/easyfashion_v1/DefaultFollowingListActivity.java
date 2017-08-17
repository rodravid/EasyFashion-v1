package com.experience.totvs.easyfashion_v1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.experience.totvs.easyfashion_v1.domain.user.Activities.SearchUserActivity;
import com.experience.totvs.easyfashion_v1.domain.user.User;

import java.util.ArrayList;
import java.util.List;

public class DefaultFollowingListActivity extends AppCompatActivity {

    private ListView usersList;
    private List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default_following_list);

        usersList = ((ListView) findViewById(R.id.following_list_view));
        registerForContextMenu(usersList);

        users = new ArrayList<User>();
        users.add(new User("Wendel", 26, "male", "Hippie"));
        users.add(new User("Paulo T.", 29, "male", "Hippie"));
        users.add(new User("Luiza", 24, "female", "Hippie"));
        users.add(new User("Gabrielle", 21, "female", "Dark"));
        users.add(new User("Nathália", 22, "female", "Hippie"));
        users.add(new User("Rodrigo Snow", 19, "male", "Rock"));

        findViewById(R.id.following_list_add_user).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent formIntent = new Intent(DefaultFollowingListActivity.this, SearchUserActivity.class);
                startActivity(formIntent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        refreshList();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, final ContextMenu.ContextMenuInfo menuInfo) {
        menu.add("Delete").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;

                User contact = (User) users.remove(info.position);
                refreshList();

                Toast.makeText(DefaultFollowingListActivity.this, String.format("%s deletado.", contact.getName()), Toast.LENGTH_SHORT).show();

                return false;
            }
        });
    }

    public void refreshList() {
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
