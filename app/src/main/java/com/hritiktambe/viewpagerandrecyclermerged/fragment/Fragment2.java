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

public class Fragment2 extends Fragment {

    private ImageView img2;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment2_layout,container,false);

        img2 = view.findViewById(R.id.img2);
        img2.setImageResource(R.drawable.img2);

        Glide.with(this.getActivity())
                .asBitmap()
                .load("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg")
                .into(img2);


        return view;


    }
}
