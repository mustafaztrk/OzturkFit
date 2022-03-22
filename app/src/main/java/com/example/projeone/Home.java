package com.example.projeone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {

    private BottomNavigationView mBottomBar;
    private HomeFragment homeFragment;
    private ProfileFragment profileFragment;
    private DumbellFragment dumbellFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        homeFragment=new HomeFragment();
        profileFragment=new ProfileFragment();
        dumbellFragment=new DumbellFragment();





        mBottomBar=(BottomNavigationView)findViewById(R.id.main_activity_bottomNavigationView);
        setFragment(homeFragment);
        mBottomBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               switch (item.getItemId()){
                   case R.id.bottombar_menu_home:
                       setFragment(homeFragment);
                      // Toast.makeText(getApplicationContext(),"Home",Toast.LENGTH_SHORT).show();
                       return true;
                   case R.id.bottombar_menu_dumbell:
                       setFragment(dumbellFragment);


                      // Toast.makeText(getApplicationContext(),"Egzersiz",Toast.LENGTH_SHORT).show();
                       return true;
                   case R.id.bottombar_menu_profile:
                       setFragment(profileFragment);
                      // Toast.makeText(getApplicationContext(),"Profil",Toast.LENGTH_SHORT).show();
                       return true;

                   default:
                       return false;
               }
            }
        });



    }
    public void setFragment(Fragment fragment){
        FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_activity_frameLayout,fragment);
        transaction.commit();
    }
}