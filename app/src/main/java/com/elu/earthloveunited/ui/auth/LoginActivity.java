package com.elu.earthloveunited.ui.auth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.elu.earthloveunited.ui.Home;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.elu.earthloveunited.R;
import com.elu.earthloveunited.databinding.ActivityLoginBinding;
import com.elu.earthloveunited.databinding.ActivityRegisterBinding;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        firebaseAuth = FirebaseAuth.getInstance();

        binding.layLogin.signInButton.setOnClickListener(view -> {
            loginUser();
        });
    }

    private void loginUser() {
        String email = binding.layLogin.email.getText().toString().trim();
        String pass = binding.layLogin.password.getText().toString().trim();

        binding.loginLoader.setVisibility(View.VISIBLE);
        if (TextUtils.isEmpty(email)) {
            binding.layLogin.email.setError("Email cannot be empty");
            binding.layLogin.email.requestFocus();
        } else if (TextUtils.isEmpty(pass)) {
            binding.layLogin.password.setError("Password cannot be empty");
            binding.layLogin.password.requestFocus();
        } else {
            firebaseAuth.signInWithEmailAndPassword(email, pass)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            binding.loginLoader.setVisibility(View.GONE);
                            if (!task.isSuccessful()) {
                                if (pass.length() < 6) {
                                    binding.layLogin.password.setError("Ensure password is more than 6 characters!");
                                } else {
                                    Toast.makeText(LoginActivity.this, "Failed To Login", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                startActivity(new Intent(LoginActivity.this, GetPhoneNumber.class));
//                                LoginActivity.this.finish();
                            }
                        }
                    });
        }
    }
}