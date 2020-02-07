package com.learningmanagementsystem.ui.contact_us;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import com.learningmanagementsystem.R;

public class ContactUsFragment extends Fragment {
    private static final String TAG = "ContactUsFragment";

    private ContactUsViewModel galleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel = ViewModelProviders.of(this).get(ContactUsViewModel.class);

        View root = inflater.inflate(R.layout.fragment_contact_us, container, false);

      /*  final TextView textView = root.findViewById(R.id.text_gallery);
        galleryViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        }); */

        return root;
    }
}