package com.elu.earthloveunited.ui.auth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.elu.earthloveunited.R;
import com.elu.earthloveunited.ui.posts.Home;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class OTPVerification extends AppCompatActivity {

    private String verificationId;
    private PhoneAuthProvider.ForceResendingToken mResendToken;
    private FirebaseAuth mAuth;
//    private ProgressBar confirmLoader;
//    private PinView editText;

    ActivityOtpverificationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpverification);
        binding = ActivityOtpverificationBinding.inflate(getLayoutInflater());
        mAuth = FirebaseAuth.getInstance();


        Bundle extras = getIntent().getExtras();
        String valuePhone = extras.getString("PHONE");
        Toast.makeText(OTPVerification.this, valuePhone, Toast.LENGTH_LONG).show();
        Log.i("PHONENUM", valuePhone);

        sendVerificationCode(valuePhone);

        binding.otpCodeNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String code = binding.pinView.getText().toString().trim();

                if (code.isEmpty() || code.length() < 6) {

                    binding.pinView.setError("Enter code...");
                    binding.pinView.requestFocus();
                    return;
                }
                verifyCode(code);
            }
        });

    }

//    Here we now authenticate using the actual OTP number that the user has entered

    private void signInWithCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            Toast.makeText(OTPVerification.this, task.toString(), Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(OTPVerification.this, Home.class);
//                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);

                        } else {
                            Toast.makeText(OTPVerification.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

//    Here we sen the verification code/ message that contains the verification code

    private void sendVerificationCode(String valuePhone) {
        binding.confirmLoader.setVisibility(View.VISIBLE);
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber(valuePhone)            // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // Activity (for callback binding)
                        .setCallbacks(mCallBack)           // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);

    }

    private final PhoneAuthProvider.OnVerificationStateChangedCallbacks
            mCallBack = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        @Override
        public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            verificationId = s;
//            mResendToken = forceResendingToken;
        }

        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
            String code = phoneAuthCredential.getSmsCode();
            binding.pinView.setText(code);
            verifyCode(code);
            Log.d("VERIF", "onVerificationCompleted:" + phoneAuthCredential);

            signInWithCredential(phoneAuthCredential);
        }

        @Override
        public void onVerificationFailed(FirebaseException e) {
            Toast.makeText(OTPVerification.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    };

    private void verifyCode(String code) {

        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, code);
        signInWithCredential(credential);
    }
}