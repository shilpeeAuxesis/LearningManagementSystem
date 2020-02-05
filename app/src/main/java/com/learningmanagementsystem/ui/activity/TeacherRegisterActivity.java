package com.learningmanagementsystem.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.learningmanagementsystem.R;

public class TeacherRegisterActivity extends AppCompatActivity {
    private static final String TAG = "TeacherRegisterActivity";
    TextView tv_back_arrow, tvHeaderTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_register);

        initUI();
    }

    private void initUI() {
        tv_back_arrow = findViewById(R.id.tv_back_arrow);
        tvHeaderTitle = findViewById(R.id.tvHeaderTitle);
        tvHeaderTitle.setText(getResources().getString(R.string.teacher_register));
        tv_back_arrow.setOnClickListener(v -> {
            onBackPressed();
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
