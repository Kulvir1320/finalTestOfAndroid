package com.example.finaltest_764928;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
interface Listener{
    void onItemClick(int id);
}
public class profiles_fragment extends Fragment {
    private Context context;
    private Listener listener;
    public profiles_fragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.listener = (Listener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.context = inflater.getContext();
        View view = inflater.inflate(R.layout.fragment_profiles_fragment, container, false);
       user_profile_adapter userProfileAdapter = new user_profile_adapter(context, UserDetails.DetailsOfUser , R.layout.user_profile_layout);
        ListView listView = view.findViewById(R.id.listview);
        listView.setAdapter(userProfileAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (listener != null){
                    listener.onItemClick(position);
                }
            }
        });
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if(view != null) {
            Button Addbtn = view.findViewById(R.id.Add_user);
          //  ListView listView = view.findViewById(R.id.listview);
            Addbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getContext(),registerActivity.class);
                    startActivity(intent);
                }
            });

        }
    }
}
