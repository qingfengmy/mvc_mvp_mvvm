package com.example.mmm.bean;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.mmm.BR;


public class Account extends BaseObservable {
    private String name;
    private int level;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Bindable
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
        notifyPropertyChanged(com.example.mmm.BR.level);
    }
}
