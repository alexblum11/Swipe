package com.example.alexblum.swipe;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Matching extends FragmentActivity implements View.OnClickListener{
    ViewPager viewPager;

    private Button buttonNo;
    private Button buttonSkip;
    private Button buttonYes;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matching);
        viewPager = (ViewPager) findViewById(R.id.view_pager);

        buttonNo = (Button) findViewById(R.id.buttonNo);
        buttonSkip = (Button) findViewById(R.id.buttonSkip);
        buttonYes = (Button) findViewById(R.id.buttonYes);


        SwipeAdapter swipeAdapter = new SwipeAdapter(getSupportFragmentManager());
        viewPager.setAdapter(swipeAdapter);
    }

    @Override
    public void onClick(View v) {
        if (v==buttonNo) {
            //set question property to -1
            //continue with next question
        } else if(v==buttonYes) {
            //set question property to +1
            //continue with next question
        
        } else if(v==buttonSkip){
            //set question property to 0
            //continue with next question
        }
    }
}
