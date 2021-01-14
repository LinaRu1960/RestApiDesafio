package cl.eme.restapidesafio.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cl.eme.restapidesafio.User

@Dao
interface UserDao {

    @Insert(onConflict= OnConflictStrategy.REPLACE)
    suspend fun insertUsers(list:List<User>)

    @Query("SELECT * FROM user")
    fun getUsers(): LiveData<List<User>>

}