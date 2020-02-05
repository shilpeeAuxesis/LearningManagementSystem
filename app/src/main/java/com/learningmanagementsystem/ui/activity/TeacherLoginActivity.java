package com.learningmanagementsystem.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.learningmanagementsystem.R;
import static com.learningmanagementsystem.ui.constant.Utils.isInternetConnected;

public class TeacherLoginActivity extends AppCompatActivity {
    private static final String TAG = "TeacherLoginActivity";
    TextView tv_back_arrow, tvHeaderTitle,tvForgetPassword;
    EditText edtUsername,edtPassword;
    Button btnLogin;
    RelativeLayout rLayoutRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_login);

        initUI();
    }

    private void initUI() {
        tv_back_arrow = findViewById(R.id.tv_back_arrow);
        tvHeaderTitle = findViewById(R.id.tvHeaderTitle);
        tvHeaderTitle.setText(getResources().getString(R.string.teacher_login));
        tv_back_arrow.setOnClickListener(v -> {
            onBackPressed();
        });

        edtUsername =findViewById(R.id.edtUsername);
        edtPassword =findViewById(R.id.edtPassword);
        btnLogin =findViewById(R.id.btnLogin);
        rLayoutRegister =findViewById(R.id.rLayoutRegister);

        btnLogin.setOnClickListener(v -> {
            if (isInternetConnected(getApplicationContext())) {

            }else {
                Toast.makeText(this, getResources().getString(R.string.oops_connect_your_internet), Toast.LENGTH_SHORT).show();
            }
        });

        rLayoutRegister.setOnClickListener(v -> {
            startActivity(new Intent(TeacherLoginActivity.this,TeacherRegisterActivity.class));
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
