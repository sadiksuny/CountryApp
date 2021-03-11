package com.example.lab3.ui.countries;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.lab3.R;
import com.example.lab3.controller.CustomAdapter;
import com.example.lab3.model.Country;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CountriesFragment extends Fragment {


    private CountriesViewModel countriesViewModel;

    private RecyclerView recyclerView;
    public CustomAdapter adapter;
    //private RequestQueue queue;
    public static ArrayList<Country> countryList= new ArrayList<Country>();
    public static Country currCountry;
    private static String JSON="https://restcountries.eu/rest/v1/all";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        countriesViewModel =
                new ViewModelProvider(this).get(CountriesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        recyclerView= root.findViewById(R.id.countriesList);

        extractCountries();
        currCountry= new Country();
        //final TextView textView = root.findViewById(R.id.text_dashboard);



        countriesViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);
            }
        });
        return root;
    }

    private void extractCountries() {
        RequestQueue queue = Volley.newRequestQueue(getContext());
        JsonArrayRequest jsonArrayRequest= new JsonArrayRequest(Request.Method.GET, JSON, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject countryObject = response.getJSONObject(i);

                        Country country = new Country();
                        country.setCountryName(countryObject.getString("name").toString());
                        country.setCountryRegion(countryObject.getString("region").toString());
                        country.setCountryPopulation(countryObject.getInt("population"));
                        countryList.add(country);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                adapter= new CustomAdapter(getContext(), countryList);
                recyclerView.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("tag", "onErrorResponse: ");
            }
        });
        queue.add(jsonArrayRequest);

    }


}