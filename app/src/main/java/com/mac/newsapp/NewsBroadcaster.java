package com.mac.newsapp;


import com.mac.newsapp.interfaces.ObservableEntity;

import java.util.ArrayList;
import java.util.List;

public class NewsBroadcaster {

    private static List<ObservableEntity> observersList = new ArrayList<>();

    public static void registerForNews(ObservableEntity observer) {
        observersList.add(observer);
    }

    public static void youGotNewsBrah(String news) {
        for (ObservableEntity observer : observersList) {
            observer.notify(news);
        }
    }
}
