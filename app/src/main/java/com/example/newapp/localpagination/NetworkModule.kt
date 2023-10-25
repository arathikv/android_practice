package com.example.newapp.localpagination



import com.example.newapp.localpagination.CatApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Call
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    const val API_KEY = "224dbe84-d330-4339-acb5-a95cbcdd6b1e"
    const val BASE_URL = "https://api.thecatapi.com"
    const val AUTH_HEADER = "x-api-key"
    @Provides
    @Singleton
    fun provideRetrofit(
        moshi: Moshi,
        callFactory: Call.Factory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .callFactory(callFactory)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @Provides
    @Singleton
    fun provideSiliconApi(retrofit: Retrofit): CatApi {
        return retrofit.create()
    }

    @Provides
    @Singleton
    fun provideOkHttp(
        loggingInterceptor: HttpLoggingInterceptor,
        @AuthInterceptor authInterceptor: Interceptor
    ): Call.Factory {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(authInterceptor)
            .callTimeout(10, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    @Singleton
    @AuthInterceptor
    fun provideAuthInterceptor(): Interceptor {
        return Interceptor { chain ->
            val newRequest =
                chain.request().newBuilder().addHeader(AUTH_HEADER, API_KEY).build()
            chain.proceed(newRequest)
        }
    }

    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
    }

}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class AuthInterceptor