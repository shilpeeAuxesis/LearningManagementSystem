package com.learningmanagementsystem.parent_account.ui.my_space_parent;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MySpaceParentViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MySpaceParentViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is fragment parent");
    }

    public LiveData<String> getText() {
        return mText;
    }
}