package com.sk.recyclerviewmultipleviewtype.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sk.recyclerviewmultipleviewtype.R;
import com.sk.recyclerviewmultipleviewtype.activity.MainActivity;
import com.sk.recyclerviewmultipleviewtype.model.Model;
import com.sk.recyclerviewmultipleviewtype.util.AppConstant;

import java.util.List;

/*
 * Created by Sambhaji Karad on 13-Feb-18
 * Mobile 9423476192
 * Email sambhaji2134@gmail.com/
*/

public class MultiViewTypeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Model> newItemList;
    MainActivity mActivity;

    public MultiViewTypeAdapter(List<Model> data, MainActivity mActivity) {
        this.newItemList = data;
        this.mActivity = mActivity;
    }

    @Override
    public int getItemViewType(int position) {
        switch (newItemList.get(position).getViewType()) {
            case 0:
                return AppConstant.TYPE_HEADER;
            case 1:
                return AppConstant.TYPE_CHILD;
            default:
                return -1;
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int listPosition) {
        Model model = newItemList.get(listPosition);
        if (model != null) {
            switch (model.getViewType()) {
                case AppConstant.TYPE_HEADER:
                    ((TextTypeViewHolder) holder).textViewName.setText(model.getCollegeName());
                    break;
                case AppConstant.TYPE_CHILD:
                    ((ImageTypeViewHolder) holder).textViewName.setText(model.getCollegeName());
                    ((ImageTypeViewHolder) holder).imageViewItem.setImageResource(model.getImageUrl());
                    break;
            }
        }
    }

    @Override
    public int getItemCount() {
        return newItemList.size();
    }

    public class TextTypeViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;

        private TextTypeViewHolder(View itemView) {
            super(itemView);

            this.textViewName = (TextView) itemView.findViewById(R.id.textViewName);
        }
    }

    public class ImageTypeViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        ImageView imageViewItem;

        private ImageTypeViewHolder(View itemView) {
            super(itemView);

            this.textViewName = (TextView) itemView.findViewById(R.id.textViewName);
            this.imageViewItem = (ImageView) itemView.findViewById(R.id.imageViewItem);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case AppConstant.TYPE_HEADER:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_header, parent, false);
                return new TextTypeViewHolder(view);
            case AppConstant.TYPE_CHILD:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_child, parent, false);
                return new ImageTypeViewHolder(view);
        }
        return null;
    }
}
