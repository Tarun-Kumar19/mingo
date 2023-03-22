package com.example.allinone;

import android.os.Bundle;

import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class quoteoftheday extends AppCompatActivity {

    private TextView mQuoteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mQuoteTextView = findViewById(R.id.quoteTextView);

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://type.fit/api/quotes";

        // Request a JSON response from the provided URL.
        JsonArrayRequest jsonRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            // Pick a random quote from the response.
                            int randomIndex = (int) (Math.random() * response.length());
                            JSONObject quoteObject = response.getJSONObject(randomIndex);

                            // Extract the text and author fields of the quote.
                            String quoteText = quoteObject.getString("text");
                            String quoteAuthor = quoteObject.getString("author");

                            // Display the quote in the TextView.
                            String quoteString = "\"" + quoteText + "\"\n- " + quoteAuthor;
                            mQuoteTextView.setText(quoteString);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });
        // Add the request to the RequestQueue.
        queue.add(jsonRequest);
    }
}
