package com.demo.slu.demo.Service;

import com.demo.slu.demo.Object.HeartDTO;
import com.demo.slu.demo.Request.GetUserDTO;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface RetroBaseApiService {

    /**
     * API 정의
     * 여기서 작성한 메서드를 RetroClient 클래스에도 작성해줘야한다.
     */

    final String Base_URL = "http://devsim0.cafe24.com/";

    //하트보내기
    @POST("user/send/heart")
    Call<ResponseBody> sendHeart(@Body HeartDTO dto);
}
