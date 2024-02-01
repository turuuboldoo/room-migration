package mn.gdg.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "schools")
data class School(
    @PrimaryKey(autoGenerate = false)
    val name: String
)
