package org.abubaker.roomdb.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import org.abubaker.roomdb.model.User

@Dao
interface UserDao {

    // Insert a User into the database by using the OnConflictStrategy.IGNORE
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    // Retrieve all Users from the database
    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<User>>

}

/**
 * "Type of the parameter must be a class annotated with @Entity" while creating Generic DAO interface
 * in Room Room : LiveData from Dao will trigger Observer.onChanged on every Update, even if the
 * LiveData value has no change
 *
 * https://www.autoscripts.net/dao-error-type-of-the-parameter-must-be-a-class-annotated-with-entity-or-a-collection-array-of-it/
 *
 *
 * BUG Solution:
 * https://stackoverflow.com/questions/70292474/cant-use-suspend-function-in-roomdb-dao
 *
 */