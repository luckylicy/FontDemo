package com.licy.fontscale;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.app.FontTextDelegate;

/**
 * BaseActivity
 * description: TODO
 *
 * @author : Licy
 * @date : 2019/11/12
 * email ：licy3051@qq.com
 */
public abstract class BaseActivity extends AppCompatActivity {


    private AppCompatDelegate mDelegate;

    @NonNull
    @Override
    public AppCompatDelegate getDelegate() {
        if (mDelegate==null){
            mDelegate = new FontTextDelegate(this, getWindow(), this);
        }
        return mDelegate;
    }
}
