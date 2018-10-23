package com.lzp.retrofit.net;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Li Xiaopeng
 * @date 2018/10/22
 */
public class NetUtils {

    private static Retrofit retrofit = null;
    public static final String BASE_URL = "http://fy.iciba.com/";

    /**
     * 获取retrofit实例
     * 更多方法{@link Retrofit}
     * @return
     */
    private static Retrofit getRetrofit(){
        if (retrofit==null){
            synchronized (NetUtils.class){
                if (retrofit==null){
                    retrofit = new Retrofit.Builder()
                            .client(getNetClient())
                            .baseUrl(BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())//数据转换器工厂的集合
                           // .addCallAdapterFactory()//网络请求适配器工厂的集合
                           // .callbackExecutor()//回调方法执行器
                            //.callFactory()//网络请求工厂
                            .build();
                }
            }
        }
        return retrofit;
    }

    /**
     *
     * 获取网络client，这里使用okhttp
     * 更多方法{@link OkHttpClient}
     * @return
     */
    private static OkHttpClient getNetClient() {
        return new OkHttpClient.Builder()
                .readTimeout(5000, TimeUnit.MILLISECONDS)
                .connectTimeout(5000, TimeUnit.MILLISECONDS)
                .writeTimeout(5000, TimeUnit.MILLISECONDS)
                //.addNetworkInterceptor()//需要网络拦截器可调用此方法
                //.addInterceptor(logInterceptor)//添加应用拦截器
               // .cache(cache)//需要缓存可调用此方法
                .build();
    }

    public static<E> E getService(Class<E> clazz){
        E e = getRetrofit().create(clazz);
        return e;
    }

    /**
     * 异步请求
     * @param request
     * @param callback
     * @param <T>
     */
    public static<T> void doRequest(Call<T> request,Callback <T> callback){
        request.enqueue(callback);
    }

    /**
     * 同步请求，不可以在主线程中使用
     * @param request
     * @param callback
     * @param <T>
     */
    public static<T> void doExecute(Call<T> request,Callback <T> callback){
        try {
            Response<T> execute = request.execute();
            boolean successful = execute.isSuccessful();
            if (successful){
                callback.onResponse(request,execute);
            }else{
                callback.onFailure(request,new RuntimeException(execute.message()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
