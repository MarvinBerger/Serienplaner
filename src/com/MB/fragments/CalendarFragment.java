package com.MB.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.MB.sp.R;

public class CalendarFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView  = (View) new CalendarView(this.getActivity().getApplicationContext());
		
		return rootView;
	}

}
