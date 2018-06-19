package com.example.android.laguide;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by masus on 3/6/2018.
 */

public class AttractionAdapter extends ArrayAdapter<Attraction> {

    public AttractionAdapter(Activity context, ArrayList<Attraction> attractions) {
        super(context, 0, attractions);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Attraction currentAttraction = getItem(position);

        ImageView attractionImage = listItemView.findViewById(R.id.attraction_image);
        if(currentAttraction.hasImage()) {
            attractionImage.setImageResource(currentAttraction.getImageResId());
            attractionImage.setVisibility(View.VISIBLE);
        } else {
            attractionImage.setVisibility(View.GONE);
        }

        TextView attractionName = listItemView.findViewById(R.id.attraction_name_text);
        attractionName.setText(currentAttraction.getName());

        TextView attractionDescription = listItemView.findViewById(R.id.attraction_description_text);
        attractionDescription.setText(currentAttraction.getDescription());

        return listItemView;
    }
}
