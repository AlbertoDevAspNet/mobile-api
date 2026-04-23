package java.com.example.userlistapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.recycler.widget.RecyclerView
import com.example.userlistapp.databinding.ItemUserBinding
import com.example.userlistapp.model.User

class UserAdapter(private val userList: List<User>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    inner class UserViewHolder(private val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            binding.textViewName.text = user.name
            binding.textViewEmail.text = user.email
            binding.textViewPhone.text = user.phone
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}
