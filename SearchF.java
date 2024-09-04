package com.example.ayush_vg;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;


public class SearchF extends Fragment {
ArrayList<showd> datacontainer = new ArrayList<showd>();
RecyclerView recyclerView;
SearchView searchView;
;

    public SearchF() {
        // Required empty public constructor
    }

    public static SearchF newInstance(String param1, String param2) {
        SearchF fragment = new SearchF();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        recyclerView =view.findViewById(R.id.rv_search);
        searchView = view.findViewById(R.id.searchView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        datacontainer.add(new showd("xyz","kkkk","hi",R.drawable.leaf));
        datacontainer.add(new showd("xxx","vvv","fndnjkj",R.drawable.growth));
        datacontainer.add(new showd("xy","lk","gk",R.drawable.leaf1));


        adapter adapt = new adapter(getContext(), datacontainer);
        recyclerView.setAdapter(adapt);
        return view;
    }
    static class showd{
        String name;
        String species;
        String uses;
        int img;
        public showd(String name, String species, String uses, int img) {
            this.name = name;
            this.species = species;
            this.uses = uses;
            this.img = img;
    }}
    public void filterList(String text){
        ArrayList<showd> filteredList = new ArrayList<>();
        for(showd item : datacontainer){
            if (item.name.toLowerCase().contains(text.toLowerCase()) ||
                    item.species.toLowerCase().contains(text.toLowerCase()) ||
                    item.uses.toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
            if(filteredList.isEmpty()){
                Toast.makeText(getContext(),"No Data Found",Toast.LENGTH_SHORT).show();
            } else {
                adapter adapt = new adapter(getContext(), filteredList);
                recyclerView.setAdapter(adapt);
            }

        }
    }
}
