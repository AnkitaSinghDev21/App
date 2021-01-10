package com.example.aspreforher;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
BottomNavigationView bnv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.FrameContainer,new homeFragment()).commit();

        bnv=(BottomNavigationView)findViewById(R.id.bottomNavigation);
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                Fragment temp=null;
                switch (item.getItemId()){
                    case R.id.nav_home:temp=new homeFragment();
                    break;
                    case R.id.nav_About:temp=new aboutFragment();
                        break;
                    case R.id.nav_forward:temp=new forwardFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.FrameContainer,temp).commit();
                return true;
            }
        });
    }
}