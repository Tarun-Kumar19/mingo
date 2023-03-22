package com.example.allinone;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Toast;

import java.util.Arrays;

public class BubbleAdapter extends BaseAdapter {

    private final Context context;
    private final int numBubbles;
    private final int bubbleSize;
    private final int bubbleColor;
    private final int poppedColor;

    private final boolean[] bubblesPopped;

    public BubbleAdapter(Context context, int numBubbles, int bubbleSize, int bubbleColor, int poppedColor) {
        this.context = context;
        this.numBubbles = numBubbles;
        this.bubbleSize = bubbleSize;
        this.bubbleColor = bubbleColor;
        this.poppedColor = poppedColor;

        // Initialize the array of popped bubbles to all false
        bubblesPopped = new boolean[numBubbles];
        Arrays.fill(bubblesPopped, false);
    }

    @Override
    public int getCount() {
        return numBubbles;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Inflate the bubble layout if the view hasn't been created yet
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.bubble, parent, false);

            // Set the size and color of the bubble view
            ViewGroup.LayoutParams layoutParams = convertView.getLayoutParams();
            layoutParams.width = bubbleSize;
            layoutParams.height = bubbleSize;
            convertView.setLayoutParams(layoutParams);
            convertView.setBackgroundColor(Color.YELLOW);
        }

        // Change the color of the bubble view if it has been popped
        if (bubblesPopped[position]) {
            convertView.setBackgroundColor(Color.YELLOW);
        } else {
            convertView.setBackgroundColor(bubbleColor);
        }
        notifyDataSetChanged();
        convertView.setClickable(true);
        return convertView;
    }

    public void burstBubble(int position) {
        if (!bubblesPopped[position]) {
            Toast.makeText(context, "bubbleadapterinvoked", Toast.LENGTH_SHORT).show();
            bubblesPopped[position] = true;
            notifyAll();
        }
    }
}
