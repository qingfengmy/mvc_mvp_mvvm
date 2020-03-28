package com.example.mmm.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.mmm.R;
import com.example.mmm.databinding.ActivityMvvmBinding;
import com.example.mmm.databinding.DataBindingActivity;

public class MVVMActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvvm);
        ActivityMvvmBinding binding = DataBindingUtil.setContentView(MVVMActivity.this, R.layout.activity_mvvm);
        binding.setViewmodel(new MVVMViewModel(getApplication()));
    }
}
