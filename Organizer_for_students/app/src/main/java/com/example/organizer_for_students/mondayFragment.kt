package com.example.organizer_for_students
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

// Here ":" symbol is indicate that SignupFragment
// is child class of Fragment Class
class MondayFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.page1, container, false
        )
    }
    // Here "layout_signup" is a name of layout file
    // created for SignFragment
}