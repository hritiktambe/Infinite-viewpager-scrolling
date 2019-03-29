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

public class Fragment3 extends Fragment {

    private ImageView img3;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment3_layout,container,false);

        img3 = view.findViewById(R.id.img3);
        img3.setImageResource(R.drawable.img3);

        Glide.with(this.getActivity())
                .asBitmap()
                .load("https://i.redd.it/k98uzl68eh501.jpg")
                .into(img3);


        return view;


    }
}
