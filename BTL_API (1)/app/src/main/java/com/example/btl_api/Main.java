package com.example.btl_api;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.btl_api.Fragment.ChangePasswordFragment;
import com.example.btl_api.Fragment.ChangeProfileFragment;
import com.example.btl_api.Fragment.DangKiFragment;
import com.example.btl_api.Fragment.HomeFragment;
import com.example.btl_api.Fragment.LichHocFragment;
import com.example.btl_api.Fragment.LichThiFragment;
import com.example.btl_api.login.LoginSV;
import com.google.android.material.navigation.NavigationView;

public class Main extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    TextView name;
    TextView mail;
    DrawerLayout drawerLayout;
    String UserName, PassWord, ID;

    private static final int FRAGMENT_HOME = 0;
    private static final int FRAGMENT_DANGKI = 1;
    private static final int FRAGMENT_LICHHOC = 2;
    private static final int FRAGMENT_LICHTHI = 3;
    private static final int FRAGMENT_PROFILE = 4;
    private static final int FRAGMENT_PASSWORD = 5;
    private static final int FRAGMENT_EXIT = 6;

    private int currentfragment = FRAGMENT_HOME;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("mpk");
        View fragmentView = getLayoutInflater().inflate(R.layout.layout_header_nav, null);
        name = fragmentView.findViewById(R.id.name);
        mail = fragmentView.findViewById(R.id.mail);

        if(bundle!=null){
            UserName = bundle.getString("username");
            PassWord = bundle.getString("password");
            ID = bundle.getString("id");
            name.setText(UserName);
            mail.setText(PassWord);
        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout, toolbar,
                R.string.nav_drawer_open, R.string.nav_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
        replaceFragment(new HomeFragment());
        navigationView.getMenu().findItem(R.id.nav_home).setChecked(true);



    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.nav_home){
            if(currentfragment != FRAGMENT_HOME)
            {
                replaceFragment(new HomeFragment());
                currentfragment = FRAGMENT_HOME;
            }
        }else if(id == R.id.nav_register) {
            if(currentfragment != FRAGMENT_DANGKI)
            {
                replaceFragment(new DangKiFragment());
                currentfragment = FRAGMENT_DANGKI;
            }
        }else if(id == R.id.nav_calendar) {
            if(currentfragment != FRAGMENT_LICHHOC)
            {
                replaceFragment(new LichHocFragment());
                currentfragment = FRAGMENT_LICHHOC;
            }
        }else if(id == R.id.nav_test) {
            if(currentfragment != FRAGMENT_LICHTHI)
            {
                replaceFragment(new LichThiFragment());
                currentfragment = FRAGMENT_LICHTHI;
            }
        }else if(id == R.id.nav_change_profile) {
            if(currentfragment != FRAGMENT_PROFILE)
            {
                replaceFragment(new ChangeProfileFragment());
                currentfragment = FRAGMENT_PROFILE;
            }
        }else if(id == R.id.nav_change_password) {
            if(currentfragment != FRAGMENT_PASSWORD)
            {
                replaceFragment(new ChangePasswordFragment());
                currentfragment = FRAGMENT_PASSWORD;
            }
        }else if(id == R.id.Exit) {
            Intent intent = new Intent(Main.this, LoginSV.class);
            startActivity(intent);
        }




        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();
    }

    private void replaceFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.contentFrame,fragment);
        transaction.commit();
    }
    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}