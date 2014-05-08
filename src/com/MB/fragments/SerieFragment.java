package com.MB.fragments;

import com.MB.sp.R;
import com.MB.sp.Serie;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SerieFragment extends Fragment{
	
	private Serie serie;
	private View rootView;
	
	public SerieFragment(){
		
	}
	
	public void setSerie(Serie serie){
		this.serie = serie;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
		rootView = inflater.inflate(R.layout.serie_fragment, container,false);
		fillContent();
		return rootView;
	}
	
	private void fillContent(){
		
	}

}
