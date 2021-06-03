package com.aoslec.datetime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    // 여기 있는 것들 다 class 임! 그래서 대문자로 시작하는 것임!
    Chronometer chrono;
    Button btnStart, btnEnd;
    RadioButton rdCal, rdTime;
    CalendarView calView;
    TimePicker timePicker;
    TextView tvYear, tvMonth, tvDay, tvHour, tvMinute;

    // 전역 변수로 만듬(다른 메소드에서도 쓰기 위함)
    int selectYear, selectMonth, selectDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // AppBar 이름 변경
        setTitle("시간 예약");

        // AppBody 설정
        // 버튼
        btnStart = findViewById(R.id.btnStart);
        btnEnd = findViewById(R.id.btnEnd);

        // 크로노미터
        chrono = findViewById(R.id.chronometer1);

        // 라디오 버튼
        rdCal = findViewById(R.id.rbCal);
        rdTime = findViewById(R.id.rbTime);

        // FrameLayout 의 2개 위젯
        timePicker = findViewById(R.id.timePicker1);
        calView = findViewById(R.id.calendarView1);

        // TextView 중에서 년, 월, 일, 시, 분
        tvYear = findViewById(R.id.tvYear);
        tvMonth = findViewById(R.id.tvMonth);
        tvDay = findViewById(R.id.tvDay);
        tvHour = findViewById(R.id.tvHour);
        tvMinute = findViewById(R.id.tvMinute);

        // 처음에는 2개를 안보이게 설정 (가능한 이 소스에서 visible invisible 설정하는 게 좋음)
        timePicker.setVisibility(View.INVISIBLE);
        calView.setVisibility(View.INVISIBLE);

        // 라디오 그룹으로 쓰든 라디오 버튼으로 쓰든 상관 없음
        rdCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePicker.setVisibility(View.INVISIBLE);
                calView.setVisibility(View.VISIBLE);
            }
        });

        rdTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePicker.setVisibility(View.VISIBLE);
                calView.setVisibility(View.INVISIBLE);
            }
        });

        // 타이머 설정
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chrono.setBase(SystemClock.elapsedRealtime());
//                chrono.setBase(SystemClock.currentThreadTimeMillis());
//                chrono.setBase(SystemClock.currentThreadTimeMillis());
                chrono.start();
                // 시작했을 때의 색 변경
                chrono.setTextColor(Color.RED);
            }
        });

        // 캘린더 선택 (날짜 바뀌는 리스너)
        calView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                selectYear = year;
                selectMonth = month + 1; // month는 0월부터 시작이기 때문에 1을 추가해줘야함!
                selectDay = dayOfMonth;
            }
        });

        // 예약 완료 버튼 눌렀을 경우
        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chrono.stop();
                // 끝났을 때의 색 변경
                chrono.setTextColor(Color.BLUE);

                tvYear.setText(Integer.toString(selectYear));
                tvMonth.setText(Integer.toString(selectMonth));
                tvDay.setText(Integer.toString(selectDay));

                // Picker에서 선택한 시간과 분
                tvHour.setText(Integer.toString(timePicker.getCurrentHour()));
                tvMinute.setText(Integer.toString(timePicker.getCurrentMinute()));
            }
        });
    } // onCreate
} // MainActivity