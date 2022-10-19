package com.elu.earthloveunited.ui.newprofile.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.elu.earthloveunited.R;
import com.elu.earthloveunited.databinding.FragmentInterestsBinding;
import com.elu.earthloveunited.ui.newprofile.adapters.InterestsRecyclerviewAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InterestsFragment extends Fragment {
    FragmentInterestsBinding binding;
    String sendUri;
    List<String> interestLabels;
    List<Integer>images;
    RecyclerView dataList;

    InterestsRecyclerviewAdapter interestsRecyclerviewAdapter;
    public InterestsFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentInterestsBinding.inflate(inflater, container, false);

        Fragment profileFragment = getActivity().getSupportFragmentManager().findFragmentById(R.id.ProfileInfoFragment);
        requireActivity().getOnBackPressedDispatcher().addCallback(getActivity(), new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                requireActivity().getSupportFragmentManager().popBackStack();
            }
        });
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        interestLabels=new ArrayList<String>(Arrays.asList("Environment","Severe Weather","Deforestation","Polar Landscape","Water Levels","Forest Fire","Deforestation","Polar Landscape"));
        images=new ArrayList<Integer>(Arrays.asList(R.drawable.nature1,R.drawable.nature2,R.drawable.nature3,R.drawable.nature4,R.drawable.nature5,R.drawable.nature1,R.drawable.nature2,R.drawable.nature3,R.drawable.nature4,R.drawable.nature5));
        interestsRecyclerviewAdapter=new InterestsRecyclerviewAdapter(getContext(),images,interestLabels);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(),2,GridLayoutManager.VERTICAL,false);
        dataList= binding.interestRecyclerView;
        dataList.setLayoutManager(gridLayoutManager);
        dataList.setAdapter(interestsRecyclerviewAdapter);
        binding.notNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction=requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.interestFrameLayout,new ClubsFragment());
                transaction.addToBackStack("CLUBS");
                transaction.commit();

            }
        });
        binding.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction=requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.interestFrameLayout,new ClubsFragment());
                transaction.addToBackStack("CLUBS");
                transaction.commit();

            }
        });

    }

}