package com.example.organizer_for_students.data

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class OrganizerRepository(private val subjectDao: SubjectDao, private val professorDao: ProfessorDao) {

    val allSubjects: Flow<List<Subject>> = subjectDao.getAllSubjects()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(subject: Subject){
        subjectDao.insert(subject)
    }
    val allProfessors: Flow<List<Professor>> = professorDao.getAllProfessors()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(professor: Professor){
        professorDao.insert(professor)
    }

}