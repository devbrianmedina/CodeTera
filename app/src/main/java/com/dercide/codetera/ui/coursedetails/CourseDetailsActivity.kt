package com.dercide.codetera.ui.coursedetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.Glide
import com.dercide.codetera.MainActivity
import com.dercide.codetera.R
import de.hdodenhof.circleimageview.CircleImageView

class CourseDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_details)

        // Configurar la Toolbar como ActionBar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Configurar el botón de regreso
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val idCourse: Int = intent.extras!!.getInt("idCourse")
        val course = MainActivity.courses.find { it.id == idCourse }
        if(idCourse <= 0 || course == null) finish()

        val imgBanner:ImageView = findViewById(R.id.imgBannerCourseDetails)
        val name:TextView = findViewById(R.id.tvNameCourseDetails)
        val description:TextView = findViewById(R.id.tvDescriptionCourseDetails)
        val imgCreator:CircleImageView = findViewById(R.id.civCreatorImgCourseDetails)
        val creatorDetails:TextView = findViewById(R.id.tvCreatorDetailsCourseDetails)
        val courseDetails:TextView = findViewById(R.id.tvCourseDetailsCourseDetails)
        val rating:RatingBar = findViewById(R.id.ratingCourseCourseDetails)

        Glide.with(applicationContext).load(course!!.bannerUrl).into(imgBanner)
        name.text = course.name
        description.text = course.description
        Glide.with(applicationContext).load(course.creatorImgUrl).into(imgCreator)
        creatorDetails.text = "${course.creator}\n${course.creatorJob}"
        val topics = course.topics
        // Calcular el total de topics y videos
        val totalTopics = topics.size
        val totalVideos = topics.sumOf { it.videos.size }
        // Crear el texto con el total de topics y videos
        courseDetails.text = "$totalTopics Temas - $totalVideos Videos"
        rating.rating = course.qualification.toFloat()
    }

    // Puedes omitir este método si no necesitas personalizar el comportamiento de retroceso
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}