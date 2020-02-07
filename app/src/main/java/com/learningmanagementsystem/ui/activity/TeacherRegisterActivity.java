package com.learningmanagementsystem.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.learningmanagementsystem.R;
import com.learningmanagementsystem.TeacherDashboardActivity;
import com.learningmanagementsystem.ui.constant.ProgressDialog;

import static com.learningmanagementsystem.ui.constant.Utils.isInternetConnected;
import static com.learningmanagementsystem.ui.constant.Utils.showToast;

public class TeacherRegisterActivity extends AppCompatActivity {
    private static final String TAG = "TeacherRegisterActivity";
    TextView tv_back_arrow, tvHeaderTitle,edtUploadResume;
    String error_msg = "";
    ProgressDialog pd;
    Button btnRegister;
    CheckBox checkTermAndCondition;
    EditText edtEmail,edtFullName,edtSkypeId,edtSubject;

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

        edtEmail =findViewById(R.id.edtEmail);
        edtFullName =findViewById(R.id.edtFullName);
        edtSkypeId =findViewById(R.id.edtSkypeId);
        edtSubject =findViewById(R.id.edtSubject);

        checkTermAndCondition =findViewById(R.id.checkTermAndCondition);
        btnRegister =findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(v -> {
            if (isInternetConnected(getApplicationContext())) {
                if (Validation()) {
                    getRegister();
                } else {
                    showToast(TeacherRegisterActivity.this, error_msg);
                }
            } else {
                showToast(TeacherRegisterActivity.this, getResources().getString(R.string.oops_connect_your_internet));
            }
        });
    }

    private void getRegister() {
        showToast(TeacherRegisterActivity.this,  getResources().getString(R.string.teacher_register_succ));
        startActivity(new Intent(TeacherRegisterActivity.this, TeacherLoginActivity.class));
    }


    private boolean Validation() {
        error_msg = "";
        if (TextUtils.isEmpty(edtEmail.getText().toString().trim())) {
            error_msg = getString(R.string.enter_email_address);
            return false;
        } else if (TextUtils.isEmpty(edtFullName.getText().toString().trim())) {
            error_msg = getString(R.string.enter_full_name);
            return false;
        } else if (TextUtils.isEmpty(edtSkypeId.getText().toString().trim())) {
            error_msg = getString(R.string.enter_skype_id);
            return false;
        }else if (TextUtils.isEmpty(edtSubject.getText().toString().trim())) {
            error_msg = getString(R.string.enter_subject_name);
            return false;
        }else {
            return true;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
