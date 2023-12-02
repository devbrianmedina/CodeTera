package com.dercide.codetera

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.dercide.codetera.databinding.ActivityMainBinding
import com.dercide.codetera.models.Comment
import com.dercide.codetera.models.Course
import com.dercide.codetera.models.Topic
import com.dercide.codetera.models.Video
import com.dercide.codetera.ui.about.AboutActivity
import com.dercide.codetera.ui.settings.SettingsActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    companion object {
        val courses = ArrayList<Course>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        /*

            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
         */
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_curses, R.id.nav_search, R.id.nav_categories, R.id.nav_plans, R.id.nav_contact, R.id.nav_feedback
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        courses.addAll(
            arrayOf(generateRandomCourse(1), generateRandomCourse(2), generateRandomCourse(3), generateRandomCourse(4))
        )
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_settings -> {
                val intent = Intent(this, SettingsActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.action_about -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    fun generateRandomCourse(id: Int): Course {
        val titleList = listOf("Curso de Programación", "Desarrollo Web Avanzado", "Introducción a Android")
        val briefDescriptionList = listOf("Aprende desde cero", "Domina las tecnologías modernas", "Conviértete en un desarrollador Android")
        val descriptionList = listOf("Descripción del curso 1", "Descripción del curso 2", "Descripción del curso 3")
        val topicNamesList = listOf("Programación Básica", "Frameworks Web", "Desarrollo Mobile")
        val videoNamesList = listOf("Video Introductorio", "Demostración Práctica", "Proyecto Final")
        val creatorList = listOf("Carlos Sánchez", "Ana Morales", "Javier Fernández")
        val creatorImgUrlList = listOf("https://randomuser.me/api/portraits/men/91.jpg", "https://randomuser.me/api/portraits/men/92.jpg", "https://randomuser.me/api/portraits/men/93.jpg")
        val creatorJobList = listOf("Desarrollador Senior", "Experto en Web", "Ingeniero Android")
        val commentNamesList = listOf("María Rodríguez", "Juan García", "Laura Martínez")
        val commentList = listOf("¡Gran curso!", "Muy informativo", "Recomendado para principiantes")
        val iconUrlList = arrayListOf<String>()
        for(i:Int in 1..5) {
            iconUrlList.add("https://patientflow.dercide.com/icons/icon$i.png")
        }
        val bannerUrlList = listOf("https://images.rawpixel.com/image_800/czNmcy1wcml2YXRlL3Jhd3BpeGVsX2ltYWdlcy93ZWJzaXRlX2NvbnRlbnQvbHIvcm00MjItMDczLWt6cGhnMjR1LmpwZw.jpg")
        val videoUrlList = listOf("https://patientflow.dercide.com/icons/vid1.mp4", "https://patientflow.dercide.com/icons/vid2.mp4", "https://patientflow.dercide.com/icons/vid3.mp4")
        val commentUrlList = listOf("https://randomuser.me/api/portraits/men/91.jpg", "https://randomuser.me/api/portraits/men/92.jpg", "https://randomuser.me/api/portraits/men/90.jpg")
        val priceRange: ClosedRange<Double> = 50.0..150.0
        val qualificationRange: ClosedRange<Double> = 1.0..5.0

        val random = Random.Default

        // Generar datos aleatorios
        val title = titleList.random()
        val briefDescription = briefDescriptionList.random()
        val description = descriptionList.random()
        val price = priceRange.start + (priceRange.endInclusive - priceRange.start) * random.nextDouble()
        val qualification = qualificationRange.start + (qualificationRange.endInclusive - qualificationRange.start) * random.nextDouble()
        val creator = creatorList.random()
        val creatorImgUrl = creatorImgUrlList.random()
        val creatorJob = creatorJobList.random()
        val iconUrl = iconUrlList.random()
        val bannerUrl = bannerUrlList.random()

        // Generar videos
        val videos = ArrayList<Video>()
        repeat(random.nextInt(2, 5)) {
            val videoName = videoNamesList.random()
            val video = Video(it + 1, videoName, videoUrlList.random())
            videos.add(video)
        }

        // Generar temas con videos
        val topics = ArrayList<Topic>()
        repeat(random.nextInt(2, 4)) {
            val topicName = topicNamesList.random()
            val topicVideos = videos.shuffled().take(random.nextInt(1, 3))
            val topic = Topic(it + 1, topicName, ArrayList(topicVideos))
            topics.add(topic)
        }

        // Generar comentarios
        val comments = ArrayList<Comment>()
        repeat(random.nextInt(3, 6)) {
            val commentName = commentNamesList.random()
            val commentText = commentList.random()
            val comment = Comment(it + 1, commentName, commentText, commentUrlList.random())
            comments.add(comment)
        }

        // Crear y devolver el curso
        return Course(
            id,
            title,
            briefDescription,
            description,
            topics,
            price,
            qualification,
            creator,
            creatorImgUrl,
            creatorJob,
            comments,
            iconUrl,
            bannerUrl
        )
    }
}