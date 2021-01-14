package com.example.organizer_for_students_2.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase

class OrganizerDbManager(context:Context) {
    val organizerDbHelper = OrganizerDbHelper(context)
    var db: SQLiteDatabase?=null

    fun OpenDb(){
        db=organizerDbHelper.writableDatabase
        //TODO("Enable foreign keys if necessary")
    }

    fun insertToProfessors(prof_name: String)
    {
        val values = ContentValues().apply {
            put(OrganizerDbClass.ProfessorsTable.prof_name, prof_name)
        }
        db?.insert(OrganizerDbClass.ProfessorsTable.tn_professors, null, values)
    }

    fun readProfessors():ArrayList<String>{
        val profList=ArrayList<String>()
        val cursor = db?.query(OrganizerDbClass.ProfessorsTable.prof_name, null,null,null,null,null,null)

            while(cursor?.moveToNext()!!)
            {
                val profName=cursor?.getString(cursor.getColumnIndex(OrganizerDbClass.ProfessorsTable.prof_name))
                profList.add(profName.toString())
            }

        return profList
    }

}