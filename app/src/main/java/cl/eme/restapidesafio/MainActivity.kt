package cl.eme.restapidesafio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import cl.eme.restapidesafio.databinding.ActivityMainBinding
import timber.log.Timber

/*
[] 1. Ir a la web de jsonplaceholder https://jsonplaceholder.typicode.com, e identificar el método a
        utilizar para los datos de usuario.
[X] 2. Crear un nuevo proyecto kotlin, min sdk 19, blank activity, llamado RestApiDesafio.
[X] 3. Implementar las bibliotecas necesarias en el archivo gradle.
[X] 4. Modificar el layout por defecto activity_main.xml para incluir una vista tipo RecyclerView.
[X] 5. Crear el layout users_list_item.xml con los atributos name, email y phone.
[] 6. Crear el archivo pojo con los atributos id, name, email y phone.
[] 7. Crear la interfaz Api con el método GET de la lista de usuarios del api.
[] 8. Crear la clase cliente de Retrofit.
[] 9. Crear la clase UserAdapter con la implementación de ViewHolder y parametrización de los datos
        de usuario name, email y phone.
[] 10. Modificar la clase de Actividad agregando un nuevo método loadApiData() e instanciando la clase
        recyclerview y UserAdapter.
        Opcional
[] 11. Opcional: Implementar el método POST del api JsonPlaceHolder para crear nuevos usuarios
 */

class MainActivity : AppCompatActivity() {
    private val userVM:UsersVM by viewModels()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.plant(Timber.DebugTree())
        val adapter=UserAdapter()
        userVM.userList.observe(this, {
            adapter.updateAdapter(it)
        })

        binding= ActivityMainBinding.inflate(layoutInflater)
        binding.rvUsers.adapter=adapter
        binding.rvUsers.layoutManager= LinearLayoutManager(this)
        setContentView(binding.root)
    }
}