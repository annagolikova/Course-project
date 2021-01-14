package com.example.organizer_for_students

import android.app.Application
import com.example.organizer_for_students.data.OrganizerDatabase
import com.example.organizer_for_students.data.OrganizerRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class OrgApplication:  Application() {
    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    val applicationScope = CoroutineScope(SupervisorJob())
   /* val database by lazy { OrganizerDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { OrganizerRepository(database.subjectDao(), database.professorDao())}*/
    val database by lazy { OrganizerDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { OrganizerRepository(database.subjectDao(), database.professorDao())}
}