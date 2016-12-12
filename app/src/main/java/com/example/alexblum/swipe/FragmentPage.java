package com.example.alexblum.swipe;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentPage extends android.support.v4.app.Fragment {
    TextView textView;

    public FragmentPage() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_page,container, false);
        textView = (TextView)view.findViewById(R.id.textView);
        textView.setMovementMethod(new ScrollingMovementMethod());

        Bundle bundle = getArguments();
        String message = Integer.toString(bundle.getInt("count"));
        String question = bundle.getString("question");
        textView.setText("This is the "+message+". Question.\n"+"This is the "+message+". Question.\n"+"This is the "+message+". Question.\n"+"This is the "+message+". Question.\n"+"This is the "+message+". Question.\n"+"This is the "+message+". Question.\n"+"This is the "+message+". Question.\n"+"This is the "+message+". Question.\n"+"This is the "+message+". Question.\n"+"This is the "+message+". Question.\n"+"This is the "+message+". Question.\n"+"This is the "+message+". Question.\n"+"This is the "+message+". Question.\n"+"This is the "+message+". Question.\n"+question);

        return view;
    }

}
