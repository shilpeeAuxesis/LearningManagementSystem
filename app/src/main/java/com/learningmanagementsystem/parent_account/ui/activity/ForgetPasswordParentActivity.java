package com.learningmanagementsystem.parent_account.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.learningmanagementsystem.R;
import static com.learningmanagementsystem.ui.constant.Utils.isInternetConnected;
import static com.learningmanagementsystem.ui.constant.Utils.showToast;

public class ForgetPasswordParentActivity extends AppCompatActivity {
    private static final String TAG = "ForgetPasswordParentAct";
    TextView tv_back_arrow,tvHeaderTitle;
    String error_msg = "";
    EditText edtEmail;
    Button btnForgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password_parent);
        initUI();
    }

    private void initUI() {
        tv_back_arrow = findViewById(R.id.tv_back_arrow);
        tvHeaderTitle = findViewById(R.id.tvHeaderTitle);
        tvHeaderTitle.setText(getResources().getString(R.string.forgot_password));
        tv_back_arrow.setOnClickListener(v -> {
            onBackPressed();
        });

        edtEmail = findViewById(R.id.edtEmail);
        btnForgotPassword = findViewById(R.id.btnForgotPassword);
        btnForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isInternetConnected(getApplicationContext())) {
                    if (Validation()) {
                         getForgetPassword();
                    } else {
                        showToast(ForgetPasswordParentActivity.this, error_msg);
                    }
                } else {
                    showToast(ForgetPasswordParentActivity.this, getResources().getString(R.string.oops_connect_your_internet));
                }
            }
            private void getForgetPassword() {
                startActivity(new Intent(ForgetPasswordParentActivity.this,LoginParentActivity.class));
            }
        });
    }

    private boolean Validation() {
        error_msg = "";
        if (TextUtils.isEmpty(edtEmail.getText().toString().trim())) {
            error_msg = getString(R.string.enter_email_address);
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
