package com.learningmanagementsystem.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.learningmanagementsystem.R;
import com.learningmanagementsystem.parent_account.ui.activity.LoginParentActivity;
import de.hdodenhof.circleimageview.CircleImageView;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    CircleImageView circleImgTeacher, circleImgParent;
    String account = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.d(TAG, "onCreate: ");

        initUI();
    }

    private void initUI() {
        circleImgTeacher = findViewById(R.id.circleImgTeacher);
        circleImgParent = findViewById(R.id.circleImgParent);

        circleImgTeacher.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, TeacherLoginActivity.class));
            overridePendingTransition(R.anim.enter, R.anim.exit);
        });

        circleImgParent.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, LoginParentActivity.class));
            overridePendingTransition(R.anim.enter, R.anim.exit);
        });
    }
}
