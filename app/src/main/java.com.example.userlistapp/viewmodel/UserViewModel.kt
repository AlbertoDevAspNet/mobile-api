package java.com.example.userlistapp.api

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.userlistapp.api.RetrofitClient
import com.example.userlistapp.model.User
import kotlinx.coroutines.launch
/*  
* ViewModel para gerenciar os dados dos usuários
* Responsável por buscar os dados da API e expô-los para a UI
* Utiliza corrotinas para operações assíncronas
* @author Alberto

 */
 class UserViewModel : ViewModel() {
    //LiveData para armazenar a lista de usuários e expô-la para a UI
    private val _users = MutableLiveData<List<User>>()
    //LiveData pública para a lista de usuários, acessível pela UI
    val users: LiveData<List<User>> get() = _users

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                _isError.value = false    
                val response = RetrofitClient.apiService.getUsers()
                if (response.isSuccessful) {
                    _users.value = response.body()
                } else {
                    // Tratar erro de resposta
                   _error.value = "Erro: ${response.code()}"
                }
                _isLoading.value = false
            } catch (e: Exception) {
                // Tratar exceção de rede ou outras
                //_errorMessage.value = e.message
                _isError.value = true
            }
        }
    }
