package com.aostest.imgtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DownloadImgActivity extends AppCompatActivity {

    ImageView ivDown;
    Button btnDown;
    ShareVar shareVar = new ShareVar();
    BitmapDrawable drawable;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_img);


        ActivityCompat.requestPermissions(DownloadImgActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);
        ActivityCompat.requestPermissions(DownloadImgActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, MODE_PRIVATE);


        ivDown = findViewById(R.id.down_iv);
        btnDown = findViewById(R.id.down_btn);

        Glide.with(this)
                .load("http://" + shareVar.macIP + ":8080/aosimgtest/img/duck.JPG")
                .into(ivDown);

        btnDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawable = (BitmapDrawable) ivDown.getDrawable();
                bitmap = drawable.getBitmap();
                FileOutputStream outputStream = null;

                File sdCard = Environment.getExternalStorageDirectory();
                File directory = new File(sdCard.getAbsolutePath() + "/Pictures");
                Log.v("imgTest", directory.toString());
                directory.mkdir();
                String filename = String.format("%d.jpg", System.currentTimeMillis());
                File outFile = new File(directory, filename);

                Toast.makeText(DownloadImgActivity.this, "Image saved successfully", Toast.LENGTH_SHORT).show();
                try {
                    outputStream = new FileOutputStream(outFile);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
                    outputStream.flush();
                    outputStream.close();

                    Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                    intent.setData(Uri.fromFile(outFile));
                    sendBroadcast(intent);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });


    }
}