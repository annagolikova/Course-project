package com.example.organizer_for_students_2.db

import android.provider.BaseColumns

object OrganizerDbClass
{
    const val DATABASE_VERSION = 1
    const val DATABASE_NAME = "Organizer.db"

    object ProfessorsTable : BaseColumns
    {
        const val tn_professors = "professors"
        const val prof_name = "prof_name"
    }

    const val CreateTableProfessors = "Create table if not exists ${ProfessorsTable.tn_professors} (" +
            "${BaseColumns._ID} integer primary key autoincrement," +
            "${ProfessorsTable.prof_name} text );"

   const val DeleteTableProfessors = "Drop table if exists ${ProfessorsTable.tn_professors}"

    object SubjectsTable : BaseColumns
    {
        const val tn_subjects = "subjects"
        const val prof_id_fk = "prof_id"
        const val subject_name = "subject_name"
    }

    object WeekdaysTable : BaseColumns
    {
        const val tn_weekdays = "weekdays"
        const val weekday_name = "weekday_name"
    }

    object ScheduleTable : BaseColumns
    {
        const val tn_schedule = "schedule"
        const val schedule_start = "time_start"
        const val schedule_finish = "time_finish"
    }

    object TimetableTable : BaseColumns
    {
        const val tn_timetable = "timetable"
        const val subject_id_fk = "subject_id"
        const val schedule_id_fk = "schedule_id"
        const val weekday_id_fk = "weekday_id"
        const val aud_number = "aud_number"
        const val week_number = "week_number"
    }

    object ExamTypesTable : BaseColumns
    {
        const val tn_exam_types = "exams"
        const val exam_type_name = "exam_type_name"
    }

    object ExamsTable : BaseColumns
    {
        const val tn_exams = "exams"
        const val exam_type_id_fk = "exam_type_id"
        const val subject_id_fk = "subject_id"
    }

    object HomeworkTable : BaseColumns
    {
        const val tn_homework = "homework"
        const val subject_id_fk = "subject_id"
    }

    object HomeworkListTable : BaseColumns
    {
        const val tn_homework_list = "homework_list"
        const val hw_id_fk = "hw_id"
        const val hw_desk = "hw_desk"
        const val fin_date = "fin_date"
    }

    object LectureNotesTable : BaseColumns
    {
        const val tn_lecture_notes = "lecture_notes"
        const val subject_id_fk = "subject_id"
    }

    object LectureNotesListTable : BaseColumns
    {
        const val tn_lecture_notes_list = "lecture_notes_list"
        const val lnotes_id_fk = "lnotes_id"
        const val lnotes_topic = "lnotes_topic"
        const val lnotes_uri = "lnotes_uri"
    }

    object PerformanceTable : BaseColumns
    {
        const val tn_performance = "performance"
        const val subject_id_fk = "subject_id"
    }

    object PerformanceListTable : BaseColumns
    {
        const val tn_performance_list = "performance_list"
        const val perf_id_fk = "perf_id"
        const val grade = "grade"
        const val grade_date = "grade_date"
    }
}