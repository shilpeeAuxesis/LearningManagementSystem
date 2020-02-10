package com.learningmanagementsystem.parent_account.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.learningmanagementsystem.R;
import com.learningmanagementsystem.parent_account.ParentDashboardActivity;
import com.learningmanagementsystem.ui.constant.ProgressDialog;
import static com.learningmanagementsystem.ui.constant.Utils.isInternetConnected;
import static com.learningmanagementsystem.ui.constant.Utils.setPreference;
import static com.learningmanagementsystem.ui.constant.Utils.showToast;

public class LoginParentActivity extends AppCompatActivity {
    TextView tv_back_arrow, tvHeaderTitle, tvForgetPassword;
    EditText edtUsername, edtPassword;
    Button btnLogin;
    RelativeLayout rLayoutRegister;
    String error_msg = "";
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_login);

        initUI();
    }

    private void initUI() {
        tv_back_arrow = findViewById(R.id.tv_back_arrow);
        tvHeaderTitle = findViewById(R.id.tvHeaderTitle);
        tvHeaderTitle.setText(getResources().getString(R.string.parent_login));

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
                getParentLogin();
              /*  if (Validation()) {
                  //  getParentLogin();
                } else {
                    showToast(LoginParentActivity.this, error_msg);
                }*/
            } else {
                showToast(LoginParentActivity.this, getResources().getString(R.string.oops_connect_your_internet));
            }
        });

        rLayoutRegister.setOnClickListener(v -> {
            startActivity(new Intent(LoginParentActivity.this, RegisterParentActivity.class));

        });

        tvForgetPassword.setOnClickListener(v -> {
            startActivity(new Intent(LoginParentActivity.this, ForgetPasswordParentActivity.class));
        });
    }

    private void getParentLogin() {
        String username = edtUsername.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();
        setPreference(LoginParentActivity.this, "username", username);
        showToast(LoginParentActivity.this,  getResources().getString(R.string.login_succ));
        startActivity(new Intent(LoginParentActivity.this, ParentDashboardActivity.class));
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
