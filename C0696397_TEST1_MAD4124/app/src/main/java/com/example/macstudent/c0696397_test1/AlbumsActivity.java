package com.example.macstudent.c0696397_test1;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;


import com.example.macstudent.c0696397_test1.adapters.AlbumsAdapter;
import com.example.macstudent.c0696397_test1.models.Albums;
import com.example.macstudent.c0696397_test1.network.ApiClient;
import com.example.macstudent.c0696397_test1.network.ApiInterface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumsActivity extends Activity {

    private static final String TAG = AlbumsActivity.class.getCanonicalName();
    List<Albums> albumsList;
    RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);

        this.setTitle("Album Images");
        int albumId = getIntent().getIntExtra("albumId",0);

        mRecyclerView = (RecyclerView)findViewById(R.id.rvAlbums);

        ApiInterface mApiInterface =
                ApiClient.getClient().create(ApiInterface.class);

        //Retrofit Query Parameter
        Map<String, String>mStringMap = new HashMap<>();
        mStringMap.put("albumId",String.valueOf(albumId));
        Call<List<Albums>> apiServiceData = mApiInterface.getAlbumsById(mStringMap);


        apiServiceData.enqueue(new Callback<List<Albums>>()
        {
            @Override
            public void onResponse(Call<List<Albums>> call, Response<List<Albums>> response)
            {
                albumsList = response.body();
                AlbumsAdapter mAlbumsAdapter = new AlbumsAdapter(AlbumsActivity.this,albumsList);
                mRecyclerView.setHasFixedSize(true);
                LinearLayoutManager llm = new LinearLayoutManager(AlbumsActivity.this);
                //llm.setOrientation(LinearLayoutManager.HORIZONTAL);
                //llm.setOrientation(LinearLayoutManager.VERTICAL);
                mRecyclerView.setLayoutManager(llm);
                //GridLayoutManager gridLayoutManager = new GridLayoutManager(PostsActivity.this, 3);
                //mRecyclerView.setLayoutManager(gridLayoutManager);
                //mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
                mRecyclerView.setAdapter(mAlbumsAdapter);
                Log.d(TAG, "Success");

            }

            @Override
            public void onFailure(Call<List<Albums>> call, Throwable t)
            {

            }
        });
    }
}
