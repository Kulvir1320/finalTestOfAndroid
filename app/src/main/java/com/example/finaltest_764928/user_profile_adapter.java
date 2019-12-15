package com.example.finaltest_764928;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class user_profile_adapter extends ArrayAdapter {

    private ArrayList<UserDetails> details;
    private final LayoutInflater layoutInflater;
    private final int layoutResource;

    Context c;

    public user_profile_adapter(Context context, ArrayList<UserDetails> details, int layoutResource) {
        super(context, layoutResource);
        this.details = details;
        this.layoutInflater = LayoutInflater.from(context);
        this.layoutResource = layoutResource;
        this.c = context;
    }

    @Override
    public int getCount() {
        return details.size();
    }





    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view= convertView;
        if (view == null)
            view = layoutInflater.inflate(layoutResource, parent, false);

ImageView View_image = view.findViewById(R.id.imageView);

        TextView tv_name = view.findViewById(R.id.textViewName);
        TextView tv_email = view.findViewById(R.id.textViewEmail);
        TextView tv_phone = view.findViewById(R.id.textViewPhone);
        tv_name.setText(details.get(position).getEmail());
        tv_email.setText(details.get(position).getName());

        tv_phone.setText(details.get(position).getPhone());
        View_image.setImageResource(R.drawable.ic_launcher_background);

        return view;
    }

}