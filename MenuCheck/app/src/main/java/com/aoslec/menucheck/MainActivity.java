package com.aoslec.menucheck;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.aoslec.menucheck.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        // 버튼 연결
        button = findViewById(R.id.button);

//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
//        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    // 생성해주기 - 옵션 메뉴가 클릭되기 전에 준비하는 것
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // 버튼의 텍스트 컬러를 받아서 무조건 정수로 관리
        int color = button.getTextColors().getDefaultColor();
        if (color == Color.RED){
            // res -> menu 의 menu 임! menu - group - item 이게 아님!
            menu.findItem(R.id.red).setChecked(true);
        }
        if (color == Color.GREEN){
            menu.findItem(R.id.green).setChecked(true);
        }
        if (color == Color.BLUE){
            menu.findItem(R.id.blue).setChecked(true);
        }
        // boolean 값으로 리턴
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch (item.getItemId()){
            case R.id.red:
                button.setTextColor(Color.RED);
                return true;
            case R.id.green:
                button.setTextColor(Color.GREEN);
                return true;
            case R.id.blue:
                button.setTextColor(Color.BLUE);
                return true;
        }

        return false;
    }

    @Override
    public boolean onSupportNavigateUp() {
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
//        return NavigationUI.navigateUp(navController, appBarConfiguration)
//                || super.onSupportNavigateUp();
        return true;
    }
}