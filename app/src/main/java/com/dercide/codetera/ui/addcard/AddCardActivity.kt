package com.dercide.codetera.ui.addcard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.widget.Toolbar
import com.dercide.codetera.R

class AddCardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_card)

        // Configurar la Toolbar como ActionBar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Configurar el botón de regreso
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val btnAdd:Button = findViewById(R.id.btnAddCard)
        btnAdd.setOnClickListener {
            finish()
        }
    }

    // Puedes omitir este método si no necesitas personalizar el comportamiento de retroceso
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}