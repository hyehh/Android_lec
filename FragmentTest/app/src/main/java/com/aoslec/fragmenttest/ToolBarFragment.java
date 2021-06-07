package com.aoslec.fragmenttest;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

public class ToolBarFragment extends Fragment {
    // ToolBarFragment는 Fragment에서 상속 받아서 쓰는 것임!

    EditText editText = null;
    Button button = null;
    SeekBar seekBar = null;
    int seekValue = 50; // 시작할 때 seekBar의 위치가 0이 아닌 10이 될 것임!

    ToolbarListener activityCallback;

    // -------------------
    // MainActivity와의 통신을 위해 interface를 사용
    // MainActivity에서는 implements로 사용
    // -------------------
    public interface ToolbarListener{
        // 인터페이스는 이름만 정해놓는 것임!
        // 이걸 정의해줘야 버튼을 쓸 수 있음
        public void onButtonClick(int position, String text);
    }

    // -------------------
    // Fragment에서는 제일 처음 실행되는 메소드가 onAttach() (onCreate()아님!)
    // -------------------
    @Override
    public void onAttach(@NonNull Context context) {
        Log.v("Message", "onAttach_tool");
        super.onAttach(context);
        // ToolbarListener 정의해야 함
        try {
            // context는 환경, 위치 이런것들을 다 알고 있음
            // 메인에게 activityCallback 이 기능이 context야 라고 정의한 걸 알려줌!
            activityCallback = (ToolbarListener) context;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.v("Message", "onCreateView_tool");
        // inflater 나와서 onCreate 못쓰고 onCreateView 써줘야 함!
        // 이제 그림 올리자
        View view = inflater.inflate(R.layout.fragment_toolbar, container, false);

        editText = view.findViewById(R.id.f1_edit);
        button = view.findViewById(R.id.f1_button);
        seekBar = view.findViewById(R.id.f1_seek);

        seekBar.setProgress(seekValue);

        button.setOnClickListener(mClickListener);
        seekBar.setOnSeekBarChangeListener(mSeekBarChangeListener);

        return view;
    }

    SeekBar.OnSeekBarChangeListener mSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            Log.v("Message", "onProgressChanged_tool");
            // progress가 변했다 - 어떻게 할래?
            // 값만 주기
            seekValue = progress;
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            Log.v("Message", "onStartTrackingTouch_tool");

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            Log.v("Message", "onStopTrackingTouch_tool");

        }
    };

    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.v("Message", "onClick_tool");
            // 실제적으로 누르는 것은 MainActivity의 onButtonClick()에서 실행
            // 여기는 버튼 누르는 것을 받는 메소드임! (여기에서는 ToolBarListener에 신호 주기) 그리고 MainActivity에 값을 준다!
            activityCallback.onButtonClick(seekValue, editText.getText().toString());
        }
    };
}