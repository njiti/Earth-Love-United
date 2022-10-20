package com.elu.earthloveunited.ui.auth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.elu.earthloveunited.R;
import com.elu.earthloveunited.databinding.ActivityLaunchBinding;
import com.elu.earthloveunited.databinding.ActivityRegisterBinding;
import com.elu.earthloveunited.ui.posts.Home;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    ActivityRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        firebaseAuth = FirebaseAuth.getInstance();

        binding.buttonSignUp.setOnClickListener(view -> {
            registerUser();
        });

        binding.loginRedirect.setOnClickListener(view -> {
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
        });
    }

    private void registerUser() {
        String password = binding.layRegister.password.getText().toString().trim();
        String email = binding.layRegister.Email.getText().toString().trim();
        String name = binding.layRegister.Name.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            binding.layRegister.Email.setError("Email cannot be empty");
            binding.layRegister.Email.requestFocus();
        } else if (TextUtils.isEmpty(password)) {
            binding.layRegister.password.setError("Password cannot be empty");
            binding.layRegister.password.requestFocus();
        } else if (TextUtils.isEmpty(name)) {
            binding.layRegister.Name.setError("Name cannot be empty");
            binding.layRegister.Name.requestFocus();
        } else {
            firebaseAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                FirebaseUser user = firebaseAuth.getCurrentUser();
                                String email = user.getEmail();
                                String uid = user.getUid();
                                HashMap<Object, String> hashMap = new HashMap<>();
                                hashMap.put("email", email);
                                hashMap.put("uid", uid);
                                hashMap.put("name", name);

                                FirebaseDatabase database = FirebaseDatabase.getInstance();
                                DatabaseReference reference = database.getReference("Users");
                                reference.child(uid).setValue(hashMap);
                                Toast.makeText(RegisterActivity.this, "Registered User " + user.getEmail(), Toast.LENGTH_LONG).show();
                                Intent mainIntent = new Intent(RegisterActivity.this, Home.class);
                                mainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(mainIntent);
                                finish();
                            } else {
                                Toast.makeText(RegisterActivity.this, "Error", Toast.LENGTH_LONG).show();
                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(RegisterActivity.this, "Error Occurred", Toast.LENGTH_LONG).show();
                }
            });
        }


    }
}