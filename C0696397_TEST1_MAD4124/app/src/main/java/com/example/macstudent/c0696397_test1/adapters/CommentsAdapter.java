package com.example.macstudent.c0696397_test1.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.macstudent.c0696397_test1.R;
import com.example.macstudent.c0696397_test1.models.Comments;

import java.util.List;

/**
 * Created by moxdroid on 2017-07-31.
 */

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.CommentsViewHolder>
{

    private List<Comments> commentsList;
    public CommentsAdapter(List<Comments> mPostArrayList)
    {
        this.commentsList = mPostArrayList;
    }

    @Override
    public CommentsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.item_comments, parent, false);

        return new CommentsViewHolder(parent.getContext(),itemView);
    }

    @Override
    public void onBindViewHolder(CommentsViewHolder holder, int position) {
        Comments mComments = commentsList.get(position);
        holder.mTextViewTitle.setText(mComments.getName());
        holder.mTextViewEmail.setText(mComments.getEmail());
        holder.mTextViewDetails.setText(mComments.getBody());

        holder.mImageViewShared.setTag(mComments);

    }

    @Override
    public int getItemCount() {
        return commentsList.size();
    }

    static class CommentsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView mTextViewTitle;
        TextView mTextViewEmail;
        TextView mTextViewDetails;
        ImageView mImageViewShared;
        Context mContext;

        CommentsViewHolder(Context context, View view)
        {
            super(view);
            this.mContext = context;
            mTextViewTitle = (TextView) view.findViewById(R.id.txtTitle);
            mTextViewEmail = (TextView) view.findViewById(R.id.txtEmail);
            mTextViewDetails = (TextView) view.findViewById(R.id.txtDesc);
            mImageViewShared = (ImageView)view.findViewById(R.id.imgShared);
            mImageViewShared.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            Comments mComments = (Comments)v.getTag();
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, mComments.getBody());
            sendIntent.setType("text/plain");
            mContext.startActivity(Intent.createChooser(sendIntent, "Shared via...."));
        }
    }
}