package com.kingbird.mquitest.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.kingbird.mquitest.R;
import com.kingbird.mquitest.fragment.QDArchTestFragment;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArchTestActivity extends BaseActivity {
    @BindView(R.id.topbar)
    QMUITopBarLayout mTopBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View root = LayoutInflater.from(this).inflate(R.layout.activity_arch_test, null);
        ButterKnife.bind(this, root);
        initTopBar();
        setContentView(root);
    }

    private void initTopBar() {
        mTopBar.setBackgroundColor(ContextCompat.getColor(this, R.color.app_color_theme_4));
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.slide_still, R.anim.slide_out_right);
            }
        });
        mTopBar.setTitle("Arch Test");
        QDArchTestFragment.injectEntrance(mTopBar);
    }
}
