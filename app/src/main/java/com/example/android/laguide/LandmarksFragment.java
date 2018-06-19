package com.example.android.laguide;

import android.app.LauncherActivity;
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

public class LandmarksFragment extends Fragment {

    public LandmarksFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attraction_list, container, false);

        final ArrayList<Attraction> landmarks = new ArrayList<Attraction>();

        landmarks.add(new Attraction(R.drawable.wdhc, getString(R.string.wdch_uri), getString(R.string.wdch), getString(R.string.wdch_desc)));
        landmarks.add(new Attraction(R.drawable.the_bowl, getString(R.string.the_bowl_uri), getString(R.string.the_bowl), getString(R.string.the_bowl_desc)));
        landmarks.add(new Attraction(R.drawable.bradbury, getString(R.string.bradbury_uri), getString(R.string.bradbury), getString(R.string.bradbury_desc)));
        landmarks.add(new Attraction(R.drawable.union_station, getString(R.string.union_station_uri), getString(R.string.union_station), getString(R.string.union_station_desc)));

        AttractionAdapter attractionAdapter = new AttractionAdapter(getActivity(), landmarks);

        ListView listView = rootView.findViewById(R.id.list);

        listView.setAdapter(attractionAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                Uri geolocation = Uri.parse(landmarks.get(i).getLocationUriString());
                intent.setData(geolocation);
                if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        return rootView;
    }
}
