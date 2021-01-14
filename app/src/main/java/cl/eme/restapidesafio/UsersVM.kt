package cl.eme.restapidesafio

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.eme.restapidesafio.data.Repository
import kotlinx.coroutines.launch

class UsersVM: ViewModel(){

    private val repository= Repository()



    val userList=repository.getUserList()

    init {

        viewModelScope.launch{
            repository.loadUserList()
        }


    }



}