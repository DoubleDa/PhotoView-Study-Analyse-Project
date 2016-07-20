package com.dyx.pvp.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dyx.pvp.R;

import java.util.List;

/**
 * project name：PhotoView-Project
 * class describe：
 * create person：dayongxin
 * create time：16/7/20 上午10:10
 * alter person：dayongxin
 * alter time：16/7/20 上午10:10
 * alter remark：
 */
public class MainPageAdapter extends RecyclerView.Adapter<MainPageAdapter.MainPageViewHolder> {
    private List<String> mDataList;
    private Context mContext;
    private onRvItemClickListener monRvItemClickListener;

    public interface onRvItemClickListener {
        void itemClick(int position);
    }

    public void setMonRvItemClickListener(onRvItemClickListener monRvItemClickListener) {
        this.monRvItemClickListener = monRvItemClickListener;
    }

    public MainPageAdapter(List<String> mDataList, Context mContext) {
        this.mDataList = mDataList;
        this.mContext = mContext;
    }

    @Override
    public MainPageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_main_page_adapter, parent, false);
        return new MainPageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MainPageViewHolder holder, int position) {
        holder.tvItem.setText(mDataList.get(position));
        if (monRvItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = holder.getLayoutPosition();
                    monRvItemClickListener.itemClick(pos);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public static class MainPageViewHolder extends RecyclerView.ViewHolder {
        TextView tvItem;

        public MainPageViewHolder(View itemView) {
            super(itemView);
            tvItem = (TextView) itemView.findViewById(R.id.tv_item);
        }
    }
}
