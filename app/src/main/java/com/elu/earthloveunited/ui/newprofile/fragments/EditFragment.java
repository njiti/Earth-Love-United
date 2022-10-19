package com.elu.earthloveunited.ui.newprofile.fragments;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.elu.earthloveunited.databinding.FragmentEditBinding;

import java.util.List;

public class EditFragment extends Fragment {
    FragmentEditBinding binding;
    RecyclerView interestsRecycler;
    RecyclerView clubsRecycler;
    List<String> interestsLists;
    List<String> clubsLists;
//    blackListAdapter interestsAdapter;
//    blackListAdapter clubsAdapter;
//    Uri sendUri;
//    Gson gson;
//    profile userProfile;
//    private SharedPreferences mSharedPreferences;
//    public EditFragment() {
//        // Required empty public constructor
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        binding=FragmentEditBinding.inflate(getLayoutInflater());
//        gson=new Gson();
//        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
//        String userDetails=mSharedPreferences.getString("userDetails","");
//        userProfile=gson.fromJson(userDetails,profile.class);
//        Log.d("userName",userProfile.getName());
//        System.out.println(userProfile.getName());
//        binding.BirthdayEditText.setText(userProfile.getBirthday());
//        binding.locationEditText.setText(userProfile.getLocation());
//        binding.MyStoryEditText.setText(userProfile.getStory());
//        binding.nameEditText.setText(userProfile.getName());
//        binding.pronounsEditText.setText(userProfile.getPronoun());
//        binding.WebsiteEditText.setText(userProfile.getWebsite());
//        interestsRecycler=binding.interestsRecycler;
//        clubsRecycler=binding.groupsRecycler;
//
//        clubsLists=new ArrayList<String>(Arrays.asList("Environment","Severe Weather","Deforestation","Polar Landscape","Water Levels","Forest Fire","Deforestation"));
//        clubsAdapter=new blackListAdapter(getContext(),clubsLists);
//        clubsRecycler.setAdapter( clubsAdapter);
//        clubsRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
//
//        interestsLists=new ArrayList<String>(Arrays.asList("Severe Weather","Deforestation","Environment","Polar Landscape","Forest Fire","Deforestation","Water Levels"));
//        interestsAdapter=new blackListAdapter(getContext(),interestsLists);
//        interestsRecycler.setAdapter( interestsAdapter);
//        interestsRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
//        binding.editGroups.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//                FragmentTransaction transaction=requireActivity().getSupportFragmentManager().beginTransaction();
//                transaction.replace(R.id.editFrameLayout,new EditInterestFragment());
//                transaction.addToBackStack("editINTERESTS");
//                transaction.commit();
//            }
//        });
//        binding.textInterestEdit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                FragmentTransaction transaction=requireActivity().getSupportFragmentManager().beginTransaction();
//                transaction.replace(R.id.editFrameLayout,new editClubsFragment());
//                transaction.addToBackStack("editClubs");
//                transaction.commit();
//            }
//        });
//
//        binding.addButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ImagePicker.with(getActivity()).compress(1024).maxResultSize(1080,1080).createIntent(intent->{startForProfileImageResult.launch(intent);
//                    return Unit.INSTANCE;});
//            }
//        });
//        return binding.getRoot();}
//    private ActivityResultLauncher startForProfileImageResult=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
//            new ActivityResultCallback<ActivityResult>() {
//                @Override
//                public void onActivityResult(ActivityResult result) {
//                    if (result.getResultCode() == Activity.RESULT_OK) {
//                        // There are no request codes
//                        Intent data = result.getData();
//                        Uri uri=data.getData();
//                        sendUri=uri;
//                        binding.profilePhoto.setImageURI( uri);
//                    }
//                }
//            });
}