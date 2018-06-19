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

public class ParksFragment extends Fragment {

    public ParksFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attraction_list, container, false);

        final ArrayList<Attraction> parks = new ArrayList<Attraction>();

        parks.add(new Attraction(getString(R.string.kenneth_hahn_uri), getString(R.string.kenneth_hahn), getString(R.string.kenneth_hahn_desc)));
        parks.add(new Attraction(getString(R.string.el_dorado_uri), getString(R.string.el_dorado), getString(R.string.el_dorado_desc)));
        parks.add(new Attraction(getString(R.string.la_state_park_uri), getString(R.string.la_state_park), getString(R.string.la_state_park_desc)));
        parks.add(new Attraction(getString(R.string.grand_park_uri), getString(R.string.grand_park), getString(R.string.grand_park_desc)));
        parks.add(new Attraction(getString(R.string.echo_park_uri), getString(R.string.echo_park), getString(R.string.echo_park_desc)));

        AttractionAdapter attractionAdapter = new AttractionAdapter(getActivity(), parks);

        ListView listView = rootView.findViewById(R.id.list);

        listView.setAdapter(attractionAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                Uri geolocation = Uri.parse(parks.get(i).getLocationUriString());
                intent.setData(geolocation);
                if(intent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        return rootView;
    }
}
