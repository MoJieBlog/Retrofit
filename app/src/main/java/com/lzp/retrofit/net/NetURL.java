package com.lzp.retrofit.net;

import com.lzp.retrofit.TestModel;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * @author Li Xiaopeng
 * @date 2018/10/22
 */
public interface NetURL {
    @GET("ajax.php?a=fy&f=auto&t=auto&w=hello%20world")
    Call<BaseNetModel<TestModel>> getCall();

    /************************以下为模拟接口*************************/

    /**
     * 带参数的get请求
     * @param parameter
     * @return
     */
    @GET("text")
    Call<BaseNetModel> TestWithParameter(@Query("parameter") String parameter);

    /**
     * 带多个参数的get请求
     * @param parameter
     * @return
     */

    @GET("text")
    Call<BaseNetModel> TestWithMultiParameter(@Query("parameter") String parameter
            ,@Query("parameter1") String parameter1);


    /**
     * 带多个参数的get请求
     * @param parameter
     * @return
     */

    @GET("text")
    Call<BaseNetModel> TestWithMultiParameter(@QueryMap Map<String ,String> parameter);

    /********************************表单请求*****************************************/
    @FormUrlEncoded
    @POST
    Call<BaseNetModel> formPost(@Field("id") String id);

    @FormUrlEncoded
    @POST
    Call<BaseNetModel> formPost(@FieldMap Map<String,String> map);
}
