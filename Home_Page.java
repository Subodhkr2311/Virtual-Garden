package com.example.ayush_vg;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home_Page extends AppCompatActivity {
BottomNavigationView bgmV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_page);
        bgmV= findViewById(R.id.nav_view);
        bgmV.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.home){
                 loadfragment(new HomeF());
                }else if(item.getItemId()==R.id.search){
                    loadfragment(new SearchF());
                } else if (item.getItemId() == R.id.quiz) {
                    loadfragment(new QuizeF());
                }else if (item.getItemId() == R.id.profile) {
                    loadfragment(new Profile());
                }
                return true;
            }
        });

    }
    public  void loadfragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();

    }
}
