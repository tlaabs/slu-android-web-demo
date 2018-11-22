package com.demo.slu.demo.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.demo.slu.demo.Object.HeartDTO;
import com.demo.slu.demo.R;
import com.demo.slu.demo.Request.GetUserDTO;

import com.demo.slu.demo.Retrofit.RetroCallback;
import com.demo.slu.demo.Retrofit.RetroClient;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Response;
import okhttp3.ResponseBody;

public class MainActivity extends AppCompatActivity {
    final static String LOG = "ConnectionTEST";

    //Retrofit 객체 생성
    private RetroClient retroClient;

    private Button getHeartBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retroClient = RetroClient.getInstance(this).createBaseApi();

        init();


        getHeartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String receiver_id = "01050345566";
                retroClient.getHeart(receiver_id, new RetroCallback() {

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
                            ArrayList<HeartDTO> res = (ArrayList<HeartDTO>)receivedData;
                            Toast.makeText(getApplicationContext(),"성공! 받은 리스트 수 : " + res.size(),Toast.LENGTH_SHORT).show();
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
        getHeartBtn = findViewById(R.id.getHeart);
    }
}
