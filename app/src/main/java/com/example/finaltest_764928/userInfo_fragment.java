package com.example.finaltest_764928;


import android.icu.text.Transliterator;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class userInfo_fragment extends Fragment {


    public void showDetails(int id)
    {
        View view = getView();
        if(view != null) {
            ImageView userimage = view.findViewById(R.id.userimage);
            TextView name = view.findViewById(R.id.name);
            TextView email = view.findViewById(R.id.gmail);
            TextView phone = view.findViewById(R.id.phoneNumber);
            UserDetails userDetails = UserDetails.DetailsOfUser.get(id);
            name.setText(userDetails.getName());
            email.setText(userDetails.getEmail());
            phone.setText(userDetails.getPhone());
            userimage.setImageResource(R.drawable.ic_launcher_foreground);

        }
    }


    public userInfo_fragment() {
        // Required empty public coÜ€€nstructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_info_fragment, container, false);
    }

}
