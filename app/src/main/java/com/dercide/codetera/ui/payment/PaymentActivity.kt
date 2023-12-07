package com.dercide.codetera.ui.payment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.widget.Toolbar
import com.dercide.codetera.R
import com.dercide.codetera.ui.addcard.AddCardActivity
import com.dercide.codetera.ui.paymentconfirmation.PaymentConfirmationActivity

class PaymentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        // Configurar la Toolbar como ActionBar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Configurar el botón de regreso
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val llAdd: LinearLayout = findViewById(R.id.llAddCard)

        llAdd.setOnClickListener {
            val intent = Intent(this, AddCardActivity::class.java)
            startActivity(intent)
        }

        val btnPay:Button = findViewById(R.id.btnPayPayment)
        btnPay.setOnClickListener {
            val intent = Intent(this, PaymentConfirmationActivity::class.java)
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