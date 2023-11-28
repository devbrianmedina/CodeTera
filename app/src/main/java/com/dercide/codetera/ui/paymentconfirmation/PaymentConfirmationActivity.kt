package com.dercide.codetera.ui.paymentconfirmation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
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
    }

    // Puedes omitir este método si no necesitas personalizar el comportamiento de retroceso
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}