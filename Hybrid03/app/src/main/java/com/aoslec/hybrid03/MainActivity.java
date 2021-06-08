package com.aoslec.hybrid03;

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
        String uri = "<html>\n" +
                "<head>\n" +
                "<meta charset=\"UTF-8\">\n" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "<title>Insert title here</title>\n" +
                "</head>\n" +
                "<body>\n";
        String uri2 = "</body>\n" +
                "</html>";
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.hello:
                    String word  = "<h1>Hello Word!</h1>";
                    webView.loadData(word, "text/html", "UTF-8");
                    break;
                case R.id.smallImage:
                    webView.loadDataWithBaseURL(null, uri+"<img src=\"http://192.168.0.128:8080/test/mov02.jpg\">"+uri2, "text/html", "UTF-8", null);
                    break;
                case R.id.largeImage:
                    webView.loadDataWithBaseURL(null, uri+"<img src=\"http://192.168.0.128:8080/test/mov02.jpg\" style=\"width: 100%; height: auto;\">"+uri2, "text/html", "UTF-8", null);
                    break;
            }
        }
    };
}