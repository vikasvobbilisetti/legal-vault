package com.ziroh.legalvault.dashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.ziroh.legalvault.MainActivity;
import com.ziroh.legalvault.databinding.ActivityDashboardTemplateBinding;
import com.ziroh.legalvault.R;
import com.ziroh.legalvault.login.UserExistsLogin;
import com.ziroh.legalvault.login.UserLogin;
import com.ziroh.legalvault.profile.Profile;

public class DashboardTemplate extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private ActivityDashboardTemplateBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDashboardTemplateBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new DashboardTabHeader());
        BottomNavigationView mBottomNavigationView=(BottomNavigationView)findViewById(R.id.bottomNavigationView);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        setSupportActionBar(toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navi_open,R.string.navi_close);
        toggle.getDrawerArrowDrawable().setColor(getColor(R.color.dark_brown));
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                navigationView.getMenu().findItem(R.id.nav_dash).setChecked(false);
                navigationView.getMenu().findItem(R.id.nav_create).setChecked(false);
                navigationView.getMenu().findItem(R.id.nav_manage).setChecked(false);
                navigationView.getMenu().findItem(R.id.nav_settin).setChecked(false);
                int id = item.getItemId();
                item.setChecked(true);
                drawerLayout.closeDrawer(GravityCompat.START);
                switch (id)
                {
                    case R.id.nav_dash:
                        toolbar.setTitle("Dashboard");
                        mBottomNavigationView.getMenu().findItem(R.id.dashboard).setChecked(true);
                        replaceFragment(new DashboardTabHeader());
                        break;
                    case R.id.nav_create:
                        toolbar.setTitle("Create Team");
                        mBottomNavigationView.getMenu().findItem(R.id.create).setChecked(true);
                        replaceFragment(new DashboardCreateTeam());
                        break;
                    case R.id.nav_help:
                        toolbar.setTitle("Help");
                        replaceFragment(new DashboardHelp());
                        break;
                    case R.id.nav_prof:
                        toolbar.setTitle("Profile");
                        replaceFragment(new Profile());
                        break;
                    case R.id.nav_tandc:
                        toolbar.setTitle("Terms and Conditions");
                        replaceFragment(new DashboardTermsAndConditions());
                        break;
                    case R.id.nav_cpa:
                        toolbar.setTitle("About CPA Vault");
                        replaceFragment(new DashboardAbout());
                        break;
                    case R.id.nav_manage:
                        toolbar.setTitle("Manage Team");
                        mBottomNavigationView.getMenu().findItem(R.id.manage).setChecked(true);
                        replaceFragment(new DashboardManageTeam());
                        break;
                    case R.id.nav_settin:
                        toolbar.setTitle("Settings");
                        mBottomNavigationView.getMenu().findItem(R.id.settings).setChecked(true);
                        replaceFragment(new DashboardSettings());
                        break;
                    case R.id.nav_logout:
                        Intent intent = new Intent(DashboardTemplate.this, MainActivity.class);
                        startActivity(intent);
                        break;
                }
                return true;
            }
        });

        binding.bottomNavigationView.setOnItemSelectedListener( item -> {
            switch (item.getItemId()){
                case R.id.dashboard:
                    toolbar.setTitle("Dashboard");
                    navigationView.getMenu().findItem(R.id.nav_dash).setChecked(true);
                    navigationView.getMenu().findItem(R.id.nav_create).setChecked(false);
                    navigationView.getMenu().findItem(R.id.nav_manage).setChecked(false);
                    navigationView.getMenu().findItem(R.id.nav_settin).setChecked(false);
                    replaceFragment(new DashboardTabHeader());
                    break;
                case R.id.create:
                    toolbar.setTitle("Create Team");
                    navigationView.getMenu().findItem(R.id.nav_create).setChecked(true);
                    navigationView.getMenu().findItem(R.id.nav_manage).setChecked(false);
                    navigationView.getMenu().findItem(R.id.nav_settin).setChecked(false);
                    navigationView.getMenu().findItem(R.id.nav_dash).setChecked(false);
                    replaceFragment(new DashboardCreateTeam());
                    break;
                case R.id.manage:
                    toolbar.setTitle("Manage Team");
                    navigationView.getMenu().findItem(R.id.nav_manage).setChecked(true);
                    navigationView.getMenu().findItem(R.id.nav_dash).setChecked(false);
                    navigationView.getMenu().findItem(R.id.nav_create).setChecked(false);
                    navigationView.getMenu().findItem(R.id.nav_settin).setChecked(false);
                    replaceFragment(new DashboardManageTeam());
                    break;
                case R.id.settings:
                    toolbar.setTitle("Settings");
                    navigationView.getMenu().findItem(R.id.nav_settin).setChecked(true);
                    navigationView.getMenu().findItem(R.id.nav_dash).setChecked(false);
                    navigationView.getMenu().findItem(R.id.nav_create).setChecked(false);
                    navigationView.getMenu().findItem(R.id.nav_manage).setChecked(false);
                    replaceFragment(new DashboardSettings());
                    break;

            }

            return true;
        });
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView,fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed(){

        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.dashboard_top_navigation,menu);
        return true;
    }

    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return true;
    }
}