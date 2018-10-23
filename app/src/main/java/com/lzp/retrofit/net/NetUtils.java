package com.lzp.retrofit.net;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
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
                            .addConverterFactory(GsonConverterFactory.create())
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
                //.addInterceptor(logInterceptor)//需要拦截器可调用此方法
               // .cache(cache)//需要缓存可调用此方法
                .build();
    }

    public static<E> E getService(Class<E> clazz){
        E e = getRetrofit().create(clazz);
        return e;
    }
    public static<T> void doRequest(Call<T> request,Callback <T> callback){
        request.enqueue(callback);
    }
}
