package com.aoslec.checkradiobtn1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView text1, text2;
    CheckBox chkAgree;
    RadioGroup rGroup;
    RadioButton rbDog, rbCat, rbRabbit;
    Button btnOk;
    ImageView imgPet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("좋아하는 동물 선택하기");

        // 위젯을 변수에 대입
        text1 = findViewById(R.id.text1);
        chkAgree = findViewById(R.id.ChkAgree);

        text2 = findViewById(R.id.text2);
        rGroup = findViewById(R.id.Rgroup1);
        rbDog = findViewById(R.id.rbDog);
        rbCat = findViewById(R.id.rbCat);
        rbRabbit = findViewById(R.id.rbRabbit);

        btnOk = findViewById(R.id.btnOk);
        imgPet = findViewById(R.id.ImgPet);

        // 시작함 체크박스의 체크가 변경되면 여기서 처리
        chkAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // 체크되면 모두 보이기
                if(chkAgree.isChecked() == true){
                    text2.setVisibility(View.VISIBLE);
                    rGroup.setVisibility(View.VISIBLE);
                    btnOk.setVisibility(View.VISIBLE);
                    imgPet.setVisibility(View.VISIBLE);
                }else{
                    text2.setVisibility(View.INVISIBLE);
                    rGroup.setVisibility(View.INVISIBLE);
                    btnOk.setVisibility(View.INVISIBLE);
                    imgPet.setVisibility(View.INVISIBLE);
                }
            }
        });

        // 버튼을 클릭하면 여기서 처리
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (rGroup.getCheckedRadioButtonId()){
                    case R.id.rbDog:
                        imgPet.setImageResource(R.drawable.dog);
                        break;
                    case R.id.rbCat:
                        imgPet.setImageResource(R.drawable.cat);
                        break;
                    case R.id.rbRabbit:
                        imgPet.setImageResource(R.drawable.rabbit);
                        break;
                    default:
                        // 체크 안하고 선택완료 버튼 누른 경우
                        // getApplicationContext() 현재 떠있는 application 의미/ 화면 여러개 띄어져 있으면 mainactivity 못씀
                        Toast.makeText(getApplicationContext(), "동물을 선택하세요!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}