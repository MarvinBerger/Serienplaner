package com.MB.fragments;

import java.util.ArrayList;
import java.util.List;

import com.MB.sp.R;
import com.MB.sp.Serie;
import com.MB.sp.SerienManager;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListFragment extends Fragment implements OnItemClickListener{
	
	public View rootView;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
		rootView = inflater.inflate(R.layout.list_fragment, container,false);
		fillContent();
		return rootView;
	}
	
	private void fillContent(){
		SerienManager sm = SerienManager.getInstance(this.getActivity());
		Serie[] serien = sm.getSeries();
		List<String> list = new ArrayList<String>();
		for(int i=0;i<serien.length;i++)
			list.add(serien[i].getName());
		ListAdapter adapter = new ArrayAdapter<String>(this.getActivity().getApplicationContext(), android.R.layout.simple_list_item_1, list) {
		    @Override
		    public View getView(int position, View convertView, ViewGroup parent) {
		        TextView textView = (TextView) super.getView(position, convertView, parent);
		        textView.setTextColor(Color.BLACK);
		        return textView;
		    }
		};
		ListView lv = (ListView)rootView.findViewById(R.id.listView1);
		//lv.s;
		lv.setAdapter(adapter);
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		
	}
	
}
