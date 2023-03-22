package com.example.allinone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import com.example.allinone.Model.NewsApiResponse;
import com.example.allinone.Model.NewsHeadlines;

import java.util.List;

public class news extends AppCompatActivity implements SelectListener{
    RecyclerView recyclerView;
    CustomAdapter adapter;

    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        dialog = new ProgressDialog(this);
        dialog.setTitle("Fetching news articles");
        dialog.show();
        RequestManager manager = new RequestManager(this);
        manager.getNewsHeadlines(listener,"Health",null);
    }
    private final OnFetchDataListener<NewsApiResponse> listener = new OnFetchDataListener<NewsApiResponse>() {
        @Override
        void onFetchData(List<NewsHeadlines> list, String message) {
            showNews(list);
            dialog.dismiss();

        }

        @Override
        void onError(String message) {

        }
    };

    private void showNews(List<NewsHeadlines> list){
        recyclerView = findViewById(R.id.recycler_main);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        adapter = new CustomAdapter(this,list,this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void OnNewsClicked(NewsHeadlines headlines) {
        startActivity(new Intent(news.this,DetailsActivity.class)
                .putExtra("data",headlines));
    }
}