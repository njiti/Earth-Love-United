package com.elu.earthloveunited.ui.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.elu.earthloveunited.R;
import com.elu.earthloveunited.databinding.ActivityLaunchBinding;

public class LaunchActivity extends AppCompatActivity {

    ActivityLaunchBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLaunchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.signUp.setOnClickListener(view->{
            startActivity(new Intent(LaunchActivity.this, RegisterActivity.class));

        });

        binding.logIn.setOnClickListener(view->{
            startActivity(new Intent(LaunchActivity.this, LoginActivity.class));
        });

    }
}