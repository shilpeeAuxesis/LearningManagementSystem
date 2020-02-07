package com.learningmanagementsystem.ui.myspace;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MySpaceViewModel extends ViewModel {
    private static final String TAG = "MySpaceViewModel";

    private MutableLiveData<String> mText;

    public MySpaceViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}