package com.learningmanagementsystem.parent_account.ui.my_space_parent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import com.learningmanagementsystem.R;
import com.learningmanagementsystem.parent_account.ParentDashboardActivity;
import com.learningmanagementsystem.ui.constant.ProgressDialog;

public class MySpaceParentFragment extends Fragment {
    private static final String TAG = "MySpaceParentFragment";
    private MySpaceParentViewModel homeViewModel;
    RecyclerView recyclerView;
    TextView tvNoDataFound;
    ProgressDialog pd;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(false);
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = ViewModelProviders.of(this).get(MySpaceParentViewModel.class);
        View root = inflater.inflate(R.layout.fragment_my_space_parent, container, false);

        recyclerView =root.findViewById(R.id.recyclerView);
        tvNoDataFound =root.findViewById(R.id.tvNoDataFound);

        /*final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/

        return root;
    }

    public void onResume() {
        super.onResume();
        // Set title bar
        ((ParentDashboardActivity) getActivity()).setActionBarTitle(getString(R.string.menu_my_space));
    }
}