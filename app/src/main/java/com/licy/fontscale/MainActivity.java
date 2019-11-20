package com.licy.fontscale;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.licy.fontscale.moudle.calligraphy.CalligraphyActivity;
import com.licy.fontscale.moudle.font.FontScaleActivity;
import com.licy.fontscale.moudle.typeface.TypeFaceActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_font_scale)
    TextView tvFontScale;
    @BindView(R.id.tv_font_typeface)
    TextView tvFontTypeface;
    @BindView(R.id.tv_typeface_calligraphy)
    TextView tvTypefaceCalligraphy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tv_font_scale, R.id.tv_font_typeface, R.id.tv_typeface_calligraphy})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_font_scale:
                startActivity(new Intent(MainActivity.this, FontScaleActivity.class));
                break;
            case R.id.tv_font_typeface:
                startActivity(new Intent(MainActivity.this, TypeFaceActivity.class));
                break;
            case R.id.tv_typeface_calligraphy:
                startActivity(new Intent(MainActivity.this, CalligraphyActivity.class));
                break;
            default:
                break;
        }
    }

}
