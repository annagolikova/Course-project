create table if not exists subjects
(
subject_id integer primary key autoincrement,
subject_name text not null,
prof_name text not null);

create table if not exists schedule_
(
schedule_id integer not null primary key autoincrement,
time_start text,
time_finish text
);

create table if not exists timetable
(
timetable_id integer primary key autoincrement,
subject_id integer not null,
schedule_id integer not null,
weekday_id integer,
aud_number text not null,
week_number not null,
foreign key (subject_id) references subjects(subject_id) on delete cascade on update cascade,
foreign key (weekday_id) references weekdays(weekday_id) on delete cascade on update cascade,
foreign key (schedule_id) references schedule_(schedule_id) on delete cascade on update cascade
 );
 
create table if not exists exams
(
exam_id integer primary key autoincrement,
subject_id integer,
foreign key (subject_id) references subjects(subject_id) on delete cascade on update cascade
);

create table if not exists lecture_notes
(
lnotes_id integer primary key autoincrement,
topic text not null,
file_name text not null,
subject_id integer,
foreign key (subject_id) references subject(subject_id) on delete cascade on update cascade
);

create table if not exists grades
(
grade_id integer primary key autoincrement,
subject_id integer,
grade integer,
date text,
foreign key (subject_id) references subjects(subject_id) on delete cascade on update cascade
);

create table if not exists weekdays
(
weekday_id integer primary key autoincrement,
weekday_name text
);