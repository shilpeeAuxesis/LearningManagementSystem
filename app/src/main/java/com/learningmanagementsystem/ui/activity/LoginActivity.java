package com.learningmanagementsystem.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import com.learningmanagementsystem.R;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    LinearLayout lLayoutTeacher, lLayoutParent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.d(TAG, "onCreate: ");

        initUI();
    }

    private void initUI() {
        lLayoutTeacher = findViewById(R.id.lLayoutTeacher);
        lLayoutParent = findViewById(R.id.lLayoutParent);

        lLayoutTeacher.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, TeacherLoginActivity.class));
            overridePendingTransition(R.anim.enter, R.anim.exit);
        });

        lLayoutParent.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, ParentRegisterActivity.class));
            overridePendingTransition(R.anim.enter, R.anim.exit);
        });
    }

}
