package com.example.macstudent.c0696397_test1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;


import com.example.macstudent.c0696397_test1.adapters.PostsAdapter;
import com.example.macstudent.c0696397_test1.models.Posts;
import com.example.macstudent.c0696397_test1.network.ApiClient;
import com.example.macstudent.c0696397_test1.network.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostsActivity extends Activity implements SearchView.OnQueryTextListener{

    private static final String TAG = PostsActivity.class.getCanonicalName();
    List<Posts>mPostsList;
    RecyclerView mRecyclerView;
    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);

        mRecyclerView = (RecyclerView)findViewById(R.id.rvDataList);

        ApiInterface mApiInterface =
                ApiClient.getClient().create(ApiInterface.class);

        Call<List<Posts>> apiServiceData = mApiInterface.getAllPosts();

        apiServiceData.enqueue(new Callback<List<Posts>>()
        {
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response)
            {
                mPostsList = response.body();
                PostsAdapter mPostsAdapter = new PostsAdapter(mPostsList);
                mRecyclerView.setHasFixedSize(true);
                //LinearLayoutManager llm = new LinearLayoutManager(PostsActivity.this);
                //llm.setOrientation(LinearLayoutManager.HORIZONTAL);
                //llm.setOrientation(LinearLayoutManager.VERTICAL);
                //mRecyclerView.setLayoutManager(llm);
                //GridLayoutManager gridLayoutManager = new GridLayoutManager(PostsActivity.this, 3);
                //mRecyclerView.setLayoutManager(gridLayoutManager);
                mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
                mRecyclerView.setAdapter(mPostsAdapter);
                Log.d(TAG, "Success");

            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t)
            {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my_menu, menu);//Menu Resource, Menu
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_album:
                Intent mIntent = new Intent(PostsActivity.this, AlbumsActivity.class);
                mIntent.putExtra("albumId",1);
                startActivity(mIntent);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onQueryTextChange(String query) {
        // Here is where we are going to implement the filter logic
        return false;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {

        // Close the soft keyboard from a Test
        ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(searchView.getWindowToken(), 0);
        //getRecipeSearch(query);
        return true;
    }
}
