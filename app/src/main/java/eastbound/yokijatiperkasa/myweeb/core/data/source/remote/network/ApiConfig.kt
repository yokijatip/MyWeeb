package eastbound.yokijatiperkasa.myweeb.core.data.source.remote.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val BASE_URL = "https://api.jikan.moe/v4/"
const val BASE_URL_TOURISM = "https://tourism-api.dicoding.dev/"

class ApiConfig {



    companion object {
        fun getApiService(): ApiService {
            val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
                this.level = HttpLoggingInterceptor.Level.BODY
            }

//            val authInterceptor = Interceptor {
//                val req = it.request()
//                val reqHeaders = req.newBuilder()
//                    .build()
//                it.proceed(reqHeaders)
//            }

            val client = OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)
                .writeTimeout(1, TimeUnit.MINUTES)
                .readTimeout(1, TimeUnit.MINUTES)
                .addInterceptor(httpLoggingInterceptor)
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(ApiService::class.java)

        }
    }

}