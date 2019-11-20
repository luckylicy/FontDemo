package com.licy.fontscale.moudle.calligraphy;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.licy.fontscale.R;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * CalligraphyActivity
 * description: TODO
 *
 * @author : Licy
 * @date : 2019/11/19
 * email ：licy3051@qq.com
 */
public class CalligraphyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_typeface_calligraphy);
    }


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));

    }
}
