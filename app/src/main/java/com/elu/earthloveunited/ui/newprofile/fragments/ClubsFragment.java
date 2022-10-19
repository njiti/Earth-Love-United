package com.elu.earthloveunited.ui.newprofile.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.elu.earthloveunited.MainActivity;
import com.elu.earthloveunited.databinding.FragmentClubsBinding;
import com.elu.earthloveunited.ui.newprofile.adapters.clubsAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClubsFragment extends Fragment {
    FragmentClubsBinding clubsBinding;
    RecyclerView dataList;
    com.elu.earthloveunited.ui.newprofile.adapters.clubsAdapter clubsAdapter;
    List<String> clubLabels;

    public ClubsFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        clubsBinding=  FragmentClubsBinding.inflate(inflater, container, false);

        requireActivity().getOnBackPressedDispatcher().addCallback(getActivity(), new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                requireActivity().getSupportFragmentManager().popBackStack();
            }
        });
        return clubsBinding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        clubLabels=new ArrayList<String>(Arrays.asList("#Environment","#Severe Weather","#Deforestation","#Polar Landscape","#Water Levels","#Forest Fire","#Deforestation","#Polar Landscape"));
        clubsAdapter=new clubsAdapter(getContext(),clubLabels);

        GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(),1,GridLayoutManager.VERTICAL,false);
        dataList= clubsBinding.clubsRecycler;
        dataList.setLayoutManager(gridLayoutManager);
        dataList.setAdapter( clubsAdapter);
        Log.d("before click","not yet clicked");
        clubsBinding.clubNotNow.setOnClickListener(view1 -> {
            startActivity(new Intent(getActivity(), MainActivity.class));
            Toast.makeText(getActivity(),"NotNow",Toast.LENGTH_LONG).show();
        });
        clubsBinding.clubNext.setOnClickListener(view1 ->{
            startActivity(new Intent(getActivity(),MainActivity.class));
            Toast.makeText(getActivity(),"Next",Toast.LENGTH_LONG).show();

        });

    }

}