package com.tutwebhub.gurjas_portfolio.citytourguide;

import android.content.Context;
import android.graphics.Movie;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by gurjas on 30-06-2017.
 */

public class CityTourViewAdapter extends RecyclerView.Adapter<CityTourViewAdapter.CityTourViewHolder> {

    private List<CityTourView> cityTourViewList;

    /*
    * create public class for CityTourViewHolder because we have to bind view
    * for more explanation, check the documentation for list view
    * vs recycler view and understand the use of ViewHolder.
     */
    public class CityTourViewHolder extends RecyclerView.ViewHolder{
        TextView cityName;
        TextView locationName;
        public CityTourViewHolder(View view)
        {
            super(view);
            cityName = (TextView)view.findViewById(R.id.city_name);
            locationName = (TextView)view.findViewById(R.id.lcoation);
        }
    }

    public CityTourViewAdapter(List<CityTourView> cityTourViewList){
        this.cityTourViewList = cityTourViewList;
    }

    @Override
    public CityTourViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.city_list_view, parent, false);

        return new CityTourViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CityTourViewHolder holder, int position) {
        CityTourView cityTourView = cityTourViewList.get(position);
        holder.cityName.setText(cityTourView.getCityName());
        holder.locationName.setText(cityTourView.getLocationName());
    }

    @Override
    public int getItemCount() {
        return cityTourViewList.size();
    }
}
