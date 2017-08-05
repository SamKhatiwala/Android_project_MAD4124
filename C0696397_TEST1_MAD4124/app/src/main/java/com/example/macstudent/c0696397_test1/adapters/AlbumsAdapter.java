package com.example.macstudent.c0696397_test1.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.macstudent.c0696397_test1.R;
import com.example.macstudent.c0696397_test1.models.Albums;


import java.util.List;

/**
 * Created by moxdroid on 2017-07-31.
 */

public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.AlbumsViewHolder>{


    private List<Albums> mAlbumsArrayList;
    private Activity context;
    public AlbumsAdapter(Activity context, List<Albums> mAlbumsArrayList)
    {
        this.mAlbumsArrayList = mAlbumsArrayList;
        this.context = context;
    }

    @Override
    public AlbumsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.item_albums, parent, false);

        return new AlbumsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AlbumsViewHolder holder, int position) {
        Albums mAlbums = mAlbumsArrayList.get(position);
        holder.mTextViewTitle.setText(mAlbums.getTitle());
        Glide.with(context).load(mAlbums.getUrl()).thumbnail(1).into(holder.imageViewAlbum);
    }

    @Override
    public int getItemCount() {
        return mAlbumsArrayList.size();
    }



    static class AlbumsViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageViewAlbum;
        TextView mTextViewTitle;

        AlbumsViewHolder(View view)
        {
            super(view);
            imageViewAlbum = (ImageView) view.findViewById(R.id.imgAlbum);
            mTextViewTitle = (TextView) view.findViewById(R.id.txtTitle);

        }
    }
}