package com.licy.fontscale.helper;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;

import androidx.annotation.IntDef;
import androidx.annotation.IntRange;
import androidx.core.content.res.ResourcesCompat;

import com.licy.fontscale.R;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * TypeFaceHelper
 * description: TODO
 *
 * @author : Licy
 * @date : 2019/11/12
 * email ：licy3051@qq.com
 */
public class TypeFaceHelper {

    private static TypeFaceHelper INSTANCE;

    private TypeFaceHelper() {
    }

    public static TypeFaceHelper getInstance() {
        if (null == INSTANCE) {
            INSTANCE = new TypeFaceHelper();
        }
        return INSTANCE;
    }


    @Retention(RetentionPolicy.SOURCE)
    @IntDef({TYPEFACE_HUA_KANG_WA_WA, TYPEFACE_HUA_WEN_XING_KAI, TYPEFACE_APPLE, TYPEFACE_HUA_KANG_SHAO_NV, TYPEFACE_FANG_ZHENG})
    public @interface CustomTypeFace {
    }

    public static final int TYPEFACE_HUA_KANG_WA_WA = 1;
    public static final int TYPEFACE_HUA_WEN_XING_KAI = 2;
    public static final int TYPEFACE_APPLE = 3;
    public static final int TYPEFACE_HUA_KANG_SHAO_NV = 4;
    public static final int TYPEFACE_FANG_ZHENG = 5;

    public Typeface getHuaKangWaWaTypeFace(Context context) {
        AssetManager assetManager = context.getAssets();
        return Typeface.createFromAsset(assetManager, "fonts/huakangwawa.TTF");
    }

    public Typeface getHuaWenXingKaiTypeFace(Context context) {
        AssetManager assetManager = context.getAssets();
        return Typeface.createFromAsset(assetManager, "fonts/huawenxingkai.ttf");
    }

    public Typeface getAppleTypeFace(Context context) {
        return ResourcesCompat.getFont(context, R.font.apple);
    }

    public Typeface getHuaKangShaoNvTypeFace(Context context) {
        return ResourcesCompat.getFont(context, R.font.huakangshaonv);
    }

    public Typeface getFangZhengTypeFace(Context context) {
        return ResourcesCompat.getFont(context, R.font.fangzheng);
    }

    public Typeface getTypeFace(Context context, @CustomTypeFace int type) {

        if (context == null || type <= 0) {
            return Typeface.DEFAULT;
        }

        switch (type) {
            case TYPEFACE_HUA_KANG_WA_WA:
                return getHuaKangWaWaTypeFace(context);
            case TYPEFACE_HUA_WEN_XING_KAI:
                return getHuaWenXingKaiTypeFace(context);
            case TYPEFACE_APPLE:
                return getAppleTypeFace(context);
            case TYPEFACE_HUA_KANG_SHAO_NV:
                return getHuaKangShaoNvTypeFace(context);
            case TYPEFACE_FANG_ZHENG:
                return getFangZhengTypeFace(context);
            default:
                return Typeface.DEFAULT;
        }
    }

}
