package com.kingbird.mquitest.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.kingbird.mquitest.R;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;
import com.socks.library.KLog;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.kingbird.mquitest.MyApplication.getContext;

/**
 * @ClassName: MainActivity
 * @Description: java类作用描述
 * @Author: Pan
 * @CreateDate: 2020/3/17 15:03:49
 */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.topbar)
    QMUITopBar mTopBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去除标题栏
//        Objects.requireNonNull(getSupportActionBar()).hide();
//        setContentView(R.layout.activity_main);

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//        }
        KLog.e("我是：" + this);
        // 沉浸式状态栏
//        QMUIStatusBarHelper.translucent(this);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.activity_main, null);
        ButterKnife.bind(this, view);
//        ButterKnife.bind(this);

//        Intent intent = new Intent(this, GridLayoutActivity.class);
//        startActivity(intent);
        initTopBar();

    }

    private void initTopBar() {
//        mTopBar.setTitle("注册账号");
//        QMUIStatusBarHelper.translucent(this);
        mTopBar.setTitle("注册账号").setTextColor(ContextCompat.getColor(this, R.color.qmui_config_color_white));
        mTopBar.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KLog.e("点击Topbar");
                Intent intent = new Intent(MainActivity.this, WebViewAcitivity.class);
                startActivity(intent);
            }
        });
    }


}
