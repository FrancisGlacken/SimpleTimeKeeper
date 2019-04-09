package com.deltorostudios.punchclockmockup2.Fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.deltorostudios.punchclockmockup2.AdaptersViewHolders.CategoryAdapter;
import com.deltorostudios.punchclockmockup2.AdaptersViewHolders.TimeEntryCardAdapter;
import com.deltorostudios.punchclockmockup2.Database.Category;
import com.deltorostudios.punchclockmockup2.ViewModels.HomeViewModel;
import com.deltorostudios.punchclockmockup2.R;

import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;


    public HomeFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_home, container, false);
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);

        final Button addButton = view.findViewById(R.id.addButton);
        final RecyclerView cardRecyclerView = view.findViewById(R.id.mainRecyclerView);
        final RecyclerView timeEntryRecyclerView = view.findViewById(R.id.mainRecyclerView);
        cardRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
//        timeEntryRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        final CategoryAdapter catAdapter = new CategoryAdapter();
        cardRecyclerView.setAdapter(catAdapter);

//        final TimeEntryCardAdapter timeAdapter = new TimeEntryCardAdapter();
//        timeEntryRecyclerView.setAdapter(timeAdapter);

        homeViewModel.getAllCategories().observe(this, new Observer<List<Category>>() {
            @Override
            public void onChanged(@Nullable List<Category> categories) {
                catAdapter.setCategories(categories);
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Category newCategory = new Category("No Name Boi", 0);
                homeViewModel.insertCategory(newCategory);
            }
        });

        return view;
    }
}
