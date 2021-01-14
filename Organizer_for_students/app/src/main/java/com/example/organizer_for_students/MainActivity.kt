package com.example.organizer_for_students

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.example.organizer_for_students.data.WordViewModel
import com.example.organizer_for_students.data.WordViewModelFactory
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*
import android.app.Activity
import android.view.ViewGroup
import android.widget.Button
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.Toast
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.page1.*
import kotlinx.android.synthetic.main.page1.view.*

class MainActivity : AppCompatActivity() {

    /*Initializing viewmodel for database*/
    private val wordViewModel: WordViewModel by viewModels {
        WordViewModelFactory((application as OrgApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*Setting up viewPager*/
        val viewPager2=findViewById<ViewPager2>(R.id.viewPager2)
        val adapter=ViewPagerAdapter()
        viewPager2.adapter = adapter
        aud1.text="Математика"
        wordViewModel.allProfessors.observe(owner=this) { professors ->
            // Update the cached copy of the words in the adapter.
           //professors.let { adapter.submitList(it)

        }
        }

        /*Setting up tabs*/
        override fun TabLayoutMediator (tabs, viewPager2, object : TabLayoutMediator.TabConfigurationStrategy {
            override fun onConfigureTab(tab: TabLayout.Tab, position: Int) {
                // Styling each tab here
                if (position==0)
                tab.text = "Пн"
                if (position==1)
                tab.text = "Вт"
                if (position==2)
                tab.text = "Ср"
                if (position==3)
                tab.text = "Чт"
                if (position==4)
                tab.text = "Пт"
                if (position==5)
                tab.text = "Сб"
                if (position==6)
                tab.text = "Нд"
            }
        }).attach()
    }

}
