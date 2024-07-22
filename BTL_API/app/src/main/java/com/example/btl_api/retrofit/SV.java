package com.example.btl_api.retrofit;

import com.example.btl_api.object.ChangePass;
import com.example.btl_api.object.Course;
import com.example.btl_api.object.HP;
import com.example.btl_api.object.KQDK;
import com.example.btl_api.object.LichThi;
import com.example.btl_api.object.SinhVien;
import com.example.btl_api.object.userPass;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface SV {
    @GET("/getUser")
    Call<ArrayList<userPass>> getName();
    @POST("/Admin/changePass")
    Call<ChangePass> ChangePass(@Body ChangePass changePass);
    @GET("/GetAll")
    Call<ArrayList<Course>> getAllCourse();
    @GET("/getDetailCourse/{id}")
    Call<ArrayList<HP>> getDetailCourse(@Path("id") String id);
    @POST("/Insert/KQDK")
    Call<KQDK> InsertKQDK(@Body KQDK kqdk);
    @POST("/Update/KQDK")
    Call<KQDK> UpdateKQDK(@Body String mahp);
    @GET("/GetKQDK/{id}")
    Call<ArrayList<HP>> get_KQDK_By_ID(@Path("id") String id);
    @GET("/GetLichHoc/{id}")
    Call<ArrayList<HP>> get_LichHoc(@Path("id") String id);
    @GET("/GetLichThi/{id}")
    Call<ArrayList<LichThi>> getLichThi(@Path("id") String id);
    @POST("/SinhVien/changeProfile")
    Call<SinhVien> ChangeProfile(@Body SinhVien sinhVien);
    @GET("/getInfoByID/{id}")
    Call<SinhVien> getInfoByID(@Path("id") String id);
    
}
