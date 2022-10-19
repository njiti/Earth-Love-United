package com.elu.earthloveunited.ui.newprofile.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.elu.earthloveunited.R;
import com.elu.earthloveunited.databinding.FragmentNotificationBinding;

public class NotificationFragment extends Fragment {
    FragmentNotificationBinding binding;
    public NotificationFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding= FragmentNotificationBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.notificationNotNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction=requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.notificationFrameLayout,new ShareContactsFragment());
                transaction.addToBackStack("CONTACTS");
                transaction.commit();
            }
        });
    }
}