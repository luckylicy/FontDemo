package com.licy.fontscale.moudle.font;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.licy.fontscale.R;
import com.licy.fontscale.app.MyApp;
import com.xw.repo.BubbleSeekBar;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * FontScaleActivity
 * description: TODO
 *
 * @author : Licy
 * @date : 2019/11/11
 * email ：licy3051@qq.com
 */
public class FontScaleActivity extends AppCompatActivity {

    @BindView(R.id.title_bar)
    RelativeLayout titleBar;
    @BindView(R.id.tv_show)
    TextView tvShow;
    @BindView(R.id.ll_text_show)
    LinearLayout llTextShow;
    @BindView(R.id.font_size_small)
    TextView fontSizeSmall;
    @BindView(R.id.font_size_large)
    TextView fontSizeLarge;
    @BindView(R.id.seekbar_text_size)
    BubbleSeekBar seekbarTextSize;
    @BindView(R.id.btn_back)
    ImageButton btnBack;
    @BindView(R.id.tv_save)
    TextView tvSave;

    private Context mContext;
    private static final int FONTSCALE_MULTIPER_BASE = 5;
    private static final int FONTSCALE_MIN = 15;
    private static final int FONTSCALE_MAX = 50;
    private float mCustomFontScale = 1.0f;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_font_modify_scale);
        ButterKnife.bind(this);

        initListener();
    }

    private void initListener() {

        seekbarTextSize.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat, boolean fromUser) {

                if (progress > 2 && progress < 11) {
                    tvShow.setTextSize(progress * FONTSCALE_MULTIPER_BASE);
                    mCustomFontScale = (float) (progress * FONTSCALE_MULTIPER_BASE) / (float) FONTSCALE_MIN;
                }

            }

            @Override
            public void getProgressOnActionUp(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat) {

            }

            @Override
            public void getProgressOnFinally(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat, boolean fromUser) {

            }
        });

        btnBack.setOnClickListener(v -> onBackPressed());

        tvSave.setOnClickListener(v -> {
            MyApp.setAppFontSize(mCustomFontScale);
            startActivity(new Intent(FontScaleActivity.this, ModifyScaleResultActivity.class));
        });
    }


}
