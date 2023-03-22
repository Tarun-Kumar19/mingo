package com.example.allinone;

import com.example.allinone.Model.NewsHeadlines;

import java.util.List;

public abstract class OnFetchDataListener<NewsApiResponse> {
    abstract void onFetchData(List<NewsHeadlines> list, String message);
    abstract void onError(String message);

}
