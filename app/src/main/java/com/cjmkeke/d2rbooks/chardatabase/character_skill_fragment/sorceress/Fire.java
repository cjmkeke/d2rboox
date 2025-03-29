package com.cjmkeke.d2rbooks.chardatabase.character_skill_fragment.sorceress;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.cjmkeke.d2rbooks.R;
import com.cjmkeke.d2rbooks.databinding.FragmentFireBinding;

public class Fire extends Fragment {

    private FragmentFireBinding mBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fire, container, false);
    }
}