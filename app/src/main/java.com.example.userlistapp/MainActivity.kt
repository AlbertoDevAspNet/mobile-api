package java.com.example.userlistapp.adapter

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import java.com.example.userlistapp.adapter.UserAdapter
import java.com.example.userlistapp.databinding.ActivityMainBinding
import java.com.example.userlistapp.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var userViewModel: UserViewModel
    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        //setupRecyclerView()
        //observeViewModel()
        // Inicializar View Model
        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        // Configurar RecyclerView
        adapter = UserAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
        // Observar os dados da ViewModel
        observeViewModel()

        //buscar usuarios DA api
        viewModel.fetchUsers()
        
 }

    private fun setupRecyclerView() {
        userAdapter = UserAdapter()
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = userAdapter
        }
    }

    private fun observeViewModel() {
        //Observar lista de Usuarios 
          viewModel.users.observe(this){
            users ->
            adapter.updateUsers(users)
             binding.progressBar.visibility = View.GONE
          }
          //observar o estado de carregamento
          viewModel.isLoading.observe(this){ isLoading ->
          binding.progressBar.visibility =
          if (isLoading) View.VISIBLE else View.GONE}

        }

        //Observar erros
        viewModel.error.observe(this) { error ->
            
            if(error != null){
                // Exibir mensagem de erro
                blinding.tvError.text = error
                blinding.tvError.visibility = View.VISIBLE
                //Toast.makeText(this, "Erro: $error", Toast.LENGTH_LONG).show()
            } 
            //binding.progressBar.visibility = View.GONE
        }
    }
}
    
