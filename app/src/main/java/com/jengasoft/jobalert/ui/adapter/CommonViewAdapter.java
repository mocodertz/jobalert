package com.jengasoft.jobalert.ui.adapter;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jengasoft.jobalert.R;
import com.jengasoft.jobalert.api.model.Document;
import com.jengasoft.jobalert.api.model.ListItem;

import java.util.List;

/**
 * Created by MoCoder#1956# on 9/29/2017.
 */

public class CommonViewAdapter extends RecyclerView.Adapter<CommonViewAdapter.ViewHolder> {

    private List<ListItem> listItems;
    private Context mContext;

    public CommonViewAdapter(List<ListItem> listItems, Context mContext) {
        this.listItems = listItems;
        this.mContext = mContext;
    }

    @Override
    public CommonViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.edu_resp_skill_item, null, false));
    }

    @Override
    public void onBindViewHolder(CommonViewAdapter.ViewHolder holder, int position) {
        ListItem listItem = listItems.get(position);
        holder.list_item.setText(listItem.getItemText());
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        AppCompatTextView list_item;
        View small_dot_view;

        public ViewHolder(View itemView) {
            super(itemView);

            list_item = (AppCompatTextView) itemView.findViewById(R.id.list_item);
            small_dot_view = (View) itemView.findViewById(R.id.bullet_icon);
        }
    }
}
