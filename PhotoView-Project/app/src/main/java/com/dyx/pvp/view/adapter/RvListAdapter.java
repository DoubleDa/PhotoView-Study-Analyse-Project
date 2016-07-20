package com.dyx.pvp.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dyx.pp.library.util.Utils;
import com.dyx.pvp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * project name：PhotoView-Project
 * class describe：
 * create person：dayongxin
 * create time：16/7/20 上午11:28
 * alter person：dayongxin
 * alter time：16/7/20 上午11:28
 * alter remark：
 */
public class RvListAdapter extends RecyclerView.Adapter<RvListAdapter.ItemViewHolder> {
    private List<String> mDataList;
    private Context mContext;
    private OnRvItemClickListener mOnRvItemClickListener;

    public interface OnRvItemClickListener {
        void itemClicked(int pos);
    }

    public void setmOnRvItemClickListener(OnRvItemClickListener mOnRvItemClickListener) {
        this.mOnRvItemClickListener = mOnRvItemClickListener;
    }

    public RvListAdapter(List<String> mDataList, Context mContext) {
        this.mDataList = mDataList;
        this.mContext = mContext;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_list_layout, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, int position) {
        Picasso.with(mContext).load(mDataList.get(position)).resize(Utils.getWindowWidth(mContext) / 3, Utils.getWindowWidth(mContext) / 3).into(holder.iv);
        if (mOnRvItemClickListener != null) {
            holder.iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = holder.getLayoutPosition();
                    mOnRvItemClickListener.itemClicked(pos);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;

        public ItemViewHolder(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.iv_list);
        }
    }
}
