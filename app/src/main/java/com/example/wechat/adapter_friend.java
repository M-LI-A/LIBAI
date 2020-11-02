package com.example.wechat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class adapter_friend extends RecyclerView.Adapter<adapter_friend.ExpandViewHolder>{
    private List<String>list;
    private Context context;
    private View inflater;

    private int expandedPosition = -1;
    private ExpandViewHolder myViewHolder;

    public adapter_friend(Context context, List<String> list) {
        this.context=context;
        this.list=list;
    }

    @Override
    public adapter_friend.ExpandViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        inflater= LayoutInflater.from(context).inflate(R.layout.rcv2_item,parent,false);
        ExpandViewHolder expandviewholder=new ExpandViewHolder(inflater);
        return expandviewholder;
    }

    @Override
    public void onBindViewHolder(final adapter_friend.ExpandViewHolder holder, int position) {
        holder.team_Team.setText(list.get(position));
        holder.team_TeamChild.setText(list.get(position) + "的联系方式");

        final boolean isExpanded = position == expandedPosition;
        holder.rclChild.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
        holder.rclParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myViewHolder != null) {
                    myViewHolder.rclChild.setVisibility(View.GONE);
                    notifyItemChanged(expandedPosition);
                }
                expandedPosition = isExpanded ? -1 : holder.getAdapterPosition();
                myViewHolder = isExpanded ? null : holder;
                notifyItemChanged(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() { return list.size();}

    class ExpandViewHolder extends RecyclerView.ViewHolder{
        RelativeLayout rclParent, rclChild;
        TextView team_Team, team_TeamChild;
        public ExpandViewHolder(View itemView) {
            super(itemView);
            rclParent = itemView.findViewById(R.id.rcl_parent);
            rclChild = itemView.findViewById(R.id.rcl_child);
            team_Team = itemView.findViewById(R.id.team_team);
            team_TeamChild = itemView.findViewById(R.id.team_team_child);
        }
    }
}
