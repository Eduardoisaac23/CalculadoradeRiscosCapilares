package com.softwaresa.salaomais.Activity;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softwaresa.salaomais.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class SexoFragment extends Fragment {


    public SexoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sexo, container, false);
    }

}
