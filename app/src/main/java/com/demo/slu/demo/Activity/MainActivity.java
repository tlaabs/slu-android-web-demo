package com.demo.slu.demo.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.demo.slu.demo.R;


import com.demo.slu.demo.Retrofit.RetroCallback;
import com.demo.slu.demo.Retrofit.RetroClient;


public class MainActivity extends AppCompatActivity {
    final static String LOG = "ConnectionTEST";

    //Retrofit 객체 생성
    private RetroClient retroClient;

    private Button profileUpdateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retroClient = RetroClient.getInstance(this).createBaseApi();

        init();


        profileUpdateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = "01022345690";
                String newProfile = "행복하다";
                retroClient.updateProfile(id,newProfile, new RetroCallback() {

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
                            Toast.makeText(getApplicationContext(),"성공",Toast.LENGTH_SHORT).show();
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
        profileUpdateBtn = findViewById(R.id.profileUpdateBtn);
    }
}
