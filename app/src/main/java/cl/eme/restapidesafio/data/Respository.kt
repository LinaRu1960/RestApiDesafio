package cl.eme.restapidesafio.data

import androidx.lifecycle.LiveData
import cl.eme.restapidesafio.RetrofitClient
import cl.eme.restapidesafio.User
import timber.log.Timber

class Repository {

    private val userDatabase=UserApplication.userDatabase!!


    suspend fun loadUserList(){
        val response= RetrofitClient.retrofitInstance().getAllUsers()

        when (response.isSuccessful) {
            true -> response.body()?.let {
                Timber.d("respuesta exitosa con ${response.body()?.size}")
                userDatabase.userDao().insertUsers(it)
            }
            false -> Timber.d("Ocurrió un error ${response.errorBody()}")
        }

    }

    fun getUserList(): LiveData<List<User>> {

        return userDatabase.userDao().getUsers()
    }
}