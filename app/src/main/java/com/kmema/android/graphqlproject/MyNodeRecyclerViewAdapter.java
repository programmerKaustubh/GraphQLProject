package com.kmema.android.graphqlproject;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class MyNodeRecyclerViewAdapter extends RecyclerView.Adapter<MyNodeRecyclerViewAdapter.ViewHolder> {


    ArrayList<String> mList;
    private static NodeClickListener nodeClickListener;
    private ArrayList<Integer> colorList;
    MyNodeRecyclerViewAdapter(ArrayList<String> mList, ArrayList<Integer> colorList, NodeClickListener mainActivity) {
        this.mList = mList;
        nodeClickListener = mainActivity;
        this.colorList = colorList;
    }

    @Override
    public MyNodeRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.node_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyNodeRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.mNodeName.setText(mList.get(position));
        holder.mNodeName.setBackgroundResource(colorList.get(position));
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView mNodeName;
        ViewHolder(View itemView) {
            super(itemView);
            mNodeName = itemView.findViewById(R.id.mTextViewNode);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            nodeClickListener.recyclerViewClickListener(view, getLayoutPosition());
            Log.e("ERROR","CLICKED");
        }
    }
}
