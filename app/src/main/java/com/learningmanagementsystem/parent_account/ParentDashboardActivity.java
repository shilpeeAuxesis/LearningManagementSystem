package com.learningmanagementsystem.parent_account;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.navigation.NavigationView;
import com.learningmanagementsystem.R;
import com.learningmanagementsystem.parent_account.ui.activity.LoginParentActivity;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.widget.TextView;
import static com.learningmanagementsystem.ui.constant.Utils.getPreference;
import static com.learningmanagementsystem.ui.constant.Utils.setPreference;
import static com.learningmanagementsystem.ui.constant.Utils.showToast;

public class ParentDashboardActivity extends AppCompatActivity {
    private static final String TAG = "ParentDashboardActivity";
    private AppBarConfiguration mAppBarConfiguration;
    NavigationView navigationView;
    TextView tv_parent_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_dashboard);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        View headerView = navigationView.getHeaderView(0);
        tv_parent_name = (TextView) headerView.findViewById(R.id.tv_parent_name);

        String mName = getPreference(ParentDashboardActivity.this, "username").toLowerCase();
        if (mName != null && !mName.isEmpty()) {
            String userName = mName.substring(0, 1).toUpperCase() + mName.substring(1);
            tv_parent_name.setText(userName);
        }

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_my_space_parent, R.id.nav_my_account_parent, R.id.nav_contact_us_parent, R.id.nav_blog_parent,
                R.id.nav_about_us_parent, R.id.nav_fag_parent, R.id.nav_logout_parent)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_parent);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        //For nav item click listner
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                if (id == R.id.nav_my_space_parent) {
                    setActionBarTitle(getString(R.string.menu_my_space));
                } else if (id == R.id.nav_my_account_parent) {
                    setActionBarTitle(getString(R.string.menu_my_parent_account));
                } else if (id == R.id.nav_contact_us_parent) {
                    setActionBarTitle(getString(R.string.menu_contact_us));
                } else if (id == R.id.nav_blog_parent) {
                    setActionBarTitle(getString(R.string.menu_Blog));
                } else if (id == R.id.nav_about_us_parent) {
                    setActionBarTitle(getString(R.string.menu_about_us));
                } else if (id == R.id.nav_logout_parent) {
                    setPreference(ParentDashboardActivity.this, "username", "");
                    showToast(ParentDashboardActivity.this, getResources().getString(R.string.logout_succ));
                    Intent intent = new Intent(ParentDashboardActivity.this, LoginParentActivity.class);
                    startActivity(intent);
                    finish();
                }
                //This is for maintaining the behavior of the Navigation view
                NavigationUI.onNavDestinationSelected(menuItem, navController);
                //This is for closing the drawer after acting on it
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.parent_dashboard, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_parent);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

}
