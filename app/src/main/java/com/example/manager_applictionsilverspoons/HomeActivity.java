package com.example.manager_applictionsilverspoons;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.manager_applictionsilverspoons.fragment.TableBookingFragment;
import com.example.manager_applictionsilverspoons.fragment.OrderFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView bnvmain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bnvmain = findViewById(R.id.bnvmain);
        openFragment(new TableBookingFragment());

      bnvmain.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
          @Override
          public boolean onNavigationItemSelected(@NonNull MenuItem item ) {

              if (item.getItemId()==R.id.menu_booking){
                  openFragment(new TableBookingFragment());
              }
              else if (item.getItemId()==R.id.menu_billing){
                  openFragment(new OrderFragment());
              }
              else {
                  openFragment(new TableBookingFragment());
              }
              return true;
          }
      });




    }

    public void openFragment(Fragment fragment){
        androidx.fragment.app.FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frame, fragment).commit();
    }

    public void removeFragment(Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction trans = manager.beginTransaction();
        trans.remove(fragment);
        trans.commit();
        manager.popBackStack();
    }


    public void replaceFragment(Fragment fragment){
        androidx.fragment.app.FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frame, fragment).commit();
    }
}