package com.example.descretemathscompanion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity
    {

        @Override
        protected void onCreate(Bundle savedInstanceState)
            {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
                bottomNav.setOnNavigationItemSelectedListener(navListener);
            }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener=
        new BottomNavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
                {
                    Fragment selectedFragment = null;
                    switch (item.getItemId())
                        {
                            case R.id.gcd:
                                selectedFragment= new GCD();
                                break;

                            case R.id.lcm:
                                selectedFragment= new LCM();
                                break;

                            case R.id.prime_factors:
                                selectedFragment= new PrimeFactors();
                                break;

                            case R.id.divisors:
                                selectedFragment=new Divisors();
                                break;

                           // default:
//                                selectedFragment=new MainActivity();
                        }
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container,selectedFragment).commit();
                    return true;
                }
        };
    }
