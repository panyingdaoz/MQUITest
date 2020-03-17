package com.kingbird.mquitest;

import android.os.Bundle;
import android.view.View;
import android.webkit.DownloadListener;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.qmuiteam.qmui.util.QMUIStatusBarHelper;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;
import com.qmuiteam.qmui.widget.webview.QMUIWebView;
import com.qmuiteam.qmui.widget.webview.QMUIWebViewContainer;

/**
 * @ClassName: WebViewAcitivity
 * @Description: java类作用描述
 * @Author: Pan
 * @CreateDate: 2020/3/17 16:17:24
 */
public class WebViewAcitivity extends AppCompatActivity {

    private QMUITopBarLayout topbar;
    private QMUIWebViewContainer qmuiwebcon;
    MqWebView mWebView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        initMqUiWebView();
    }

    private void initMqUiWebView() {
        QMUIStatusBarHelper.translucent(this);
        qmuiwebcon = findViewById(R.id.webview_container);
        topbar = findViewById(R.id.topbar);
        topbar.setTitle("WebView测试").setTextColor(ContextCompat.getColor(this, R.color.qmui_config_color_white));
        topbar.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        mWebView = new MqWebView(this);
        boolean needDispatchSafeAreaInset = needDispatchSafeAreaInset();
        qmuiwebcon.addWebView(mWebView, needDispatchSafeAreaInset);
//        mWebView.loadUrl("https://www.daimadog.com");
        mWebView.loadUrl("https://noone.work:442/teacher.html");
        qmuiwebcon.setCustomOnScrollChangeListener(new QMUIWebView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                onScrollWebContent(scrollX, scrollY, oldScrollX, oldScrollY);
            }
        });
        mWebView.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {

            }
        });
    }

    protected void onScrollWebContent(int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

    }

    protected boolean needDispatchSafeAreaInset() {
        return false;
    }
}
