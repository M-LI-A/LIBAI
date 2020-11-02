package com.example.wechat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class adapter_weixin extends RecyclerView .Adapter<adapter_weixin.SwipeViewHolder> implements ItemTouchHelperListener{
    private List<String>list;
    private Context context;
    private View inflater;

    public adapter_weixin(Context context, List<String> list) {
        this.context=context;
        this.list=list;
    }

    @Override
    public adapter_weixin.SwipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        inflater= LayoutInflater.from(context).inflate(R.layout.rcv1_item,parent,false);
        SwipeViewHolder swipeviewholder=new SwipeViewHolder(inflater);
        return swipeviewholder;
    }

    @Override
    public void onBindViewHolder(adapter_weixin.SwipeViewHolder holder, int position) {
        holder.teamContent.setText(list.get(position));
    }

    @Override
    public int getItemCount() {return list.size();}

    @Override
    public void onItemDismiss(int position) {
        if (position < 0 || position > getItemCount()) {
            return;
        }

        list.remove(position);
        notifyItemRemoved(position);

        // 解决 RecyclerView 删除 Item 导致位置错乱的问题
        if (position != list.size()) {
            notifyItemRangeChanged(position, list.size() - position);
        }
    }

    public class SwipeViewHolder extends RecyclerView.ViewHolder{
        TextView teamContent;

        public SwipeViewHolder(View itemView) {
            super(itemView);
            teamContent = itemView.findViewById(R.id.team_content);
        }
    }
}
