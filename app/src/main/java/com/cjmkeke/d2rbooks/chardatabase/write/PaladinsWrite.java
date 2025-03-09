package com.cjmkeke.d2rbooks.chardatabase.write;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.cjmkeke.d2rbooks.databinding.ActivityPaladinsWriteBinding;

public class PaladinsWrite extends AppCompatActivity {

    private static final String TAG = "PaladinsWrite";
    private ActivityPaladinsWriteBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = ActivityPaladinsWriteBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

    }
}