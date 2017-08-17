package com.experience.totvs.easyfashion_v1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ((TextView) findViewById(R.id.main_content_text)).setText("Nenhuma compra feita");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        String[] names = {"Rodrigo", "Camila", "Wendel", "Felipe"};

//        ArrayAdapter<String> namesArrayAdapter =
//                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
//
//        ((ListView) findViewById(R.id.ListNames)).setAdapter(namesArrayAdapter);
//
//        findViewById(R.id.list_add_contact).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent formIntent = new Intent(ContactsListActivity.this, FormActivity.class);
//                startActivity(formIntent);
//            }
//        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_launch_scanner) {
            Intent intent = new Intent(this, ProductScannerActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_see_follwing) {
            Intent intent = new Intent(this, DefaultFollowingListActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_show_catalog) {

        } else if (id == R.id.nav_show_favorites) {

        } else if (id == R.id.nav_launch_profile_activity) {

        } else if (id == R.id.nav_logout) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
