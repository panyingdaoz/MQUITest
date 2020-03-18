package com.kingbird.mquitest.manager;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by cgspine on 2018/1/14.
 */

public class QDPreferenceManager {

    private static SharedPreferences sPreferences;
    private static QDPreferenceManager sQDPreferenceManager = null;

    private static final String APP_VERSION_CODE = "app_version_code";
    private static final String APP_SKIN_INDEX = "app_skin_index";

    private QDPreferenceManager(Context context) {
        sPreferences = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
    }

    public static final QDPreferenceManager getInstance(Context context) {
        if (sQDPreferenceManager == null) {
            sQDPreferenceManager = new QDPreferenceManager(context);
        }
        return sQDPreferenceManager;
    }

    public void setAppVersionCode(int code) {
        final SharedPreferences.Editor editor = sPreferences.edit();
        editor.putInt(APP_VERSION_CODE, code);
        editor.apply();
    }

    public int getVersionCode() {
        return sPreferences.getInt(APP_VERSION_CODE, QDUpgradeManager.INVALIDATE_VERSION_CODE);
    }

    public void setSkinIndex(int index) {
        SharedPreferences.Editor editor = sPreferences.edit();
        editor.putInt(APP_SKIN_INDEX, index);
        editor.apply();
    }

    public int getSkinIndex() {
        return sPreferences.getInt(APP_SKIN_INDEX, QDSkinManager.SKIN_BLUE);
    }
}
