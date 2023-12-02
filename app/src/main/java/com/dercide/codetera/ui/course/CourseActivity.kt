package com.dercide.codetera.ui.course

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.MediaController
import android.widget.ProgressBar
import android.widget.SeekBar
import android.widget.TextView
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.dercide.codetera.MainActivity
import com.dercide.codetera.R


class CourseActivity : AppCompatActivity() {

    private lateinit var videoView: VideoView
    private lateinit var playPauseButton: ImageView
    private lateinit var playPauseButton2: ImageView
    private lateinit var seekBar: SeekBar
    private lateinit var progress2:ProgressBar
    private lateinit var controlsLayout: View

    private var isPlaying = false
    private var duration = 0
    private var handler = Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course)

        val idCourse: Int = intent.extras!!.getInt("idCourse")
        val course = MainActivity.courses.find { it.id == idCourse }
        if(idCourse <= 0 || course == null) finish()

        // Configurar la Toolbar como ActionBar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val tvName:TextView = findViewById(R.id.tvNameCourse)
        val tvDescription:TextView = findViewById(R.id.tvDescriptionCourse)

        tvName.text = course!!.name
        tvDescription.text = course.briefDescription

        // Configurar el botón de regreso
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        videoView = findViewById(R.id.videoView)
        playPauseButton = findViewById(R.id.playPauseButton)
        playPauseButton2 = findViewById(R.id.playPauseButton2)
        seekBar = findViewById(R.id.seekBar)
        progress2 = findViewById(R.id.progress2)
        controlsLayout = findViewById(R.id.controlsLayout)

        //val videoPath = "android.resource://" + packageName + "/" + R.raw.flutter_vid1
        //videoView.setVideoPath(videoPath)
        videoView.setVideoURI(Uri.parse(course.topics.first().videos.first().url))

        videoView.setOnPreparedListener { mp: MediaPlayer? ->
            duration = mp!!.duration
            seekBar.max = duration
            progress2.max = duration
        }

        playPauseButton.setOnClickListener {
            if (isPlaying) {
                pauseVideo()
            } else {
                playVideo()
            }
        }

        playPauseButton2.setOnClickListener {
            if (isPlaying) {
                pauseVideo()
            } else {
                playVideo()
            }
        }

        videoView.setOnClickListener {
            toggleControlsVisibility()
        }

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    videoView.seekTo(progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        videoView.setOnCompletionListener {
            playPauseButton.setImageResource(R.drawable.ic_play)
            playPauseButton2.setImageResource(R.drawable.ic_play)
            isPlaying = false
            seekBar.progress = 0
            progress2.progress = 0
        }
    }

    private fun playVideo() {
        videoView.start()
        playPauseButton.setImageResource(R.drawable.ic_pause)
        playPauseButton2.setImageResource(R.drawable.ic_pause)
        isPlaying = true

        // Actualizar la barra de progreso
        handler.postDelayed(updateSeekBar, 0)

        // Ocultar controles después de 5 segundos (ajusta el tiempo según sea necesario)
        handler.postDelayed({
            if (isPlaying) {
                controlsLayout.visibility = View.GONE
            }
        }, 5000)
    }

    private fun pauseVideo() {
        videoView.pause()
        playPauseButton.setImageResource(R.drawable.ic_play)
        playPauseButton2.setImageResource(R.drawable.ic_play)
        isPlaying = false
    }

    private val updateSeekBar: Runnable = object : Runnable {
        override fun run() {
            seekBar.progress = videoView.currentPosition
            progress2.progress = videoView.currentPosition
            handler.postDelayed(this, 500) // actualizar cada 500 milisegundos
        }
    }

    private fun toggleControlsVisibility() {
        if (controlsLayout.visibility == View.VISIBLE) {
            controlsLayout.visibility = View.GONE
        } else {
            controlsLayout.visibility = View.VISIBLE
            // Ocultar controles después de 8 segundos (ajusta el tiempo según sea necesario)
            handler.postDelayed({
                if (isPlaying) {
                    controlsLayout.visibility = View.GONE
                }
            }, 8000)
        }
    }

    // Puedes omitir este método si no necesitas personalizar el comportamiento de retroceso
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}