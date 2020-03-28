package com.example.mmm.databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mmm.R;
import com.example.mmm.bean.Account;

public class DataBindingActivity extends AppCompatActivity {
    ActivityDataBindingBinding binding;
    Account account;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         binding = DataBindingUtil.setContentView(DataBindingActivity.this, R.layout.activity_data_binding);

         account = new Account();
        account.setName("test");
        account.setLevel(100);
        binding.setAccount(account);
        binding.setActivity(this);
    }

    public void onclick(View v){
        Toast.makeText(DataBindingActivity.this, "account", Toast.LENGTH_SHORT);
        account.setLevel(account.getLevel()+1);
//        binding.setAccount(account);
    }
}
