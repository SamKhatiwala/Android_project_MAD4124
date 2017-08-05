package com.example.macstudent.c0696397_test1.network;



import com.example.macstudent.c0696397_test1.models.Albums;
import com.example.macstudent.c0696397_test1.models.Comments;
import com.example.macstudent.c0696397_test1.models.Posts;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * Created by moxdroid on 2017-07-31.
 */

public interface ApiInterface {

    @GET("/posts?userId=1")
    Call<List<Posts>> getAllPosts();

    @GET("/photos")
    Call<List<Albums>> getAlbumsById(@QueryMap(encoded = true) Map<String, String> stringMap);

    @GET("/posts/{postId}/comments")
    Call<List<Comments>> getCommentsByPostId(@Path("postId") long postId);
}
