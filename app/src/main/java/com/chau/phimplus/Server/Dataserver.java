package com.chau.phimplus.Server;

import com.chau.phimplus.Models.TaiKhoan;
import com.chau.phimplus.ui.movie_detail.LichChieu.Models.Branch;
import com.chau.phimplus.ui.movie_detail.LichChieu.Models.Cinema;
import com.chau.phimplus.ui.movie_detail.LichChieu.Models.Screening;
import com.chau.phimplus.ui.movie_detail.LichChieu.Models.Seat;
import com.chau.phimplus.ui.movie_detail.comment.models.Comment;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Dataserver {

	//CALL API Login.php
    @GET("login.php")
    Call<List<TaiKhoan>> getTaiKhoan();

    @POST("register.php")
    @FormUrlEncoded
    Call<List<TaiKhoan>> savePost(
            @Field("Phone") String Phone,
            @Field("Password") String Password
    );


    //GET Comments
    @POST("get-comment.php")
    @FormUrlEncoded
    Call<ArrayList<Comment>> getComment(
            @Field("key") String movieid
    );

    // GET Branch
    @POST("get-branch.php")
    Call<ArrayList<Branch>> getBranch();

    @POST("get-branch.php")
    @FormUrlEncoded
    Call<ArrayList<Branch>> getBranch(
            @Field("movieid") String movieId
    );


    //GET Cinemas
    @POST("get-cinema.php")
    @FormUrlEncoded
    Call<ArrayList<Cinema>> getCinema(
            @Field("key") String branchAddress
    );
    @POST("get-cinema.php")
    @FormUrlEncoded
    Call<ArrayList<Cinema>> getCinema(
            @Field("movieid") String movieId,
            @Field("key") String branchAddress
    );

    //GET Screenings
    @POST("get-screening.php")
    @FormUrlEncoded
    Call<ArrayList<Screening>> getSreening(
            @Field("cinemaid") String cinemaId,
            @Field("movieid") String MovieId
    );

    //GET Seats
    @POST("get-seat.php")
    @FormUrlEncoded
    Call<ArrayList<Seat>> getSeat(
            @Field("key") String cinemaId
    );
}
