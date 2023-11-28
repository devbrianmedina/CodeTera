package com.dercide.codetera.ui.courses

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.dercide.codetera.MainActivity
import com.dercide.codetera.R
import com.dercide.codetera.ui.course.CourseActivity
import com.dercide.codetera.ui.coursedetails.CourseDetailsActivity

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
        val btnFlutter:Button = view.findViewById(R.id.btnCurseFlutter)
        btnFlutter.setOnClickListener {
            val intent = Intent(requireContext(), CourseActivity::class.java)
            startActivity(intent)
        }

        val llCourse:LinearLayout = view.findViewById(R.id.llCourseCourses)
        llCourse.setOnClickListener {
            val intent = Intent(requireContext(), CourseDetailsActivity::class.java)
            startActivity(intent)
        }
    }
}