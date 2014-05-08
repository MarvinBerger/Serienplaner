package com.MB.fragments;

import java.util.ArrayList;
import java.util.List;

import com.MB.sp.R;
import com.MB.sp.Serie;
import com.MB.sp.SerienManager;

import android.app.AlertDialog;
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
	
	private Serie[] serien; 
	private View rootView;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
		rootView = inflater.inflate(R.layout.list_fragment, container,false);
		fillContent();
		return rootView;
	}
	
	private void fillContent(){
		SerienManager sm = SerienManager.getInstance(this.getActivity());
		serien = sm.getSeries();
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
		lv.setOnItemClickListener(this);
		lv.setAdapter(adapter);
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		View alertView = this.getActivity().getLayoutInflater().inflate(R.layout.list_alert, null);
		AlertDialog.Builder builder = new AlertDialog.Builder(this.getActivity());
		builder.setView(alertView);
		TextView textView = (TextView) alertView.findViewById(R.id.titleAlert);
		textView.setText(serien[arg2].getName());
		textView = (TextView) alertView.findViewById(R.id.channelAlert);
		textView.setText(serien[arg2].getChannel());
		AlertDialog dialog = builder.create();
		dialog.show();
	}
	
}
