package com.tutwebhub.gurjas_portfolio.citytourguide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<CityTourView> cityTourViewList = new ArrayList<CityTourView>();
    private CityTourViewAdapter cityTourViewAdapter;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);

        cityTourViewAdapter = new CityTourViewAdapter(cityTourViewList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(cityTourViewAdapter);

        recyclerView.addOnItemTouchListener(
                new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        CityTourView cityTourView = cityTourViewList.get(position);
                        Toast.makeText(getApplicationContext(), cityTourView.getCityName() + " is selected", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }
                })
        );

        // use this function to add data into our list
        addRequiredData();
    }

    public void addRequiredData(){

        cityTourViewList.add(new CityTourView("Amritsar1", "Punjab"));
        cityTourViewList.add(new CityTourView("Amritsar2", "Punjab"));
        cityTourViewList.add(new CityTourView("Amritsar3", "Punjab"));
        cityTourViewList.add(new CityTourView("Amritsar4", "Punjab"));
        cityTourViewList.add(new CityTourView("Amritsar5", "Punjab"));
        cityTourViewList.add(new CityTourView("Amritsar6", "Punjab"));
        cityTourViewList.add(new CityTourView("Amritsar7", "Punjab"));
        cityTourViewList.add(new CityTourView("Amritsar8", "Punjab"));
        cityTourViewList.add(new CityTourView("Amritsar9", "Punjab"));
        cityTourViewList.add(new CityTourView("Amritsar10", "Punjab"));
        cityTourViewList.add(new CityTourView("Amritsar11", "Punjab"));

        // notify adapter so data changed
        cityTourViewAdapter.notifyDataSetChanged();
    }
}
