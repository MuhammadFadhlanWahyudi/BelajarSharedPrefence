package com.example.belajarsharedprefence;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    UserModel userModel;
    SaveShared saveShared;
    Button      set;
    
      set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this,SettingAcount.class);
                startActivity(a);
            }
        });


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saveShared = new SaveShared(this);
        set = findViewById(R.id.set);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuLogout:
                userModel = saveShared.getUser();
                userModel.setStatusLogin(false);
                saveShared.setUser(userModel);
                startActivity(new Intent(MainActivity.this, LoginActivty.class));
                finish();
                break;
            case R.id.accountSetting:
startActivity(new Intent(MainActivity.this, SettingAcount.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
