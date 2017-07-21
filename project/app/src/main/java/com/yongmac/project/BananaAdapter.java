package com.yongmac.project;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by yongmac on 2017. 7. 21..
 */

public class BananaAdapter extends RecyclerView.Adapter<BananaAdapter.ViewHolder> {
//어댑터 생성

    private List<MemberDTO> memberDTOs;
    Context context;

    ReqThread thread;

    public BananaAdapter(List<MemberDTO> Bananalist,Context context){
        memberDTOs = Bananalist;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //jsonitem.xml에 연결

        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_jsonitem,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //데이터 넣어주는 부분
        holder.rank.setText(memberDTOs.get(position).getRank());
        holder.Nm.setText(memberDTOs.get(position).getNm());
        Picasso.with(context).load(memberDTOs.get(position).getUrl()).into(holder.url);

    }

    @Override
    public int getItemCount() {
        //갯수 설
        return memberDTOs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView rank;
        TextView Nm;
        ImageView url;

        public ViewHolder(View itemView) {
            super(itemView);
            rank = (TextView)itemView.findViewById(R.id.textView);
            Nm = (TextView)itemView.findViewById(R.id.textView2);
            url = (ImageView)itemView.findViewById(R.id.iv);
        }
    }
}
