package com.hritiktambe.viewpagerandrecyclermerged;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.hritiktambe.viewpagerandrecyclermerged.adapter.RecyclerViewAdapter;
import com.hritiktambe.viewpagerandrecyclermerged.adapter.SectionStatePageAdapter;
import com.hritiktambe.viewpagerandrecyclermerged.fragment.Fragment1;
import com.hritiktambe.viewpagerandrecyclermerged.fragment.Fragment2;
import com.hritiktambe.viewpagerandrecyclermerged.fragment.Fragment3;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    //recyclerview
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    //fragment
    private SectionStatePageAdapter mSectionStatePageAdapter;
    private ViewPager mViewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getImages();

        mSectionStatePageAdapter = new SectionStatePageAdapter(getSupportFragmentManager());
        mViewPager = findViewById(R.id.container1);
        setupViewPager(mViewPager);
        pageSwitcher(3);


        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
//                page = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



    }

//recyclerview
    private void getImages(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageUrls.add("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg");
        mNames.add("Havasu Falls");

        mImageUrls.add("https://i.redd.it/tpsnoz5bzo501.jpg");
        mNames.add("Trondheim");

        mImageUrls.add("https://i.redd.it/qn7f9oqu7o501.jpg");
        mNames.add("Portugal");

        mImageUrls.add("https://i.redd.it/j6myfqglup501.jpg");
        mNames.add("Rocky Mountain National Park");


        mImageUrls.add("https://i.redd.it/0h2gm1ix6p501.jpg");
        mNames.add("Mahahual");

        mImageUrls.add("https://i.redd.it/k98uzl68eh501.jpg");
        mNames.add("Frozen Lake");


        mImageUrls.add("https://i.redd.it/glin0nwndo501.jpg");
        mNames.add("White Sands Desert");

        mImageUrls.add("https://i.redd.it/obx4zydshg601.jpg");
        mNames.add("Austrailia");

        mImageUrls.add("https://i.imgur.com/ZcLLrkY.jpg");
        mNames.add("Washington");

        initRecyclerView();

    }


    private void initRecyclerView(){

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        RecyclerView recyclerView = findViewById(R.id.horz1);
        recyclerView.setLayoutManager(linearLayoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this,mNames ,mImageUrls);
        recyclerView.setAdapter(adapter);

    }

    //fragment

    Timer timer;
    int page = 1;

    public void pageSwitcher(int seconds) {
        timer = new Timer(); // At this line a new Thread will be created
        timer.scheduleAtFixedRate(new RemindTask(), 0, seconds * 1000); // delay
        // in
        // milliseconds
    }

    // this is an inner class...
    class RemindTask extends TimerTask {

        @Override
        public void run() {

            // As the TimerTask run on a seprate thread from UI thread we have
            // to call runOnUiThread to do work on UI thread.
            runOnUiThread(new Runnable() {
                public void run() {

                    if (page > 2) { // In my case the number of pages are 5
//                        timer.cancel();
                        page = 0;
                        mViewPager.setCurrentItem(page++);
                        // Showing a toast for just testing purpose
                        Toast.makeText(getApplicationContext(), "Timer stoped",
                                Toast.LENGTH_LONG).show();
                    } else {
                        mViewPager.setCurrentItem(page++);
                    }
                }
            });

        }}

    private void setupViewPager(ViewPager viewPager){

        SectionStatePageAdapter adapter = new SectionStatePageAdapter(getSupportFragmentManager());
        adapter.addFragment(new Fragment1(),"Fragment 1");
        adapter.addFragment(new Fragment2(),"Fragment2");
        adapter.addFragment(new Fragment3(),"Fragment3");
        viewPager.setAdapter(adapter);



    }

    public void setViewPager(final int Fragmentnum){

        mViewPager.setCurrentItem(Fragmentnum);

    }


}
