package com.example.finaltest_764928;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.Random;

public class IconAdapter extends BaseAdapter {

    Context context;
    int[]images;

    public IconAdapter(Context context, int[] images) {
        this.context = context;
        this.images = images;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null)
        {
            view = LayoutInflater.from(context).inflate(R.layout.layout_gimage, null);
            ImageView imageView = view.findViewById(R.id.image_view);
            int[] image = shufflingImages(images);
            imageView.setBackgroundResource(image[i]);
            // imageView.setImageResource(image[i]);

        }
        return view;

    }
    static int[] shufflingImages(int[] arraylist) {
        Random r = new Random();
        for(int i = 0; i< 5 ; i++)
        {
            int ind = r.nextInt(5);
            int t = arraylist[ind];
            arraylist[ind] = arraylist[i];
            arraylist[i] = t;
        }
        return arraylist;
    }

}

