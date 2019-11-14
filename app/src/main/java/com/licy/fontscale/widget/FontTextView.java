package com.licy.fontscale.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

import com.licy.fontscale.helper.TypeFaceHelper;

/**
 * FontTextView
 * description: TODO
 *
 * @author : Licy
 * @date : 2019/11/12
 * email ：licy3051@qq.com
 */
public class FontTextView extends AppCompatTextView {

    public FontTextView(Context context) {
        super(context);
        setTypeface(TypeFaceHelper.getInstance().getHuaKangShaoNvTypeFace(context));
    }

    public FontTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTypeface(TypeFaceHelper.getInstance().getHuaKangShaoNvTypeFace(context));
    }

    public FontTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTypeface(TypeFaceHelper.getInstance().getHuaKangShaoNvTypeFace(context));
    }

    @Override
    public void setTypeface(@Nullable Typeface tf) {
        super.setTypeface(tf);
    }
}
