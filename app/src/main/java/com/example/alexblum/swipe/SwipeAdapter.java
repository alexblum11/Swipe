package com.example.alexblum.swipe;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Alexander on 12/11/2016.
 */

public class SwipeAdapter extends FragmentStatePagerAdapter {
    public SwipeAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(final int i) {

        final Fragment fragment = new FragmentPage();
        final Bundle bundle = new Bundle();
        bundle.putInt("count",i+1);
        fragment.setArguments(bundle);

        return fragment;

    }

    @Override
    public int getCount() {
//     FirebaseDatabase database = FirebaseDatabase.getInstance();
//        final DatabaseReference dataQuestions = database.getReference();
// dataQuestions.child("questions").addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                count = (int) dataSnapshot.getChildrenCount();
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });

        return 10;
    }
}
