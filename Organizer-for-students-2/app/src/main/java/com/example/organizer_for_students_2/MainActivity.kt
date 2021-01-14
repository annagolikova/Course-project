package com.example.organizer_for_students_2

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.organizer_for_students_2.db.OrganizerDbManager
import com.example.organizer_for_students_2.ui.main.SectionsPagerAdapter
import com.example.organizer_for_students_2.ui.main.PageViewModel
import com.example.organizer_for_students_2.ui.main.PlaceholderFragment

class MainActivity : AppCompatActivity() {
    val organizerDbManager= OrganizerDbManager(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        organizerDbManager.OpenDb()
        organizerDbManager.insertToProfessors("Иванов Иван Иванович")
        //val pholder:PlaceholderFragment
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
        val fab: FloatingActionButton = findViewById(R.id.fab)
        //val fragText : TextView=findViewById(R.id.section_label)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Data from the database should be displayed", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            //fragText.text = organizerDbManager.readProfessors().toString()
            /*var pageViewModel:PageViewModel
            *//*pageViewModel = ViewModelProvider(this).get(PageViewModel::class.java).apply {
                setIndex(arguments?.getInt(PlaceholderFragment.ARG_SECTION_NUMBER) ?: 1)
            }*//*
            pageViewModel.text.observe(this, Observer<String> {
                textView.text = it
            })*/
            //PlaceholderFragment.pageViewModel.text = organizerDbManager.readProfessors()
        }
    }
}