package com.lzp.retrofit.net;

import com.lzp.retrofit.TestModel;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author Li Xiaopeng
 * @date 2018/10/22
 */
public interface NetURL {
    @GET("ajax.php?a=fy&f=auto&t=auto&w=hello%20world")
    Call<BaseNetModel<TestModel>> getCall();
}
