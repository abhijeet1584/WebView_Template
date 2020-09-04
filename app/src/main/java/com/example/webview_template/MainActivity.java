package com.example.webview_template;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        web = (WebView) findViewById(R.id.webView);
        web.setWebViewClient(new WebViewClient());
        web.loadUrl("https://www.google.com/"); // The main url of the website
        WebSettings webSettings = web.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
    public  class mywebClient extends WebViewClient {
        @Override
        public  void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        public boolean showOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

    }
    @Override
    public
    void onBackPressed() {
        if(web.canGoBack()) {
            web.goBack();
        }
        else {
            super.onBackPressed();
        }
    }
}
