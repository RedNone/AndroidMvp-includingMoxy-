package com.example.rednone.androidmvpincludingmoxy.DataLayer.Interfaces;
import com.example.rednone.androidmvpincludingmoxy.DataLayer.Models.AlbumModel;
import com.example.rednone.androidmvpincludingmoxy.DataLayer.Models.CommentModel;
import com.example.rednone.androidmvpincludingmoxy.DataLayer.Models.PhotoModel;
import com.example.rednone.androidmvpincludingmoxy.DataLayer.Models.PostModel;
import com.example.rednone.androidmvpincludingmoxy.DataLayer.Models.UserModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by RedNone on 20.01.2018.
 */

public interface JsonPlaceHolderApi {

    @GET("/posts")
    Call<List<PostModel>> getPosts();

    @GET("/comments")
    Call<List<CommentModel>> getComments(@Query("postId") int postId);

    @GET("/users")
    Call<List<UserModel>> getUsers();

    @GET("/albums")
    Call<List<AlbumModel>> getAlbums();

    @GET("/photos")
    Call<List<PhotoModel>> getPhotos(@Query("albumId") int albumId);
}
