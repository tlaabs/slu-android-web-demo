package com.demo.slu.demo.Service;



import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RetroBaseApiService {

    /**
     * API 정의
     * 여기서 작성한 메서드를 RetroClient 클래스에도 작성해줘야한다.
     */

    final String Base_URL = "http://devsim0.cafe24.com/";

    //하트리스트 받기
    @GET("user/emotion")
    Call<ResponseBody> updateProfile(@Query("id") String id, @Query("state") String state);
}
