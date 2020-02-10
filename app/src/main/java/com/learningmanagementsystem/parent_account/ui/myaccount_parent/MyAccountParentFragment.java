package com.learningmanagementsystem.parent_account.ui.myaccount_parent;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.learningmanagementsystem.R;

public class MyAccountParentFragment extends Fragment {
    private static final String TAG = "MyAccountParentFragment";

    public MyAccountParentFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.fragment_my_account_parent, container, false);


        return root;
    }

}
