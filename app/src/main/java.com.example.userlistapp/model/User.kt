
package com.example.userlistapp.model

import com.google.gson.annotations.SerializedName
/**
*
* Modelo de dados do Usuario
* Modelo da base de Dados
* @author Alberto
 */
data class User(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("email") val email: String,
    @SerializedName("telefone") val phone: String,
    @SerializedName("Endereco") val endereco: String
)
data class Endereco(

    @SerializedName("rua") val rua: String,
    @SerializedName("cidade") val cidade: String,
    @SerializedName("estado") val estado: String,
    @SerializedName("cep") val cep: String

)

