package com.mac.newsapp.models;


import android.util.Log;

import com.mac.newsapp.interfaces.ObservableEntity;

public class AlterationEntity implements ObservableEntity {
    @Override
    public void notify(String news) {
        news = "XYZ " + news + ". ";
        Log.d(this.getClass().getSimpleName(), news);
    }
}
