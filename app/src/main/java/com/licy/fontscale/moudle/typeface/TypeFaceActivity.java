package com.licy.fontscale.moudle.typeface;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.licy.fontscale.R;
import com.licy.fontscale.helper.TypeFaceHelper;
import com.licy.fontscale.moudle.typeface.adapter.TypeFaceRecycleAdapter;
import com.licy.fontscale.moudle.typeface.bean.TypeFaceBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * TypeFaceActivity
 * description: TODO
 *
 * @author : Licy
 * @date : 2019/11/12
 * email ：licy3051@qq.com
 */
public class TypeFaceActivity extends AppCompatActivity {

    @BindView(R.id.recycle_view)
    RecyclerView recycleView;

    private Context mContext;
    private TypeFaceRecycleAdapter mRecycleAdapter;
    private List<TypeFaceBean> mList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_typeface);
        ButterKnife.bind(this);
        mContext = this;
        initData();
        initRecycleView();
    }

    private void initData() {
        mList = new ArrayList<>(8);
        mList.add(new TypeFaceBean("中国智造，惠及全球 0123456789 Aa Bb Cc",
                TypeFaceHelper.getInstance().getAppleTypeFace(mContext),
                TypeFaceHelper.TYPEFACE_APPLE, "苹果丽黑体"));
        mList.add(new TypeFaceBean("中国智造，惠及全球 0123456789 Aa Bb Cc",
                TypeFaceHelper.getInstance().getFangZhengTypeFace(mContext),
                TypeFaceHelper.TYPEFACE_FANG_ZHENG, "方正黑体"));
        mList.add(new TypeFaceBean("中国智造，惠及全球 0123456789 Aa Bb Cc",
                TypeFaceHelper.getInstance().getHuaKangShaoNvTypeFace(mContext),
                TypeFaceHelper.TYPEFACE_HUA_KANG_SHAO_NV, "华康少女体"));
        mList.add(new TypeFaceBean("中国智造，惠及全球 0123456789 Aa Bb Cc",
                TypeFaceHelper.getInstance().getHuaKangWaWaTypeFace(mContext),
                TypeFaceHelper.TYPEFACE_HUA_KANG_WA_WA, "华康娃娃体"));
        mList.add(new TypeFaceBean("中国智造，惠及全球 0123456789 Aa Bb Cc",
                TypeFaceHelper.getInstance().getHuaWenXingKaiTypeFace(mContext),
                TypeFaceHelper.TYPEFACE_HUA_WEN_XING_KAI, "华文行楷体"));
    }

    private void initRecycleView() {
        recycleView.setLayoutManager(new LinearLayoutManager(mContext));

        mRecycleAdapter = new TypeFaceRecycleAdapter(R.layout.item_recycle_typeface, mList);
        recycleView.setAdapter(mRecycleAdapter);

        mRecycleAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ModifyTypeFaceActivity.Launch(mContext, mList.get(position).getCode());
            }
        });
    }
}
