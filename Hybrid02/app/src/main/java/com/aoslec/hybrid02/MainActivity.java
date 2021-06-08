package com.aoslec.hybrid02;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button hello, smallImage, largeImage;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hello = findViewById(R.id.hello);
        smallImage = findViewById(R.id.smallImage);
        largeImage = findViewById(R.id.largeImage);
        webView = findViewById(R.id.webView);

        hello.setOnClickListener(onClickListener);
        smallImage.setOnClickListener(onClickListener);
        largeImage.setOnClickListener(onClickListener);

        WebSettings webSettings = webView.getSettings();

        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(true);

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                Toast.makeText(MainActivity.this, "로딩 중입니다", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                Toast.makeText(MainActivity.this, "로딩 완료되었습니다", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        }else {
            finish();
        }
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.hello:
                    webView.loadUrl("http://192.168.0.128:8080/test/hello.jsp");
                    break;
                case R.id.smallImage:
                    webView.loadUrl("http://192.168.0.128:8080/test/image1.jsp");
                    break;
                case R.id.largeImage:
                    webView.loadUrl("http://192.168.0.128:8080/test/image2.jsp");
                    break;
            }
        }
    };
}