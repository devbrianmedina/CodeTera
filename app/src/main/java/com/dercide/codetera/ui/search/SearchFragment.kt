package com.dercide.codetera.ui.search

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dercide.codetera.MainActivity
import com.dercide.codetera.R
import com.dercide.codetera.adapters.CourseAdapter
import com.dercide.codetera.models.Course
import com.dercide.codetera.ui.course.CourseActivity
import com.dercide.codetera.ui.coursedetails.CourseDetailsActivity
import com.google.android.material.textfield.TextInputLayout

class SearchFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tilSearch:TextInputLayout = view.findViewById(R.id.textInputLayoutSearch)


        val courseSearch = ArrayList<Course>()

        //recycler
        val rvCourses: RecyclerView = view.findViewById(R.id.rvCoursesFragmentSearch)

        val adapter = CourseAdapter(courseSearch, requireContext(), {
            val intent = Intent(context, CourseActivity::class.java)
            intent.putExtra("idCourse", it.id)
            startActivity(intent)
        }, {
            val intent = Intent(requireContext(), CourseDetailsActivity::class.java)
            intent.putExtra("idCourse", it.id)
            startActivity(intent)
        })

        val linearLayoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        rvCourses.layoutManager = linearLayoutManager
        rvCourses.adapter = adapter

        tilSearch.editText?.addTextChangedListener { txt ->
            courseSearch.clear()
            MainActivity.courses.forEach {
                if(it.name.contains(txt.toString(), ignoreCase = false) && txt.toString().isNotEmpty() && txt.toString() != " ") {
                    courseSearch.add(it)
                }
            }
            adapter.notifyDataSetChanged()
        }
    }
}