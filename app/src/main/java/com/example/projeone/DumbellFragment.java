package com.example.projeone;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class DumbellFragment extends Fragment {

    private ImageButton IBtnFitness,IBtnYoga;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_dumbell, container, false);

        View v=inflater.inflate(R.layout.fragment_dumbell,container,false);

        IBtnFitness=v.findViewById(R.id.IBtnFitness);
        IBtnYoga=v.findViewById(R.id.IBtnYoga);


        IBtnFitness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(HomeFragment.this,PoseList.class);

                goToAttract(v,true);

            }
        });
        IBtnYoga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToAttract(v);
            }
        });




        return v;

    }
    public void goToAttract(View v)
    {
        Intent intent = new Intent(getActivity(), denemeeee.class);

        startActivity(intent);
    }
    public void goToAttract(View v,boolean b)
    {
        Intent intent = new Intent(getActivity(), DenemeeeT.class);

        startActivity(intent);
    }
}