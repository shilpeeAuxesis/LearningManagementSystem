package com.learningmanagementsystem.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import com.learningmanagementsystem.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    CircleImageView circleImgTeacher,circleImgParent;

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
            startActivity(new Intent(LoginActivity.this, ParentRegisterActivity.class));
            overridePendingTransition(R.anim.enter, R.anim.exit);
        });
    }

}
