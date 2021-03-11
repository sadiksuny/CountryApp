package com.example.lab3.controller;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab3.R;
import com.example.lab3.model.Country;
import com.example.lab3.ui.countries.CountriesFragment;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    LayoutInflater inflater;
    ArrayList<Country> countries;

    public CustomAdapter(Context ctx, ArrayList<Country> countries){
        this.inflater= LayoutInflater.from(ctx);
        this.countries=countries;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= inflater.inflate(R.layout.custom_list_layout,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.countryName.setText(countries.get(position).getCountryName());
        holder.countryRegion.setText(countries.get(position).getCountryRegion());

    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    public class  ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView countryName, countryRegion;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            countryName = itemView.findViewById(R.id.countryName);
            countryRegion= itemView.findViewById(R.id.countryRegion);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            Country country = CountriesFragment.countryList.get(getLayoutPosition());
            Log.d("tag", "button clicked for "+ country.getCountryName());
            CountriesFragment.currCountry= country;
            Navigation.findNavController(v).navigate(R.id.action_navigation_countries_to_navigation_notifications);

        }
    }

}
