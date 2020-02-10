package com.learningmanagementsystem.parent_account.ui.activity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.learningmanagementsystem.R;
import com.learningmanagementsystem.ui.constant.ProgressDialog;
import java.util.Calendar;

public class RegisterParentActivity extends AppCompatActivity {
    private static final String TAG = "RegisterParentActivity";
    TextView tv_back_arrow, tvHeaderTitle, tvDOB;
    String error_msg = "";
    ProgressDialog pd;
    EditText edtEmail, edtStudentName, edtParentName, edtSkypeId;
    Button btnRegister;
    private int mYear, mMonth, mDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_register);
        initUI();
    }

    private void initUI() {
        tv_back_arrow = findViewById(R.id.tv_back_arrow);
        tvHeaderTitle = findViewById(R.id.tvHeaderTitle);
        tvHeaderTitle.setText(getResources().getString(R.string.parent_register));
        tv_back_arrow.setOnClickListener(v -> {
            onBackPressed();
        });

        edtEmail = findViewById(R.id.edtEmail);
        edtStudentName = findViewById(R.id.edtStudentName);
        edtParentName = findViewById(R.id.edtParentName);
        edtSkypeId = findViewById(R.id.edtSkypeId);

        tvDOB = findViewById(R.id.tvDOB);

        btnRegister = findViewById(R.id.btnRegister);
        tvDOB.setOnClickListener(v -> {
            getCustomDate();
        });
    }

    private void getCustomDate() {
        // Get Current Date
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        tvDOB.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    }
                }, mYear, mMonth, mDay);

        datePickerDialog.show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
