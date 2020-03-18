package com.kingbird.mquitest.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.kingbird.mquitest.R;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.socks.library.KLog;

import butterknife.ButterKnife;

/**
 * @ClassName: GridLayoutActivity
 * @Description: java类作用描述
 * @Author: Pan
 * @CreateDate: 2020/3/17 15:03:49
 */
public class GridLayoutActivity extends Activity {
//    @BindView(R.id.Topbar2)
    QMUITopBar mTopBar;
    final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_layout);
        KLog.e("我是：" + this);

        mTopBar=findViewById(R.id.Topbar2);

        // 沉浸式状态栏
        QMUIStatusBarHelper.translucent(this);

//        View root = LayoutInflater.from(this).inflate(R.layout.activity_grid_layout, null);
        ButterKnife.bind(this);
        //初始化状态栏
        initTopBar();

//        setContentView(R.layout.activity_grid_layout);
//        KLog.e("我是：" + this);
    }

    private void initTopBar() {
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                finish();
                KLog.e("点击Topbar");
            }
        });

        mTopBar.setTitle("注册账号");
    }
}
