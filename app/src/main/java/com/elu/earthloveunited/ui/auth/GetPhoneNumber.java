package com.elu.earthloveunited.ui.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.elu.earthloveunited.R;
import com.elu.earthloveunited.databinding.ActivityGetPhoneNumberBinding;

public class GetPhoneNumber extends AppCompatActivity {

    ActivityGetPhoneNumberBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGetPhoneNumberBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.ccp.registerCarrierNumberEditText(binding.phonenumber);

        binding.button2.setOnClickListener(view -> {
            if(valid()){
                String code = binding.ccp.getFullNumber();
                String phone =  binding.phonenumber.getText().toString().trim();
                String num = "+"+code;

//                userProfile.setPhone(num);
                Intent intent1 = new Intent(GetPhoneNumber.this, OTPVerification.class);
                intent1.putExtra("PHONE", num);

                startActivity(intent1);
            }
        });
    }
    private boolean valid() {

        String phonenumber = binding.phonenumber.getText().toString().trim();

        if(phonenumber.isEmpty()){
            binding.phonenumber.setError("please Input a phone number");
            return false;
        }else if(!phonenumber.matches("[0-9]+")){
            binding.phonenumber.setError("please Input a valid number");
            return false;
        }else if(!(phonenumber.length() == 9)){
            binding.phonenumber.setError("please Input a correct length");
            return false;
        }else {
            binding.phonenumber.setError(null);
            return true;
        }
    }
}