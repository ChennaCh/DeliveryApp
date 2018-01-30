package com.example.chinna.deliveryapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChickenFragment extends Fragment implements View.OnClickListener {
    Button b1,b2,b3;

    public ChickenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chicken, container, false);
        b1 = (Button)view.findViewById(R.id.chickenpizza);
        b2 = (Button)view.findViewById(R.id.coffe);
        b3 = (Button)view.findViewById(R.id.sandwitch);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);

        return view;
    }

    public void onClick(View view){
        if (view.getId() == R.id.chickenpizza){
//            Toast.makeText(getActivity(),"Clicked",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getActivity(),CustomlListActivity.class);
            startActivity(intent);
        }
    }

}
