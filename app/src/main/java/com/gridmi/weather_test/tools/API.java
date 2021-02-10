package com.gridmi.weather_test.tools;

import android.os.Handler;
import android.os.Looper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.gridmi.weather_test.Constants;
import com.gridmi.weather_test.dtos.CityDto;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class API {

    public static OkHttpClient client = new OkHttpClient.Builder().addInterceptor(chain -> {
        HttpUrl.Builder urlBuilder = chain.request().url().newBuilder();
        urlBuilder.addQueryParameter("appid", Constants.KEY);
        return chain.proceed(chain.request().newBuilder().url(urlBuilder.build()).build());
    }).addNetworkInterceptor(chain -> {

        Response response = chain.proceed(chain.request());

        CacheControl cacheControl = new CacheControl.Builder()
                .maxAge(1, TimeUnit.MINUTES)
                .build();

        return response.newBuilder()
                .removeHeader("Pragma")
                .removeHeader("Cache-Control")
                .header("Cache-Control", cacheControl.toString())
                .build();

    }).build();

    public static void loadForName(String name, OnSuccess<CityDto> onSuccess, @Nullable OnFailed onFailed) {

        final HttpUrl.Builder builder = Objects.requireNonNull(HttpUrl.parse(Constants.getHandler("weather"))).newBuilder();
        builder.addEncodedQueryParameter("q", name);

        client.newCall(new Request.Builder().url(builder.build()).build()).enqueue(new CallBack<CityDto>(CityDto.class, onFailed) {
            @Override
            public void onSuccess(CityDto response) {
                onSuccess.onSuccess(response);
            }
        });

    }

    private static abstract class CallBack<T> implements Callback {

        private final Class<T> convert;
        private final OnFailed onFailed;

        public abstract void onSuccess(T response);
        public void onFailed(Throwable throwable) {
            if (onFailed != null) onFailed.onFailed(throwable);
        }

        private static final Gson gson = new Gson();
        private static final Handler handler = new Handler(Looper.getMainLooper());

        private CallBack(Class<T> convert, @Nullable OnFailed onFailed) {
            this.convert = convert;
            this.onFailed = onFailed;
        }

        private void onPreResult(@Nullable T item, @Nullable Throwable throwable) {
            handler.post(() -> {
                try {
                    if (item != null) {
                        onSuccess(item);
                        return;
                    }
                    throw throwable != null ? throwable : new Throwable("Unknown error");
                } catch (Throwable _throwable) {
                    try {
                        onFailed(throwable);
                    } catch (Throwable ignored) {
                    }
                }
            });
        }

        @Override
        public final void onResponse(@NonNull Call call, @NonNull Response response) {
            try {
                if (!response.isSuccessful()) throw new IOException("Not successful response!");
                T r = gson.fromJson(Objects.requireNonNull(response.body()).string(), convert);
                onPreResult(r, null);
            } catch (Throwable throwable) {
                onPreResult(null, throwable);
            }
        }

        @Override
        public final void onFailure(@NonNull Call call, @NonNull IOException e) {
            onPreResult(null, e);
        }

    }

    public interface OnSuccess<T> {
        void onSuccess(T item);
    }

    public interface OnFailed {
        void onFailed(Throwable throwable);
    }

}
