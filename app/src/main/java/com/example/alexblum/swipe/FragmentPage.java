package com.example.alexblum.swipe;


import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentPage extends android.support.v4.app.Fragment implements View.OnClickListener {
    TextView textView;
    Button buttonNo;
    Button buttonYes;
    String YesNo;
    Integer ScoreChange = 0;
    Integer thisID;

    public FragmentPage() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_page,container, false);
        textView = (TextView)view.findViewById(R.id.textView);
        //textView.setMovementMethod(new ScrollingMovementMethod());

        buttonNo = (Button) view.findViewById(R.id.buttonNo);
        buttonNo.setOnClickListener(this);
        buttonNo.setBackgroundColor(Color.LTGRAY);

        buttonYes = (Button) view.findViewById(R.id.buttonYes);
        buttonYes.setOnClickListener(this);
        buttonYes.setBackgroundColor(Color.LTGRAY);

        YesNo = "";

        final Bundle bundle = getArguments();
        final Integer count = bundle.getInt("count");



        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference dataQuestions = database.getReference("questions");

        //**************************************************************************************************

        dataQuestions.orderByKey().addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Question Q = dataSnapshot.getValue(Question.class);
                if (count == Q.id) {
                    String question = Q.question;
                    thisID = Q.id;
                    textView.setText("Question ID: "+thisID+":\n"+question);
                    if (Q.score == 1) {
                        buttonYes.setBackgroundColor(Color.GREEN);
                    } else if (Q.score == -1){
                        buttonNo.setBackgroundColor(Color.RED);
                    }
                }

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        return view;
    }

    @Override
    public void onClick(View v) {

//        if (v==buttonNo) {
//            if (YesNo == "No") {
//                ScoreChange = 0;
//            } else {
//                if(YesNo == "Yes") {
//                    ScoreChange = -2;
//                } else {
//                    ScoreChange = -1;
//                }
//                buttonNo.setBackgroundColor(Color.RED);
//                buttonYes.setBackgroundColor(Color.LTGRAY);
//                YesNo = "No";
//            }
//        } else if (v==buttonYes){
//            if (YesNo == "Yes") {
//                ScoreChange = 0;
//            } else {
//                if(YesNo == "No") {
//                    ScoreChange = 2;
//                } else {
//                    ScoreChange = 1;
//                }
//                buttonNo.setBackgroundColor(Color.LTGRAY);
//                buttonYes.setBackgroundColor(Color.GREEN);
//                YesNo = "Yes";
//            }
//        }



        if (v==buttonNo) {
            ScoreChange = -1;
            buttonNo.setBackgroundColor(Color.RED);
            buttonYes.setBackgroundColor(Color.LTGRAY);
        } else if (v==buttonYes) {
            ScoreChange = 1;
            buttonNo.setBackgroundColor(Color.LTGRAY);
            buttonYes.setBackgroundColor(Color.GREEN);
        }

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference dataQuestions = database.getReference("questions");

        dataQuestions.orderByKey().addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Question Q = dataSnapshot.getValue(Question.class);
                if (thisID == Q.id) {
                    if (ScoreChange != 0) {
                        dataSnapshot.getRef().child("score").setValue(ScoreChange);
                    }
                }

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
