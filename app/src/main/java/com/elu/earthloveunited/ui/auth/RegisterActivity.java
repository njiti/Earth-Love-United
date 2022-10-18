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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

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
    }

    private void registerUser() {
        String password = binding.layRegister.password.getText().toString().trim();
        String email  = binding.layRegister.Email.getText().toString().trim();
        String name  = binding.layRegister.Name.getText().toString().trim();

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
                    .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            Log.d("TAG", "New user registration: " + task.isSuccessful());

                            if (!task.isSuccessful()) {
                                Toast.makeText(RegisterActivity.this, "Failed To Register User", Toast.LENGTH_SHORT).show();
                            } else {
                                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
//                                RegisterActivity.this.finish();
                            }
                        }
                    });
        }


    }
}