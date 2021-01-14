package cl.eme.restapidesafio.data

import cl.eme.restapidesafio.User
import retrofit2.Response
import retrofit2.http.GET

interface Api {
    @GET("/users")
    suspend fun getAllUsers (): Response<List<User>>
}