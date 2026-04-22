package java.com.example.userlistapp.api

import  com.example.userlistapp.model.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path  
/*
*
* Interface de serviço para a API de usuários
* Define os endpoints para obter a lista de usuários e detalhes de um usuário específico
* @author Alberto   
**/

interface ApiService {
    @GET("users")
    suspend fun getUsers(): Response<List<User>>

    @GET("users/{id}")
    suspend fun getUserDetails(@Path("id") userId: Int): Response<User>
}   
