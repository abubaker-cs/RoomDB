package org.abubaker.roomdb.data

import androidx.lifecycle.LiveData
import org.abubaker.roomdb.model.User

/**
 * It is a class, that abstracts access to multiple data sources.
 */
class UserRepository(private val userDao: UserDao) {

    //
    val readAllData: LiveData<List<User>> = userDao.readAllData()

    suspend fun addUser(user: User) {

        userDao.addUser(user)

//        try {
//
//
//
//        } catch (cause: Throwable) {
//
//            Log.e("FAILED", "Failed to addUser()", cause)
//
//        }
    }

}