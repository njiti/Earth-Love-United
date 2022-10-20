package com.elu.earthloveunited.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.elu.earthloveunited.R;
import com.elu.earthloveunited.databinding.ActivityDisplayProfileBinding;
import com.elu.earthloveunited.ui.newprofile.fragments.EditFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DisplayProfileActivity extends AppCompatActivity {
    ActivityDisplayProfileBinding binding;
    private SharedPreferences mSharedPreferences;
    List<String> interestsLists;
    List<String> clubsLists;
    List<Integer> postsLists;
    RecyclerView interestsRecycler;
    RecyclerView clubsRecycler;
    RecyclerView postsRecycler;
//    Gson gson;
//    profile userProfile;
//    blackListAdapter interestsAdapter;
//    blackListAdapter clubsAdapter;
//    photoPostAdapter postsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDisplayProfileBinding.inflate(getLayoutInflater());
//        gson=new Gson();
//        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
//        String userDetails=mSharedPreferences.getString("userDetails","");
//        userProfile=gson.fromJson(userDetails,profile.class);
//        Log.d("userName",userProfile.getName());
//        System.out.println(userProfile.getName());
//        binding.newName.setText(userProfile.getName());
//        binding.profileAge.setText(userProfile.getBirthday());
//        binding.userStory.setText(userProfile.getStory());
//        binding.userImage.setImageURI(userProfile.getImageUri());

        binding.editIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(DisplayProfileActivity.this, editActivity.class);
//                startActivity(intent);
            }
        });
        interestsRecycler=binding.interestsRecycler;
        clubsRecycler=binding.groupsRecycler;
        postsRecycler=binding.photosRecycler;

//        clubsLists=new ArrayList<String>(Arrays.asList("Environment","Severe Weather","Deforestation","Polar Landscape","Water Levels","Forest Fire","Deforestation"));
//        clubsAdapter=new blackListAdapter(this,clubsLists);
//        clubsRecycler.setAdapter( clubsAdapter);
//        clubsRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
//
//
//        postsLists=new ArrayList<Integer>(Arrays.asList(R.drawable.nature1,R.drawable.nature2,R.drawable.nature3,R.drawable.nature4,R.drawable.nature5,R.drawable.nature1,R.drawable.nature2));
//        postsAdapter=new photoPostAdapter(this,postsLists);
//        postsRecycler.setAdapter( postsAdapter);
//        postsRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
//
//        interestsLists=new ArrayList<String>(Arrays.asList("Severe Weather","Deforestation","Environment","Polar Landscape","Forest Fire","Deforestation","Water Levels"));
//        interestsAdapter=new blackListAdapter(this,interestsLists);
//        interestsRecycler.setAdapter( interestsAdapter);
//        interestsRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
//        binding.followersLayout3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                AppCompatActivity activity=(AppCompatActivity)view.getContext();
//                EditFragment EditFragment =new EditFragment();
//                activity.getSupportFragmentManager().beginTransaction().replace(R.id.scrollView2, EditFragment).addToBackStack(null).commit();
//            }
//        });
//        binding.followingLayout4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                AppCompatActivity activity=(AppCompatActivity)view.getContext();
//                editClubsFragment editClubsFragment =new editClubsFragment();
//                activity.getSupportFragmentManager().beginTransaction().replace(R.id.scrollView2, editClubsFragment).addToBackStack(null).commit();
//            }
//        });
        binding.savedLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(DisplayProfileActivity.this, PostsActivity.class);
//                startActivity(intent);
            }
        });
        setContentView(binding.getRoot());
    }


}