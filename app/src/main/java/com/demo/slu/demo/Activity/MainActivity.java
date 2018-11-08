package com.demo.slu.demo.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.demo.slu.demo.R;
import com.demo.slu.demo.Request.UpdateInfo;
import com.demo.slu.demo.Request.UserInfo;
import com.demo.slu.demo.Request.UserLogin;
import com.demo.slu.demo.Retrofit.RetroCallback;
import com.demo.slu.demo.Retrofit.RetroClient;

import okhttp3.Response;
import okhttp3.ResponseBody;

public class MainActivity extends AppCompatActivity {
    final static String LOG = "ConnectionTEST";

    //Retrofit 객체 생성
    private RetroClient retroClient;

    private Button signupBtn;
    private Button loginBtn;
    private Button updateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retroClient = RetroClient.getInstance(this).createBaseApi();

        init();

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //가입정보
                UserInfo user = new UserInfo("test@naver.com","행복","test01","testuser","test00");
                retroClient.signup(user, new RetroCallback() {

                    /*
                    응답 오류
                    EX: 회원가입을 했는데 아이디가 중복인 경우
                     */
                    @Override
                    public void onError(Throwable t) {
                        Log.d(LOG, "에러 : " + t.toString());
                    }

                    @Override
                    public void onSuccess(int code, Object receivedData) {
                        try {
                            Log.d(LOG, "성공");
                            ResponseBody body = ((ResponseBody) receivedData);
                            String responseJSON = body.string();
                            //responseJSON JSON을 분석해서 처리하는 코드 작성.
                        }catch(Exception e){}
                    }

                    @Override
                    public void onFailure(int code) {
                        Log.d(LOG,"실패");
                    }
                });
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserLogin user = new UserLogin("test01","test00");
                retroClient.login(user, new RetroCallback() {

                    /*
                    응답 오류
                     */
                    @Override
                    public void onError(Throwable t) {
                        Log.d(LOG, "에러 : " + t.toString());
                    }

                    @Override
                    public void onSuccess(int code, Object receivedData) {
                        try {
                            Log.d(LOG, "성공");
                            ResponseBody body = ((ResponseBody) receivedData);
                            String responseJSON = body.string();
                            //responseJSON JSON을 분석해서 처리하는 코드 작성.

                            /*
                            로그인인 경우에는 result로 토큰을 받음
                            이 토큰은 사용자를 인증하는데 사용되므로 반드시 저장해야함. Preference 사용하면 좋을듯?
                             */
                            Log.d(LOG,responseJSON);
                        }catch(Exception e){}
                    }

                    @Override
                    public void onFailure(int code) {
                        Log.d(LOG,"실패");
                    }
                });
            }
        });

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserLogin user = new UserLogin("test01","test00");
                //아이디 비번 대신 사용하는 토큰
                String authorization = "Bearer " + "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0MDEiLCJleHAiOjE1NDIyNzUyMDAsImlhdCI6MTU0MTY3NTIwMH0.Afam6eswxtzJtBY746rFOAQ2qQHBKrNqy-oSebcwgkpHAhCS9jzG8dskVCVf_Z4uLHK4x5NaVD7y0nN5HET7Kw";

                //새로운 패스워드
                UpdateInfo updateInfo = new UpdateInfo("123","123");
                retroClient.update(authorization, updateInfo, new RetroCallback() {

                    /*
                    응답 오류
                     */
                    @Override
                    public void onError(Throwable t) {
                        Log.d(LOG, "에러 : " + t.toString());
                    }

                    @Override
                    public void onSuccess(int code, Object receivedData) {
                        try {
                            Log.d(LOG, "성공");
                            ResponseBody body = ((ResponseBody) receivedData);
                            String responseJSON = body.string();
                            //responseJSON JSON을 분석해서 처리하는 코드 작성.

                            /*
                            로그인인 경우에는 result로 토큰을 받음
                            이 토큰은 사용자를 인증하는데 사용되므로 반드시 저장해야함. Preference 사용하면 좋을듯?
                             */
                            Log.d(LOG,responseJSON);
                        }catch(Exception e){}
                    }

                    @Override
                    public void onFailure(int code) {
                        Log.d(LOG,"실패");
                    }
                });
            }
        });

    }


    private void init(){
        signupBtn = findViewById(R.id.signupBtn);
        loginBtn = findViewById(R.id.loginBtn);
        updateBtn = findViewById(R.id.updateBtn);
    }
}
