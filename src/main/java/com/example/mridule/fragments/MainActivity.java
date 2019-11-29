package com.example.mridule.fragments;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNav= (BottomNavigationView) findViewById (R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navlistener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment()).commit();

    }


    private BottomNavigationView.OnNavigationItemSelectedListener navlistener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedfragment=null;

                    switch (item.getItemId()){
                        case R.id.nav_home:
                            selectedfragment = new HomeFragment();
                            break;
                        case R.id.nav_favourite:
                            selectedfragment = new FavouriteFragment();
                            break;
                        case R.id.nav_search:
                            selectedfragment = new SearchFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedfragment).commit();
                    return true;
                }
            };

    public void onBackPressed() {
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        int seletedItemId = bottomNavigationView.getSelectedItemId();
        if (R.id.nav_home != seletedItemId) {
            setHomeItem(MainActivity.this);
        } else {
            super.onBackPressed();
        }
    }

    public static void setHomeItem(Activity activity) {
        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                activity.findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.nav_home);
    }

   public void fragment1(View view){
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Fragment_1()).addToBackStack(null).commit();
    }

    /*public void onBackPressed()
    {
        FragmentManager fm = get().getSupportFragmentManager();
        fm.popBackStack();
    }*/

}




