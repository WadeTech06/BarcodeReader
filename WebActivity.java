package com.cis470.lakiel.barcodereader;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;


public class WebActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.barcode_web);


        if (isNetworkAvailable())     //check if internet available or not
        {
            String url = getIntent().getStringExtra("URL");

            Toast.makeText(
                    WebActivity.this,
                    url,
                    Toast.LENGTH_LONG
            ).show();

            WebView webView = (WebView) findViewById(R.id.webview);
            webView.loadUrl(url);

        } else    //Not connected
        {
            Toast.makeText(
                    WebActivity.this,
                    "Internet Disconnected",
                    Toast.LENGTH_LONG
            ).show();
        }
    }

    public boolean isNetworkAvailable() {
        final ConnectivityManager connectivityManager = ((ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }
}

