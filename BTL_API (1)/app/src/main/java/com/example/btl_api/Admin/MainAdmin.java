package com.example.btl_api.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.btl_api.Fragment.Admin_Home;
import com.example.btl_api.R;
import com.example.btl_api.login.Login;
import com.google.android.material.navigation.NavigationView;

public class MainAdmin extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private static final int FRAGMENT_HOMEADMIN = 0;
    private static final int FRAGMENT_ACCADMIN = 1;
    private static final int FRAGMENT_LOGOUTADMIN = 2;

    private int mfragment = FRAGMENT_HOMEADMIN;
    private DrawerLayout mDrawerLayout;
    String UserName, PassWord, ID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainadmin);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,mDrawerLayout,toolbar,
                R.string.navigatio_drawer_open, R.string.navigatio_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
        replaceFragment(new Admin_Home());
        navigationView.getMenu().findItem(R.id.nav_home).setChecked(true);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("mpk");

        if(bundle!=null){
            UserName = bundle.getString("username");
            PassWord = bundle.getString("password");
            ID = bundle.getString("id");
        }

    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.nav_home){
            if(mfragment != FRAGMENT_HOMEADMIN){
                replaceFragment(new Admin_Home());
                mfragment = FRAGMENT_HOMEADMIN;
            }
        } else if(id == R.id.nav_AccAdmin){

        }else if(id == R.id.nav_logoutAdmin){
            Intent intent = new Intent(MainAdmin.this, Login.class);
            startActivity(intent);
        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void replaceFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame,fragment);
        transaction.commit();
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}