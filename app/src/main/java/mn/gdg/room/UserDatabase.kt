package mn.gdg.room

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RenameColumn
import androidx.room.RoomDatabase
import androidx.room.migration.AutoMigrationSpec
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(
    entities = [
        User::class,
        School::class
    ],
    version = 4,
    autoMigrations = [
        AutoMigration(from = 1, to = 2),
        AutoMigration(from = 2, to = 3, spec = UserDatabase.Migration2To3::class),
    ]
)
abstract class UserDatabase : RoomDatabase() {
    abstract val userDao: UserDao

    @RenameColumn(tableName = "users", fromColumnName = "name", toColumnName = "username")
    class Migration2To3 : AutoMigrationSpec

    companion object {
        val migration3To4 = object : Migration(startVersion = 3, endVersion = 4) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("CREATE TABLE IF NOT EXISTS schools (name CHAR NOT NULL PRIMARY KEY)")
            }
        }
    }
}
