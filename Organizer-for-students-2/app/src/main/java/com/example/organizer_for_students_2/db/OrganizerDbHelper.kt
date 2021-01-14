package com.example.organizer_for_students_2.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class OrganizerDbHelper(context: Context) : SQLiteOpenHelper(context, OrganizerDbClass.DATABASE_NAME, null, OrganizerDbClass.DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(OrganizerDbClass.CreateTableProfessors)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(OrganizerDbClass.DeleteTableProfessors)
        onCreate(db)
    }

}