package com.example.uts_if6_10119242_nadyanurulawaliyah;


import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class PageOneFragment extends Fragment {

    private ViewGroup vGroup;
    //    private Button mButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        vGroup = (ViewGroup) inflater.inflate(
                R.layout.activity_page_one_fragment, container, false);

//        mButton = vGroup.findViewById(R.id.starthere);
//        mButton.setOnClickListener(view -> {
//            startActivity(new Intent(getActivity(),MainActivity.class));
//        });

        return vGroup;
    }
}