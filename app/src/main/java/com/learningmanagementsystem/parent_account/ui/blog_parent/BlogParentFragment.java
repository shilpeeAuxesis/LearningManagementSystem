package com.learningmanagementsystem.parent_account.ui.blog_parent;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import com.learningmanagementsystem.R;

public class BlogParentFragment extends Fragment {
    private static final String TAG = "BlogParentFragment";
    private BlogViewModel blogViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        blogViewModel = ViewModelProviders.of(this).get(BlogViewModel.class);
        View root = inflater.inflate(R.layout.fragment_blog_parent, container, false);

        /*final TextView textView = root.findViewById(R.id.text_slideshow);
        blogViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/

        Log.d(TAG, "onCreateView: ");
        
        return root;
    }
}