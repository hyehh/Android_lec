package com.aoslec.tablayout;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Tab4Fragment extends Fragment {

    // constructor
    public Tab4Fragment(){

    }

    // fragment는 제일 먼저 나오는 게 onAttach가 없다면 onCreateView!!!(이건 꼭 있어야 함!)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tab4, container, false);
    }
}