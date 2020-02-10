package com.learningmanagementsystem.ui.myaccount_teacher;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.learningmanagementsystem.R;

public class TeacherMyAccountFragment extends Fragment {

    private TeacherMyAccountViewModel mViewModel;

    public static TeacherMyAccountFragment newInstance() {
        return new TeacherMyAccountFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.teacher_my_account_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(TeacherMyAccountViewModel.class);
        // TODO: Use the ViewModel
    }

}
