package com.lzp.retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.lzp.retrofit.net.BaseNetModel;
import com.lzp.retrofit.net.NetURL;
import com.lzp.retrofit.net.NetUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NetUtils.doRequest(NetUtils.getService(NetURL.class).getCall(), new Callback<BaseNetModel<TestModel>>() {
            @Override
            public void onResponse(Call<BaseNetModel<TestModel>> call, Response<BaseNetModel<TestModel>> response) {
                BaseNetModel<TestModel> body = response.body();
                int status = body.getStatus();
                String msg = body.getMsg();
                TestModel data = body.getData();
                Log.e("TAG", body.toString());
            }

            @Override
            public void onFailure(Call<BaseNetModel<TestModel>> call, Throwable t) {
                Log.e("TAG",t.getMessage());
            }
        });


    }
}
