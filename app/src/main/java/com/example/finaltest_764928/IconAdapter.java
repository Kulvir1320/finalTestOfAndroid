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
            imageView.setBackgroundResource(images[i]);
            // imageView.setImageResource(image[i]);

        }
        return view;

    }


}

