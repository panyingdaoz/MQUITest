package com.kingbird.mquitest.activity;

import android.annotation.SuppressLint;
import android.content.Intent;

import com.kingbird.mquitest.manager.QDUpgradeManager;
import com.qmuiteam.qmui.arch.QMUIActivity;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;

import static com.kingbird.mquitest.MyApplication.getContext;

@SuppressLint("Registered")
public class BaseActivity extends QMUIActivity {

    @Override
    protected int backViewInitOffset() {
        return QMUIDisplayHelper.dp2px(getContext(), 100);
    }

    @Override
    protected void onResume() {
        super.onResume();
        QDUpgradeManager.getInstance(getContext()).runUpgradeTipTaskIfExist(this);
    }

    @Override
    public Intent onLastActivityFinish() {
        // 回退
        return new Intent(this, MainActivity.class);
    }
}
