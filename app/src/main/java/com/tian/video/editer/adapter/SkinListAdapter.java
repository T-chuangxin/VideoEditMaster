package com.tian.video.editer.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tian.video.editer.R;

import java.util.List;

/**
 * 项目名称：VideoEditMaster
 * 类描述：
 * 创建人：TCX
 * 创建时间：2017/9/20 10:47
 * 修改人：TCX
 * 修改备注：
 */

public class SkinListAdapter  extends RecyclerView.Adapter<SkinListAdapter.ViewHolder>{


    private Context mContext;
    private List<String> mList;
    private LayoutInflater mLayoutInflater;


    public SkinListAdapter(Context context,List<String> list){
        mLayoutInflater = LayoutInflater.from(context);
        this.mContext=context;
        this.mList=list;

    }



    @Override
    public SkinListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view=mLayoutInflater.inflate(R.layout.item_skin,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return mList==null?0:mList.size();
    }

    @Override
    public void onBindViewHolder(SkinListAdapter.ViewHolder holder, int position) {


        holder.cardName.setText(mList.get(position));
//        holder.cardShow.setBackgroundColor(position==0?R.color.:"棕色");


    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        CardView cardShow;
        TextView cardName;

        public ViewHolder(View itemView) {
            super(itemView);

            cardShow = (CardView) itemView.findViewById(R.id.cv_show);
            cardName = (TextView)itemView.findViewById(R.id.tv_card_name);


        }
    }










}
