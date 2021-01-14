package com.example.organizer_for_students.data


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName="professors")
data class Professor(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="professor_id") val professor_id:Int,
    @ColumnInfo(name="prof_name") val prof_name: String
)

@Entity(tableName="subjects", foreignKeys = [ForeignKey(
    entity = Professor::class,
    parentColumns = arrayOf("professor_id"),
    childColumns = arrayOf("prof_id"),
    onDelete = ForeignKey.CASCADE
)]
)
data class Subject(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="subject_id") val subject_id: Int,
    @ColumnInfo(name="subject_name")val subject_name: String,
    @ColumnInfo(name="prof_id")val prof_id: Int
)
