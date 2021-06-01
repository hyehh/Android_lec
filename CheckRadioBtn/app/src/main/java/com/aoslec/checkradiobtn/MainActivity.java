package com.aoslec.checkradiobtn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    Button button;
    ImageView imageDog, imageCat, imageRabbit;
    LinearLayout layoutSecond, layoutThird;
    CheckBox checkBox;
    RadioButton dog, cat, rabbit;
    RadioGroup group;
    String str = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.check);

        imageDog = findViewById(R.id.imageDog);
        imageCat = findViewById(R.id.imageCat);
        imageRabbit = findViewById(R.id.imageRabbit);

        layoutSecond = findViewById(R.id.layoutSecond);
        layoutThird = findViewById(R.id.layoutThird);

        checkBox = findViewById(R.id.cb_01);

        group = findViewById(R.id.rg_01);

        dog = findViewById(R.id.rb_01);
        cat = findViewById(R.id.rb_02);
        rabbit = findViewById(R.id.rb_03);

        checkBox.setOnCheckedChangeListener(checkListener);
        //group.setOnCheckedChangeListener(radioListener);
        button.setOnClickListener(clickListener);

    }

    CompoundButton.OnCheckedChangeListener checkListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(checkBox.isChecked() == true){
                layoutSecond.setVisibility(buttonView.VISIBLE);
            }else {
                layoutSecond.setVisibility(buttonView.INVISIBLE);
                layoutThird.setVisibility(buttonView.INVISIBLE);
            }
        }
    };


    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            layoutThird.setVisibility(v.VISIBLE);

//            switch (str){
//                case "강아지":
//                    imageDog.setVisibility(v.VISIBLE);
//                    imageCat.setVisibility(v.INVISIBLE);
//                    imageRabbit.setVisibility(v.INVISIBLE);
//                    break;
//                case "고양이":
//                    imageDog.setVisibility(v.INVISIBLE);
//                    imageCat.setVisibility(v.VISIBLE);
//                    imageRabbit.setVisibility(v.INVISIBLE);
//                    break;
//                case "토끼":
//                    imageDog.setVisibility(v.INVISIBLE);
//                    imageCat.setVisibility(v.INVISIBLE);
//                    imageRabbit.setVisibility(v.VISIBLE);
//                    break;
            if(dog.isChecked() == true){
                imageDog.setVisibility(v.VISIBLE);
                imageCat.setVisibility(v.INVISIBLE);
                imageRabbit.setVisibility(v.INVISIBLE);
            }
            if(cat.isChecked() == true){
                imageCat.setVisibility(v.VISIBLE);
                imageDog.setVisibility(v.INVISIBLE);
                imageRabbit.setVisibility(v.INVISIBLE);
            }
            if(rabbit.isChecked() == true){
                imageRabbit.setVisibility(v.VISIBLE);
                imageDog.setVisibility(v.INVISIBLE);
                imageCat.setVisibility(v.INVISIBLE);
            }
        }
    };

//    RadioGroup.OnCheckedChangeListener radioListener = new RadioGroup.OnCheckedChangeListener() {
//        @Override
//        public void onCheckedChanged(RadioGroup group, int checkedId) {
//            switch (checkedId){
//                case R.id.rb_01:
//                    str = "강아지";
//                    break;
//                case R.id.rb_02:
//                    str = "고양이";
//                    break;
//                case R.id.rb_03:
//                    str = "토끼";
//                    break;
//            }
//        }
//    };
}