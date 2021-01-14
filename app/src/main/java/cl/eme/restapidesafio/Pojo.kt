package cl.eme.restapidesafio

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="user")
data class User(val name:String, @PrimaryKey val email:String, val phone:String)