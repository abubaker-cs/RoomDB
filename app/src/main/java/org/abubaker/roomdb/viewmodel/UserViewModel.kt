package org.abubaker.roomdb.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.abubaker.roomdb.data.UserDatabase
import org.abubaker.roomdb.data.UserRepository
import org.abubaker.roomdb.model.User

/**
 * It's role is to provide the UI and survive configuration changes. It acts as a communication
 * center between the Repository and the UI.
 *
 * ViewModel vs AndroidViewModel
 * AndroidViewModel contains Application Reference.
 */
class UserViewModel(application: Application) : AndroidViewModel(application) {

    private val readAllData: LiveData<List<User>>
    private val repository: UserRepository


    init {

        val userDao = UserDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDao)

        // Get complete list from the Repository
        readAllData = repository.readAllData

    }

    fun addUser(user: User) {

        // Dispatchers.IO = Run code in the background thread.
        // viewModelScope
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }

    }

}