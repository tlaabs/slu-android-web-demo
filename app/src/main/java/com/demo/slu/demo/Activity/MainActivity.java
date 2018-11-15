package com.demo.slu.demo.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.demo.slu.demo.Object.UserVO;
import com.demo.slu.demo.R;
import com.demo.slu.demo.Request.GetUserDTO;

import com.demo.slu.demo.Retrofit.RetroCallback;
import com.demo.slu.demo.Retrofit.RetroClient;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import okhttp3.Response;
import okhttp3.ResponseBody;

public class MainActivity extends AppCompatActivity {
    final static String LOG = "ConnectionTEST";

    //Retrofit 객체 생성
    private RetroClient retroClient;

    private Button getUserBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retroClient = RetroClient.getInstance(this).createBaseApi();

        init();


        getUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetUserDTO dto = new GetUserDTO();
                dto.setUserid("01022345690");
                retroClient.getUSer(dto, new RetroCallback() {

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
                            JSONObject jObj1 = new JSONObject(responseJSON);
                            JSONObject jObj2 = jObj1.getJSONObject("results");
                            String userid = jObj2.getString("userid");
                            String userpwd = jObj2.getString("userpwd");
                            String state = jObj2.getString("state");
                            String emotion = jObj2.getString("emotion");
                            String username = jObj2.getString("username");
                            UserVO user = new UserVO(userid,userpwd,state,emotion,username);
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
        getUserBtn = findViewById(R.id.getUserBtn);
    }
}
