package com.jengasoft.jobalert.ui.adapter;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jengasoft.jobalert.R;
import com.jengasoft.jobalert.api.model.Document;
import com.jengasoft.jobalert.ui.helper.PDFHelper;

import java.util.List;

/**
 * Created by MoCoder#1956# on 9/23/2017.
 */

public class DocumentAdapter extends RecyclerView.Adapter<DocumentAdapter.ViewHolder> {
    private List<Document> sample_document_list;
    private Context mContext;

    public DocumentAdapter(List<Document> sample_document_list, Context mContext) {
        this.sample_document_list = sample_document_list;
        this.mContext = mContext;
    }

    @Override
    public DocumentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.sample_document_item_view, null, false));
    }

    @Override
    public void onBindViewHolder(DocumentAdapter.ViewHolder holder, int position) {
        Document document = sample_document_list.get(position);
        holder.title.setText(document.getTitle());
        holder.fileUrl.setText(document.getFileUrl());
    }

    @Override
    public int getItemCount() {
        return sample_document_list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        AppCompatTextView title;
        AppCompatTextView fileUrl;

        public ViewHolder(View itemView) {
            super(itemView);

            title = (AppCompatTextView) itemView.findViewById(R.id.document_file_name);
            fileUrl = (AppCompatTextView) itemView.findViewById(R.id.file_url);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContext, title.getText(), Toast.LENGTH_LONG).show();
                }
            });
        }

        @Override
        public void onClick(View view) {
            if(view.isClickable()){
                Toast.makeText(mContext, "View Clicked", Toast.LENGTH_LONG).show();
            }
            AppCompatTextView appCompatTextView = (AppCompatTextView) view.findViewById(R.id.file_url);
            String file_url = (String) appCompatTextView.getText();

            PDFHelper.showPDFUrl(mContext, file_url);
        }
    }
}
