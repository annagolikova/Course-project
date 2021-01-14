package com.example.organizer_for_students

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.organizer_for_students.data.Professor
import com.example.organizer_for_students.data.OrganizerDatabase
import com.example.organizer_for_students.data.WordViewModel
import com.example.organizer_for_students.data.WordViewModelFactory
import kotlinx.android.synthetic.main.item_page.view.*
import kotlinx.android.synthetic.main.page1.view.*
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ViewPagerAdapter : RecyclerView.Adapter<PagerVH>() {

    private val colors = intArrayOf(
        android.R.color.black,
        android.R.color.holo_red_light,
        android.R.color.holo_blue_dark,
        android.R.color.holo_purple,
        android.R.color.holo_purple,
        android.R.color.holo_purple,
        android.R.color.holo_purple
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerVH =
        PagerVH(LayoutInflater.from(parent.context).inflate(R.layout.page1, parent, false))

    override fun getItemCount(): Int = 7

    override fun onBindViewHolder(holder: PagerVH, position: Int) = holder.itemView.run {
       //tvTitle.text = "item $position"
       // container.setBackgroundResource(colors[position])
        if (position==0) {
            day.text = "Понеділок"

        }
        if (position==1)
            day.text="Вівторок"
        if (position==2)
            day.text="Середа"
        if (position==3)
            day.text="Четвер"
        if (position==4)
            day.text="П'ятниця"
        if (position==5)
            day.text="Субота"
        if (position==6)
            day.text="Неділя"

    }
}

class PagerVH(itemView: View) : RecyclerView.ViewHolder(itemView)