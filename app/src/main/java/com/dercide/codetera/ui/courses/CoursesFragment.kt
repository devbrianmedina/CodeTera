package com.dercide.codetera.ui.courses

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dercide.codetera.MainActivity
import com.dercide.codetera.R
import com.dercide.codetera.adapters.CourseAdapter
import com.dercide.codetera.models.Comment
import com.dercide.codetera.models.Course
import com.dercide.codetera.models.Topic
import com.dercide.codetera.models.Video
import com.dercide.codetera.ui.course.CourseActivity
import com.dercide.codetera.ui.coursedetails.CourseDetailsActivity
import kotlin.random.Random

class CoursesFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_courses, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //recycler
        val rvCourses: RecyclerView = view.findViewById(R.id.rvCoursesFragmentCourses)

        val adapter = CourseAdapter(MainActivity.courses, requireContext()) {
            val intent = Intent(requireContext(), CourseDetailsActivity::class.java)
            intent.putExtra("idCourse", it.id)
            startActivity(intent)
        }

        val linearLayoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        rvCourses.layoutManager = linearLayoutManager
        rvCourses.adapter = adapter
    }
}