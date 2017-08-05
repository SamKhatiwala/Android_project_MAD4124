package com.example.macstudent.c0696397_test1.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.macstudent.c0696397_test1.PostDetailsActivity;
import com.example.macstudent.c0696397_test1.R;
import com.example.macstudent.c0696397_test1.models.Posts;

import java.util.List;

/**
 * Created by moxdroid on 2017-07-31.
 */

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostViewHolder>{


    List<Posts>mPostArrayList;
    public PostsAdapter(List<Posts> mPostArrayList)
    {
        this.mPostArrayList = mPostArrayList;
    }

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.item_posts, parent, false);

        return new PostViewHolder(parent.getContext(),itemView);
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        Posts mPosts = mPostArrayList.get(position);
        holder.mTextViewTitle.setText(mPosts.getTitle());
        holder.mTextViewDetails.setText(mPosts.getBody());
        holder.cvPosts.setTag(mPosts);
    }

    @Override
    public int getItemCount() {
        return mPostArrayList.size();
    }



    static class PostViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView mTextViewTitle;
        TextView mTextViewDetails;
        CardView cvPosts;
        Context context;

        PostViewHolder(Context context, View view)
        {
            super(view);
            this.context = context;
            mTextViewTitle = (TextView) view.findViewById(R.id.txtTitle);
            mTextViewDetails = (TextView) view.findViewById(R.id.txtDesc);
            cvPosts = (CardView) view.findViewById(R.id.cvPosts);
            cvPosts.setOnClickListener(this);
        }

        @Override
        public void onClick(final View view) {
            Posts mPosts = (Posts)view.getTag();
            Intent mIntent = new Intent(context, PostDetailsActivity.class);
            mIntent.putExtra("post",mPosts);
            context.startActivity(mIntent);
        }
    }
}