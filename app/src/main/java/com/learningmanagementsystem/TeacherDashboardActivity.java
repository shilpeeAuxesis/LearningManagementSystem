package com.learningmanagementsystem;

import android.os.Bundle;
import android.view.View;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.navigation.NavigationView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.widget.TextView;
import static com.learningmanagementsystem.ui.constant.Utils.getPreference;

public class TeacherDashboardActivity extends AppCompatActivity {
    private static final String TAG = "TeacherDashboardActivity";
    private AppBarConfiguration mAppBarConfiguration;
    NavigationView navigationView;
    TextView tv_user_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_dashboard);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        View v = navigationView.getHeaderView(0);
        tv_user_name = (TextView) v.findViewById(R.id.tv_user_name);

        String mName = getPreference(TeacherDashboardActivity.this, "username").toLowerCase();
        if (mName != null && !mName.isEmpty()) {
            String userName = mName.substring(0, 1).toUpperCase() + mName.substring(1);
            tv_user_name.setText(userName);
        }
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_my_space, R.id.nav_contact_us, R.id.nav_blog,
                R.id.nav_about_us, R.id.nav_faq, R.id.nav_logout)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.teacher, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)|| super.onSupportNavigateUp();
    }
}
