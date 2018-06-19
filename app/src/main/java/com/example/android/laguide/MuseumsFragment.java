package com.example.android.laguide;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by masus on 2/24/2018.
 */

public class MuseumsFragment extends Fragment{

    public MuseumsFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attraction_list, container, false);

        final ArrayList<Attraction> museums = new ArrayList<Attraction>();

        museums.add(new Attraction(R.drawable.ca_science_center, getString(R.string.ca_sci_uri), getString(R.string.ca_sci_center), getString(R.string.ca_sci_center_desc)));
        museums.add(new Attraction(R.drawable.nhm, getString(R.string.nhm_uri), getString(R.string.nhm_la), getString(R.string.nhm_la_desc)));
        museums.add(new Attraction(R.drawable.lacma, getString(R.string.lacma_uri), getString(R.string.lacma), getString(R.string.lacma_desc)));
        museums.add(new Attraction(R.drawable.the_broad, getString(R.string.broad_uri), getString(R.string.the_broad), getString(R.string.the_broad_desc)));
        museums.add(new Attraction(R.drawable.griffith_observatory, getString(R.string.griffith_uri), getString(R.string.griffith), getString(R.string.griffith_desc)));

        AttractionAdapter attractionAdapter = new AttractionAdapter(getActivity(), museums);

        ListView listview = rootView.findViewById(R.id.list);

        listview.setAdapter(attractionAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                Uri geolocation = Uri.parse(museums.get(i).getLocationUriString());
                intent.setData(geolocation);
                if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        return rootView;
    }
}
