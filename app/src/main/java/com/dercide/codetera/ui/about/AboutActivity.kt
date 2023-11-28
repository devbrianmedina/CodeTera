package com.dercide.codetera.ui.about

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.dercide.codetera.R

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        // Configurar la Toolbar como ActionBar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Configurar el botón de regreso
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    // Puedes omitir este método si no necesitas personalizar el comportamiento de retroceso
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}