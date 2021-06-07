package com.aoslec.fragmenttest;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TextFragment extends Fragment { // 글씨 보여주는 곳 (받는 애임)

    TextView textView = null;

    // Main에게 줄 게 없기에 onAttach()는 필요 없고 onCreateView만 생성하기
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.v("Message", "onCreateView_text");
        View view = inflater.inflate(R.layout.fragment_text, container, false);

        // TextView 연결
        textView = view.findViewById(R.id.f2_text);

        return view;
    }

    // 메소드 하나 만들기
    public void changeTextProperties(int fontSize, String str){
        Log.v("Message", "changeTextProperties_text");
        textView.setTextSize(fontSize);
        textView.setText(str);
    }
}