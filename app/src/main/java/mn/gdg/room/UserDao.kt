package mn.gdg.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import mn.gdg.room.School
import mn.gdg.room.User

@Dao
interface UserDao {

    @Upsert
    suspend fun upsertUser(user: User)

//    @Upsert
//    suspend fun upsertSchool(school: School)

    @Delete
    suspend fun delete(user: User)

    @Query("select * from users")
    suspend fun getUsers(): List<User>
}
