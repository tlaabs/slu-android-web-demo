package com.demo.slu.demo.Service;

import com.demo.slu.demo.Request.UpdateInfo;
import com.demo.slu.demo.Request.UserInfo;
import com.demo.slu.demo.Request.UserLogin;

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

    //회원가입
    @POST("user/signup")
    Call<ResponseBody> signup(@Body UserInfo user);

    //아이디 & 패스워드로 로그인해서 토큰 가져오기
    @POST("user/login/idpwd")
    Call<ResponseBody> login(@Body UserLogin login);

    @POST("/user/update")
    Call<ResponseBody> update(@Header("Authorization") String authorization, @Body UpdateInfo updateInfo);
}
