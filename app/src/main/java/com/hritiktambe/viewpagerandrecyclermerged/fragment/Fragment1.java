package com.hritiktambe.viewpagerandrecyclermerged.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.hritiktambe.viewpagerandrecyclermerged.R;

public class Fragment1 extends Fragment {

    private ImageView img1;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment1_layout,container,false);

        img1 = view.findViewById(R.id.img1);
        img1.setImageResource(R.drawable.img1);

        Glide.with(this.getActivity())
                .asBitmap()
                .load("https://i.redd.it/tpsnoz5bzo501.jpg")
                .into(img1);


        return view;


    }
}
