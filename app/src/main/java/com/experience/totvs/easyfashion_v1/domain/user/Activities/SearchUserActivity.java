package com.experience.totvs.easyfashion_v1.domain.user.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.experience.totvs.easyfashion_v1.R;
import com.experience.totvs.easyfashion_v1.domain.user.User;

public class SearchUserActivity extends AppCompatActivity {

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_user);

        findViewById(R.id.search_user_scan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent scanUserCodeIntent = new Intent(SearchUserActivity.this, UserScannerActivity.class);
                startActivityForResult(scanUserCodeIntent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                ((EditText) findViewById(R.id.search_user_keywords)).setText(((User) data.getSerializableExtra("user")).getName());
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (user != null) {
            Toast.makeText(this, user.getName(), Toast.LENGTH_SHORT).show();
        }
    }

    public void setUser(User user) {
        this.user = user;
    }
}
