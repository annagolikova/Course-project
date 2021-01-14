package com.example.organizer_for_students.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface SubjectDao {

    @Query("SELECT * FROM subjects")
    fun getAllSubjects(): Flow<List<Subject>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(subject: Subject)
}
@Dao
interface ProfessorDao {

    @Query("SELECT * FROM professors")
    fun getAllProfessors(): Flow<List<Professor>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(professor: Professor)
}