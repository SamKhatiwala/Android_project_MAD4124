package com.example.macstudent.c0696397_test1;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;


import com.example.macstudent.c0696397_test1.adapters.CommentsAdapter;
import com.example.macstudent.c0696397_test1.models.Comments;
import com.example.macstudent.c0696397_test1.models.Posts;
import com.example.macstudent.c0696397_test1.network.ApiClient;
import com.example.macstudent.c0696397_test1.network.ApiInterface;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostDetailsActivity extends Activity {

    Posts mPost;
    @BindView(R.id.txtPostTitle)
    TextView txtPostTitle;
    @BindView(R.id.txtPostBody)
    TextView txtPostBody;
    @BindView(R.id.cvPosts)
    CardView cvPosts;
    @BindView(R.id.rvCommentList)
    RecyclerView rvCommentList;


    private static final String TAG = PostDetailsActivity.class.getCanonicalName();
    List<Comments> mCommentsList;
    CommentsAdapter mCommentsAdapter;
    @BindView(R.id.txtTotalComments)
    TextView txtTotalComments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_details);
        ButterKnife.bind(this);

        mPost = (Posts) getIntent().getParcelableExtra("post");

        initPostData();
        getComments();

    }



    private void initPostData() {
        txtPostTitle.setText("Title : " + mPost.getTitle());
        txtPostBody.setText(mPost.getBody());
    }

    private void getComments() {
        ApiInterface mApiInterface =
                ApiClient.getClient().create(ApiInterface.class);

        Call<List<Comments>> apiServiceData = mApiInterface.getCommentsByPostId(mPost.getId());

        apiServiceData.enqueue(new Callback<List<Comments>>() {
            @Override
            public void onResponse(Call<List<Comments>> call, Response<List<Comments>> response) {
                mCommentsList = response.body();

                //Formatting  SubString
                String comment = "Comments (" + mCommentsList.size() + ")";
                Spannable wordToSpan = new SpannableString(comment);
                wordToSpan.setSpan(new ForegroundColorSpan(Color.BLUE), 10, comment.length()-1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                txtTotalComments.setText(wordToSpan);
                mCommentsAdapter = new CommentsAdapter(mCommentsList);
                rvCommentList.setHasFixedSize(true);
                LinearLayoutManager llm = new LinearLayoutManager(PostDetailsActivity.this);
                rvCommentList.setLayoutManager(llm);
                rvCommentList.setAdapter(mCommentsAdapter);
            }

            @Override
            public void onFailure(Call<List<Comments>> call, Throwable t) {

            }
        });
    }
}
