package mn.gdg.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    val username: String,

    @ColumnInfo(defaultValue = "", name = "email")
    val email: String = "",

    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
)
