package gyanani.harish.basicroomexample.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import gyanani.harish.basicroomexample.database.entity.User

@Dao
interface UserDao {
    @get:Query("SELECT * FROM user")
    val all: List<User>

    @Insert
    fun insertAll(bills: List<User>)
    
}
/* 
@Dao
interface UserDao {
    @get:Query("SELECT * FROM user")
    val allUsers: List<User>

    @get:Query("SELECT * FROM user")
    val all: LiveData<List<User>>

    @Query("SELECT * FROM user")
    fun getAllUsersRx(): Observable<List<User>>

    @Insert
    fun insertAll(bills: List<User>)
}
*/