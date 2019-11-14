package com.licy.fontscale.moudle.typeface.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.licy.fontscale.R;
import com.licy.fontscale.moudle.typeface.bean.TypeFaceBean;

import java.util.List;

/**
 * TypeFaceRecycleAdapter
 * description: TODO
 *
 * @author : Licy
 * @date : 2019/11/12
 * email ：licy3051@qq.com
 */
public class TypeFaceRecycleAdapter extends BaseQuickAdapter<TypeFaceBean, TypeFaceRecycleAdapter.TypefaceViewHolder> {

    private Context mContext;
    private List<TypeFaceBean> mDatas;

    public TypeFaceRecycleAdapter(int layoutResId, @Nullable List<TypeFaceBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(TypefaceViewHolder helper, TypeFaceBean item) {
        helper.tvContent.setText(item.getContent());
        helper.tvContent.setTypeface(item.getTypeface());
    }


    class TypefaceViewHolder extends BaseViewHolder {

        TextView tvContent;

        public TypefaceViewHolder(@NonNull View itemView) {
            super(itemView);
            tvContent = itemView.findViewById(R.id.tv_content);
        }
    }
}
