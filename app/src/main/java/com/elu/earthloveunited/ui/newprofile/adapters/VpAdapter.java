package com.elu.earthloveunited.ui.newprofile.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.elu.earthloveunited.ui.newprofile.fragments.profileInfoFragment;

public class VpAdapter extends FragmentStateAdapter {
    public VpAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return new profileInfoFragment();
    }

    @Override
    public int getItemCount() {
        return 1;
    }
}
