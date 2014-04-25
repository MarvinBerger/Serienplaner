package com.MB.fragments;

import com.MB.sp.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
 
public class HomeFragment extends Fragment {
     
    public HomeFragment(){}
     
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
  
        View rootView = inflater.inflate(R.layout.home_fragment, container, false);
        fillContent();
        return rootView;
    }
    private void fillContent()
    {
    	
    }
}