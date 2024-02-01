package mn.gdg.room

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val db = Room.databaseBuilder(
            applicationContext,
            UserDatabase::class.java,
            "gdg.db"
        )
            .addMigrations(UserDatabase.migration3To4)
            .build()

//        (1..10).forEach {
//            lifecycleScope.launch {
////                db.userDao.upsertSchool(
////                    School(name = "school_$it")
////                )
//                db.userDao.upsertUser(
//                    User("test$it")
//                )
//            }
//        }

        lifecycleScope.launch {
//            db.userDao.getSchools().forEach(::println)

            db.userDao.getUsers().forEach(::println)
        }
    }
}
