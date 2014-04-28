package com.MB.fragments;

import java.util.Calendar;

import com.MB.sp.DateHelper;
import com.MB.sp.R;
import com.MB.sp.Serie;
import com.MB.sp.SerienManager;
import com.MB.sp.StartActivity;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class HomeFragment extends Fragment implements OnClickListener {

	public HomeFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.home_fragment, container,
				false);
		fillContent();
		return rootView;
	}

	private void showNoSeriesScreen() {
		LinearLayout ll = (LinearLayout) this.getActivity().findViewById(
				R.id.content);
		View serienView = LayoutInflater.from(this.getActivity()).inflate(
				R.layout.no_content, null);
		serienView.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				Toast.makeText(HomeFragment.this.getActivity(), HomeFragment.this.getResources().getString(R.string.toast_no_content), Toast.LENGTH_LONG).show();
			}
			
			
		});
		ll.addView(serienView);
		
	}

	private void fillContent() {
		// Serien bekommen
		SerienManager sm = SerienManager.getInstance(this.getActivity());
		Serie[] serien = sm.getSeries();
		serien = DateHelper.sortByDate(serien);
		Calendar c = Calendar.getInstance();
		// Root View initialisieren
		LinearLayout ll = (LinearLayout) this.getActivity().findViewById(
				R.id.content);
		if (serien.length == 0) {
			showNoSeriesScreen();
			return;
		}
		int lastDay = -1;
		for (Serie s : serien) {
			c.setTime(s.getNextDate());
			if (c.get(Calendar.DAY_OF_WEEK) != lastDay) {
				View v = LayoutInflater.from(this.getActivity()).inflate(
						R.layout.list_day, null);
				TextView tv = (TextView) v.findViewById(R.id.name);
				tv.setText(DateHelper.tage[c.get(Calendar.DAY_OF_WEEK)]);
				ll.addView(v);
			}
			View serienView = LayoutInflater.from(this.getActivity()).inflate(
					R.layout.serie, null);
			((TextView) serienView.findViewById(R.id.name))
					.setText(s.getName());
			((TextView) serienView.findViewById(R.id.zeit)).setText(c
					.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE));
			((TextView) serienView.findViewById(R.id.infos)).setText(s
					.getChannel()
					+ "   "
					+ s.getCountry()
					+ "   "
					+ this.getActivity().getResources()
							.getString(R.string.season) + ":" + s.getSeason());
			serienView.setId(s.getID());
			ll.addView(serienView);

		}

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Toast.makeText(this.getActivity(), SerienManager.getInstance(this.getActivity()).getSerie(v.getId()).getName(),Toast.LENGTH_LONG).show();
		
	}
}