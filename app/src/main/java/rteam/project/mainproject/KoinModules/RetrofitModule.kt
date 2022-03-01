package rteam.project.mainproject.KoinModules


import androidx.core.os.BuildCompat
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.BuildConfig.DEBUG

import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


import java.util.concurrent.TimeUnit
import okhttp3.Interceptor
import rteam.project.baseproject.BuildConfig
import rteam.project.baseproject.BuildConfig.BASE_URL


val retrofitModule = module{
    val connectTimeout : Long = 40// 20s
    val readTimeout : Long  = 40 // 20s
    fun provideHttpClient(): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder()
            .connectTimeout(connectTimeout, TimeUnit.SECONDS)
            .readTimeout(readTimeout, TimeUnit.SECONDS)
        if (DEBUG) {
            val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
            okHttpClientBuilder.addInterceptor(httpLoggingInterceptor)
        }
        okHttpClientBuilder.addInterceptor(Interceptor { chain ->
            val request = chain.request()
            request.headers.get("url")?.let { request.newBuilder().url(it) }
            chain.proceed(request)
        })
        return okHttpClientBuilder.build()
    }
    fun provideRetrofit(client: OkHttpClient, baseUrl: String): Retrofit {
        return  Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .client(client)
            .build()
    }
    single { provideHttpClient() }
    factory { provideRetrofit(get(),BASE_URL) }
}