package com.aoslec.test_0603_q2_hyeji;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button btnDog, btnCat;
    ImageView imgPet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDog = findViewById(R.id.btnDog);
        btnCat = findViewById(R.id.btnCat);

        imgPet = findViewById(R.id.imgPet);

        imgPet.setVisibility(View.INVISIBLE);

        btnDog.setOnClickListener(clickListener);
        btnCat.setOnClickListener(clickListener);
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btnDog:
                    imgPet.setVisibility(v.VISIBLE);
                    imgPet.setImageResource(R.drawable.dog);
                    break;
                case R.id.btnCat:
                    imgPet.setVisibility(v.VISIBLE);
                    imgPet.setImageResource(R.drawable.cat);
            }
        }
    };
}