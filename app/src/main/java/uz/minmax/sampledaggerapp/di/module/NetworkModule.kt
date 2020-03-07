package uz.minmax.sampledaggerapp.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import okhttp3.Authenticator
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.minmax.sampledaggerapp.BuildConfig.BASE_URL
import javax.inject.Named
import javax.inject.Singleton

/**
 * @author Abdukholikov Murodjon
 */

@Module
class NetworkModule {
    private val logging = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

    @Singleton
    @Provides
    fun getRetrofitAuth(@Named("PRIVATE") client: OkHttpClient) = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Singleton
    @Provides
    @Named("PUBLIC")
    fun getRetrofit(@Named("PUBLIC") client: OkHttpClient) = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


//    @Singleton
//    @Provides
//    @Named("PUBLIC")
//    fun getClientPublic(context: Context): OkHttpClient = OkHttpClient.Builder()
//        .addInterceptor(ChuckInterceptor(context))
//        .addInterceptor(logging)
//        .build()
//
//
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