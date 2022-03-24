package rteam.project.mainproject.DI

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import rteam.project.mainproject.Helpers.Constants
import rteam.project.mainproject.Retrofit.NetworkService
import javax.inject.Singleton

/**
 * can change base url with qualifiers
 */

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun getBaseUrl() = Constants.BASEURL

    @Singleton
    @Provides
    fun getRetrofit(url : String) =
        Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Singleton
    @Provides
    fun provideService(retrofit: Retrofit) : NetworkService = retrofit.create(NetworkService::class.java)


}