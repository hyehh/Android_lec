package com.aoslec.hybrid01;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    WebView webView = null;
    Button btnReload, btnPage1, btnPage2, btnPage3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webview);
        btnReload = findViewById(R.id.btn_reload);
        btnPage1 = findViewById(R.id.btn_page1);
        btnPage2 = findViewById(R.id.btn_page2);
        btnPage3 = findViewById(R.id.btn_page3);

        btnReload.setOnClickListener(onClickListener);
        btnPage1.setOnClickListener(onClickListener);
        btnPage2.setOnClickListener(onClickListener);
        btnPage3.setOnClickListener(onClickListener);

        //web Setting
        WebSettings webSettings = webView.getSettings();
        // js 사용가능하게 설정
        webSettings.setJavaScriptEnabled(true);
        // 확대 축소 가능
        webSettings.setBuiltInZoomControls(true);
        // 돋보기 없애기
        webSettings.setDisplayZoomControls(true);

        // Link 시 다른 Browser 안보이고 내 앱에서 이동하도록 설정
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                btnReload.setText("로딩 중...");
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                // html의 타이틀을 가져옴
                btnReload.setText(webView.getTitle());
            }
        });
    }

    @Override
    public void onBackPressed() {
        // 뒤로 버튼을 눌렀을 때 웹이 이동하도록 설정
        if(webView.canGoBack()){
            webView.goBack();
        }else { // 첫 화면에서 백 누르면 앱 종료 (웹에서 백할 것이 없는 경우)
            finish();
        }
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_page1:
                    btnPage1Click();
                    //webView.loadUrl("https://www.naver.com");
                    break;
                case R.id.btn_page2:
                    webView.loadUrl("https://www.google.com");
                    break;
                case R.id.btn_page3:
                    webView.loadUrl("https://www.daum.net");
                    break;
            }
        }
    };

    public void btnPage1Click(){
        webView.loadUrl("http://192.168.0.128:8080/test/Arithmetic.jsp");
    }
}