package com.licy.fontscale.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;

import com.didichuxing.doraemonkit.DoraemonKit;
import com.licy.fontscale.BuildConfig;
import com.licy.fontscale.R;
import com.licy.fontscale.moudle.font.FontScaleActivity;

import java.util.ArrayList;
import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * MyApp
 * description: TODO
 *
 * @author : Licy
 * @date : 2019/11/11
 * email ：licy3051@qq.com
 */
public class MyApp extends Application implements Application.ActivityLifecycleCallbacks {

    private List<Activity> activityList;
    private float fontScale;
    private SharedPreferences preferences;
    private static MyApp mainApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        init();
        if (BuildConfig.DEBUG) {
            DoraemonKit.install(mainApplication);
        }

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/huakangwawa.TTF")
                .setFontAttrId(R.attr.fontPath)
                .build());
    }

    public static MyApp getInstance() {
        return mainApplication;
    }

    private void init() {
        mainApplication = this;
        preferences = getSharedPreferences("MyApp", Context.MODE_PRIVATE);
        fontScale = getFontScale();
        registerActivityLifecycleCallbacks(this);
    }

    public static float getFontScale() {
        float fontScale = 1.0f;
        if (mainApplication != null) {
            fontScale = mainApplication.preferences.getFloat("fontScale", 1.0f);
        }
        return fontScale;
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        if (activityList == null) {
            activityList = new ArrayList<>();
        }
        // 禁止字体大小随系统设置变化
        Resources resources = activity.getResources();
        if (resources != null && resources.getConfiguration().fontScale != fontScale) {
            android.content.res.Configuration configuration = resources.getConfiguration();
            configuration.fontScale = fontScale;
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        }
        activityList.add(activity);
    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        if (activityList != null) {
            activityList.remove(activity);
        }
    }

    public static void setAppFontSize(float fontScale) {
        if (mainApplication != null) {
            List<Activity> activityList = mainApplication.activityList;
            if (activityList != null) {
                for (Activity activity : activityList) {
                    if (activity instanceof FontScaleActivity) {
                        activity.finish();
                        continue;
                    }
                    Resources resources = activity.getResources();
                    if (resources != null) {
                        android.content.res.Configuration configuration = resources.getConfiguration();
                        configuration.fontScale = fontScale;
                        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
                        activity.recreate();
                        if (fontScale != mainApplication.fontScale) {
                            mainApplication.fontScale = fontScale;
                            mainApplication.preferences.edit().putFloat("fontScale", fontScale).apply();
                        }
                    }
                }
            }
        }
    }
}