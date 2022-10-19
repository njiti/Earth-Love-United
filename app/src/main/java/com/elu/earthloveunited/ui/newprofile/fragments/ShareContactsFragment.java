package com.elu.earthloveunited.ui.newprofile.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.elu.earthloveunited.databinding.FragmentShareContactsBinding;
import com.elu.earthloveunited.ui.DisplayProfileActivity;

public class ShareContactsFragment extends Fragment {
    FragmentShareContactsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentShareContactsBinding.inflate(inflater, container, false);

        requireActivity().getOnBackPressedDispatcher().addCallback(getActivity(), new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.notNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DisplayProfileActivity.class);
                getActivity().startActivity(intent);
//                FragmentTransaction transaction=requireActivity().getSupportFragmentManager().beginTransaction();
//                transaction.replace(R.id.shareContactsFrameLayout,new DisplayProfileFragment());
//                transaction.commit();

            }
        });
    }

}