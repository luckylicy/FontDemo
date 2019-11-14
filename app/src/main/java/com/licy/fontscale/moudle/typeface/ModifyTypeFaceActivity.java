package com.licy.fontscale.moudle.typeface;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.licy.fontscale.R;
import com.licy.fontscale.helper.TypeFaceHelper;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * ModifyTypeFaceActivity
 * description: TODO
 *
 * @author : Licy
 * @date : 2019/11/12
 * email ：licy3051@qq.com
 */
public class ModifyTypeFaceActivity extends AppCompatActivity {

    @BindView(R.id.title_bar)
    RelativeLayout titleBar;
    @BindView(R.id.tv_show)
    TextView tvShow;
    @BindView(R.id.ll_text_show)
    LinearLayout llTextShow;
    @BindView(R.id.btn_sure)
    Button btnSure;

    private int mTypeFaceType;
    private Context mContext;

    public static void Launch(Context context, @TypeFaceHelper.CustomTypeFace int type) {
        Intent intent = new Intent(context, ModifyTypeFaceActivity.class);
        intent.putExtra("typeface", type);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_typeface);
        ButterKnife.bind(this);
        mContext = this;
        initIntent();

        tvShow.setTypeface(TypeFaceHelper.getInstance().getTypeFace(mContext, mTypeFaceType));

        btnSure.setOnClickListener(v -> {
            startActivity(new Intent(ModifyTypeFaceActivity.this, TypeFaceResultActivity.class));
        });
    }

    private void initIntent() {
        mTypeFaceType = getIntent().getIntExtra("typeface", 0);
    }


}
