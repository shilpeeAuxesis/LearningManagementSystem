package com.learningmanagementsystem.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.learningmanagementsystem.TeacherDashboardActivity;
import com.learningmanagementsystem.R;
import com.learningmanagementsystem.ui.constant.ProgressDialog;
import static com.learningmanagementsystem.ui.constant.Utils.isInternetConnected;
import static com.learningmanagementsystem.ui.constant.Utils.setPreference;
import static com.learningmanagementsystem.ui.constant.Utils.showToast;

public class TeacherLoginActivity extends AppCompatActivity {
    private static final String TAG = "TeacherLoginActivity";
    TextView tv_back_arrow, tvHeaderTitle, tvForgetPassword;
    EditText edtUsername, edtPassword;
    Button btnLogin;
    RelativeLayout rLayoutRegister;
    String error_msg = "";
    ProgressDialog pd;
    String message = "";

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

        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        rLayoutRegister = findViewById(R.id.rLayoutRegister);
        tvForgetPassword = findViewById(R.id.tvForgetPassword);

        btnLogin.setOnClickListener(v -> {
            if (isInternetConnected(getApplicationContext())) {
                String username = edtUsername.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();
                setPreference(TeacherLoginActivity.this, "username", username);
                showToast(TeacherLoginActivity.this,  getResources().getString(R.string.login_succ));
                startActivity(new Intent(TeacherLoginActivity.this, TeacherDashboardActivity.class));
               /* if (Validation()) {
                    getLogin();
                } else {
                    showToast(TeacherLoginActivity.this, error_msg);
                }*/
            } else {
                showToast(TeacherLoginActivity.this, getResources().getString(R.string.oops_connect_your_internet));
            }
        });

        rLayoutRegister.setOnClickListener(v -> {
            startActivity(new Intent(TeacherLoginActivity.this, TeacherRegisterActivity.class));
        });

        tvForgetPassword.setOnClickListener(v -> {
            showToast(TeacherLoginActivity.this, "Coming soon...");
        });
    }

    private void getLogin() {
        String username = edtUsername.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();
        setPreference(TeacherLoginActivity.this, "username", username);
        showToast(TeacherLoginActivity.this,  getResources().getString(R.string.login_succ));
        startActivity(new Intent(TeacherLoginActivity.this, TeacherDashboardActivity.class));
    }

    private boolean Validation() {
        error_msg = "";
        if (TextUtils.isEmpty(edtUsername.getText().toString().trim())) {
            error_msg = getString(R.string.enter_username);
            return false;
        } else if (TextUtils.isEmpty(edtPassword.getText().toString().trim())) {
            error_msg = getString(R.string.enter_password);
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
