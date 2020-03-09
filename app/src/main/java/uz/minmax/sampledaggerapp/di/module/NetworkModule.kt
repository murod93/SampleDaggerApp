package uz.minmax.sampledaggerapp.di.module

import android.content.Context
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.readystatesoftware.chuck.ChuckInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.minmax.sampledaggerapp.BuildConfig.BASE_URL
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton


/**
 * @author Abdukholikov Murodjon
 */

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor? =  HttpLoggingInterceptor()
        .apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Singleton
    @Provides
    @Named("PUBLIC")
    fun providePublicClient(context: Context, loggingInterceptor: HttpLoggingInterceptor): OkHttpClient = OkHttpClient.Builder()
        .writeTimeout(15, TimeUnit.SECONDS)
        .readTimeout(15, TimeUnit.SECONDS)
        .connectTimeout(15, TimeUnit.SECONDS)
        .addInterceptor(ChuckInterceptor(context))
        .addInterceptor(loggingInterceptor)
        .build()

    @Provides
    @Singleton
    fun provideGson(): Gson? = GsonBuilder()
        .apply {
            setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        }.create()

    @Singleton
    @Provides
    fun provideRetrofitAuth(@Named("PRIVATE") client: OkHttpClient):Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Singleton
    @Provides
    @Named("PUBLIC")
    fun provideRetrofit(@Named("PUBLIC") client: OkHttpClient, gson: Gson): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()


//    @Singleton
//    @Provides
//    @Named("PRIVATE")
//    fun getClientPrivate(context: Context, authenticator: Authenticator, localStorage: LocalStorage): OkHttpClient = OkHttpClient.Builder()
//        .addInterceptor(ChuckInterceptor(context))
//        .addInterceptor(logging)
//        .addInterceptor {
//            val old = it.request()
//            val request = old.newBuilder()
//                .removeHeader("Authorization")
//                .addHeader("Authorization", "${localStorage.token.accessToken}")
//                .method(old.method, old.body)
//                .build()
//            it.proceed(request)
//        }
//        .authenticator(authenticator)
//        .build()
//
//
//    @Singleton
//    @Provides
//    fun getAuthenticator(@Named("PUBLIC") retrofit: Retrofit, localStorage: LocalStorage): Authenticator = object : Authenticator {
//        override fun authenticate(route: Route?, response: Response): Request? {
//            if (localStorage.token.isEmpty()) {
//                EventsBus.logoutLiveData.postValue(Unit)
//                return null
//            }
//            if (response.code == 401) {
//                val refreshToken = retrofit.create(AuthApi::class.java).refresh(localStorage.token).execute()
//                if (refreshToken.code() == 401) {
//                    localStorage.token = LoginResponse.Tokens()
//                    EventsBus.logoutLiveData.postValue(Unit)
//                    return null
//                }
//                localStorage.token = refreshToken.body()?.data!!
//            }
//            return response.request.newBuilder()
//                .removeHeader("Authorization")
//                .addHeader("Authorization", "${localStorage.token.accessToken}")
//                .build()
//        }
//    }
}