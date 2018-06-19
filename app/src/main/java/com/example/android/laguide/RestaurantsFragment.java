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

public class RestaurantsFragment extends Fragment {

    public RestaurantsFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attraction_list, container, false);

        final ArrayList<Attraction> food = new ArrayList<Attraction>();

        food.add(new Attraction(getString(R.string.blu_jam_uri), getString(R.string.blu_jam), getString(R.string.blu_jam_desc)));
        food.add(new Attraction(getString(R.string.four_daughters_uri), getString(R.string.four_daughters), getString(R.string.four_daughters_desc)));
        food.add(new Attraction(getString(R.string.salts_cure_uri), getString(R.string.salts_cure), getString(R.string.salts_cure_desc)));
        food.add(new Attraction(getString(R.string.sqirl_uri), getString(R.string.sqirl), getString(R.string.sqirl_desc)));
        food.add(new Attraction(getString(R.string.nicks_uri), getString(R.string.nicks), getString(R.string.nicks_desc)));

        AttractionAdapter attractionAdapter = new AttractionAdapter(getActivity(), food);

        ListView listView = rootView.findViewById(R.id.list);

        listView.setAdapter(attractionAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                Uri geolocation = Uri.parse(food.get(i).getLocationUriString());
                intent.setData(geolocation);
                if(intent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        return rootView;
    }
}
