package com.example.organizer_for_students.data

import android.content.Context
import android.provider.SyncStateContract.Helpers.insert
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Database(entities = [Subject::class, Professor::class], version = 1)
abstract class OrganizerDatabase : RoomDatabase() {

    abstract fun professorDao(): ProfessorDao
    abstract fun subjectDao(): SubjectDao

    companion object {
        @Volatile
        private var INSTANCE: OrganizerDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): OrganizerDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    OrganizerDatabase::class.java,
                    "word_database"
                )
                    .fallbackToDestructiveMigration()
                    .addCallback(WordDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }


        private class WordDatabaseCallback(
        private val scope: CoroutineScope
         ) : RoomDatabase.Callback() {

            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO) {
                        populateDatabase(database.professorDao())
                    }

                // Delete all content here.
                //subjectDao.deleteAll()

                // Add sample words.

                }
            }


         }
        suspend fun populateDatabase(professorDao: ProfessorDao) {
            var professor = Professor(1, "Prepod")
            professorDao.insert(professor)
            professor = Professor(2, "profes")
            professorDao.insert(professor)

            // TODO: Add your own words!
            //word = Word("TODO!")
            // wordDao.insert(word)
        }
    }

}