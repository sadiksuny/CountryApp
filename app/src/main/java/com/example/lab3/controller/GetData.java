package com.example.lab3.controller;

import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.example.lab3.model.Country;
import com.example.lab3.ui.countries.CountriesFragment;
import com.example.lab3.ui.countries.CountriesViewModel;

import java.util.ArrayList;

public class GetData {
    private final String TAG= "Test";
    private static String JSON="https://restcountries.eu/rest/v1/all";
    private CountriesViewModel countriesViewModel;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RequestQueue queue;
    public static ArrayList<Country> countryList= new ArrayList<Country>();

    public GetData(RecyclerView recyclerView, RecyclerView.Adapter adapter, RequestQueue queue, CountriesFragment countriesFragment){

    }

}
