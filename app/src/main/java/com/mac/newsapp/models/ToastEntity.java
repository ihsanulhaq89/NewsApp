package com.mac.newsapp.models;

import android.content.Context;
import android.widget.Toast;

import com.mac.newsapp.interfaces.ObservableEntity;

public class ToastEntity implements ObservableEntity {
    private final Context context;

    public ToastEntity(Context ctx){
        this.context = ctx;
    }
    @Override
    public void notify(String news) {
        Toast.makeText(context, news, Toast.LENGTH_SHORT).show();
    }
}
