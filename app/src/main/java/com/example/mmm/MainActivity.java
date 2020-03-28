package com.example.mmm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mmm.databinding.DataBindingActivity;
import com.example.mmm.mvc.MVCActivity;
import com.example.mmm.mvp.MVPActivity;
import com.example.mmm.mvvm.MVVMActivity;
import com.example.mmm.normal.NormalActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button normalBtn, mvcBtn, mvpBtn, mvvmBtn,databindingBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        normalBtn = findViewById(R.id.btn_normal);
        mvcBtn = findViewById(R.id.btn_mvc);
        mvpBtn = findViewById(R.id.btn_mvp);
        mvvmBtn = findViewById(R.id.btn_mvvm);
        databindingBtn = findViewById(R.id.btn_databinding);

        normalBtn.setOnClickListener(this);
        mvcBtn.setOnClickListener(this);
        mvpBtn.setOnClickListener(this);
        mvvmBtn.setOnClickListener(this);
        databindingBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btn_normal:
                intent = new Intent(MainActivity.this, NormalActivity.class);
                break;
            case R.id.btn_mvc:
                intent = new Intent(MainActivity.this, MVCActivity.class);
                break;
            case R.id.btn_mvp:
                intent = new Intent(MainActivity.this, MVPActivity.class);
                break;
            case R.id.btn_mvvm:
                intent = new Intent(MainActivity.this, MVVMActivity.class);
                break;
            case R.id.btn_databinding:
                intent = new Intent(MainActivity.this, DataBindingActivity.class);
                break;
            default:
                intent = new Intent(MainActivity.this, NormalActivity.class);
                break;
        }
        startActivity(intent);
    }
}
