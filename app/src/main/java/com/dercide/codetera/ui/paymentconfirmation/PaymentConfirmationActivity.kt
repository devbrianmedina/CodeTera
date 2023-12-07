package com.dercide.codetera.ui.paymentconfirmation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.widget.Toolbar
import com.dercide.codetera.MainActivity
import com.dercide.codetera.R

class PaymentConfirmationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_confirmation)

        // Configurar la Toolbar como ActionBar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Configurar el botón de regreso
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val btnHome:Button = findViewById(R.id.btnBackHomePaymetConfirm)
        btnHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    // Puedes omitir este método si no necesitas personalizar el comportamiento de retroceso
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}