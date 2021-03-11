package com.example.lab3.ui.notifications;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.lab3.ui.countries.CountriesFragment;

public class NotificationsViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private MutableLiveData<CountriesFragment> countriesFragment;

    public NotificationsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
        countriesFragment= new MutableLiveData<CountriesFragment>();

    }

    public LiveData<String> getText() {
        return mText;
    }

   
}