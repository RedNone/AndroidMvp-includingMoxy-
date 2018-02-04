package com.example.rednone.androidmvpincludingmoxy.DataLayer.Managers;


import com.example.rednone.androidmvpincludingmoxy.DataLayer.Interfaces.JsonPlaceHolderApi;
import com.example.rednone.androidmvpincludingmoxy.DataLayer.Models.AlbumModel;
import com.example.rednone.androidmvpincludingmoxy.DataLayer.Models.CommentModel;
import com.example.rednone.androidmvpincludingmoxy.DataLayer.Models.PhotoModel;
import com.example.rednone.androidmvpincludingmoxy.DataLayer.Models.PostModel;
import com.example.rednone.androidmvpincludingmoxy.DataLayer.Models.UserModel;

import java.util.List;

import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by RedNone on 20.01.2018.
 */

public class ApiManager {

    private static String baseUrl = "https://jsonplaceholder.typicode.com";

    private static ApiManager instance;
    private static JsonPlaceHolderApi retrofit = null;

    public static synchronized ApiManager getInstance() {
        if (instance == null) {
            instance = new ApiManager();
            instance.createRetrofitInstance();
        }
        return instance;
    }

    private void createRetrofitInstance() {
            if (retrofit==null) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(baseUrl)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                        .create(JsonPlaceHolderApi.class);
            }
    }

    public void getPosts(Callback<List<PostModel>> callback) {
        retrofit.getPosts().enqueue(callback);
    }

    public void getComments(Callback<List<CommentModel>> callback, int postId) {
        retrofit.getComments(postId).enqueue(callback);
    }

    public void getAlbums(Callback<List<AlbumModel>> callback) {
        retrofit.getAlbums().enqueue(callback);
    }

    public void getPhotos(Callback<List<PhotoModel>> callback, int albumId) {
        retrofit.getPhotos(albumId).enqueue(callback);
    }

    public void getUsers(Callback<List<UserModel>> callback) {
        retrofit.getUsers().enqueue(callback);
    }
}
