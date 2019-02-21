package io.github.mehdi.remote.di.module

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.*
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import io.github.mehdi.remote.BuildConfig
import io.github.mehdi.remote.TokenAuthenticator
import io.github.mehdi.remote.constant.ConstantValues.BASE_URL
import io.github.mehdi.remote.constant.ConstantValues.NETWORK_HEADER_ACCEPT_LANGUAGE
import io.github.mehdi.remote.constant.ConstantValues.NETWORK_HEADER_ACCEPT_TYPE
import io.github.mehdi.remote.restful.APIs
import okhttp3.Authenticator
import okhttp3.Headers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder()
            .registerTypeAdapter(Date::class.java, JsonDeserializer { json, _, _ -> Date(json.asJsonPrimitive.asLong) })
            .registerTypeAdapter(Date::class.java, JsonSerializer<Date> { src, _, _ -> JsonPrimitive(src.time) })
            .create()
    }

    @Singleton
    @Provides
    fun provideSharedHeaders(): Headers {
        return Headers.Builder()
            .add("Accept", NETWORK_HEADER_ACCEPT_TYPE)
            .add("Accept-Language", NETWORK_HEADER_ACCEPT_LANGUAGE)
            .build()
    }

    @Singleton
    @Provides
    fun provideAuthenticator(): Authenticator {
        return TokenAuthenticator()
    }

    @Singleton
    @Provides
    @Suppress("UNUSED_PARAMETER")
    fun provideOkHttpClientBuilder(): OkHttpClient.Builder {

        val builder = OkHttpClient.Builder()

//        builder.certificatePinner(certificatePinner)
        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(loggingInterceptor)

            builder.addNetworkInterceptor(StethoInterceptor())
        }

        return builder

    }

    @Singleton
    @Provides
    fun provideOkHttpClient(headers: Headers, okhttpBuilder: OkHttpClient.Builder): OkHttpClient {
        okhttpBuilder.interceptors().add(Interceptor { chain ->
            val request = chain.request()
            val requestBuilder = request.newBuilder()
                .headers(headers)
                .method(request.method(), request.body())
            chain.proceed(requestBuilder.build())

        })
        return okhttpBuilder.build()
    }

    @Singleton
    @Provides
    fun provideRetrofitBuilder(gson: Gson): Retrofit.Builder {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .baseUrl(BASE_URL)
    }

    @Singleton
    @Provides
    fun provideRetrofitWithoutToken(okHttpClient: OkHttpClient, retrofitBuilder: Retrofit.Builder): Retrofit {
        return retrofitBuilder.client(okHttpClient).build()
    }

    @Singleton
    @Provides
    fun provideService(retrofit: Retrofit): APIs {
        return retrofit.create(APIs::class.java)
    }
}