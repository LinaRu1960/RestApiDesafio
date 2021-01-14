package cl.eme.restapidesafio.data

import android.app.Application
import androidx.room.*
import cl.eme.restapidesafio.User

@Database (entities=[User::class],version=1)
abstract class UserDatabase: RoomDatabase() {
    abstract fun userDao():UserDao
}

class UserApplication: Application() {

    companion object {
        var userDatabase:UserDatabase?=null

    }

    override fun onCreate(){
        super.onCreate()
        userDatabase=Room.databaseBuilder(this,UserDatabase::class.java,"user_db").build()
    }

}