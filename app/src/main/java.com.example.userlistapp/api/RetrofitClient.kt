package java.com.example.userlistapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
/**
** Singleton para criar e fornecer uma instância do Retrofit
* Configura o Retrofit com a URL base e o conversor Gson
* @author Alberto
**/
object RetrofitClient {
    private const val BASE_URL = "https://api.example.com/"
    val apiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            
    }
    // Cria uma instância do ApiService usando o Retrofit
    val apiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}     
