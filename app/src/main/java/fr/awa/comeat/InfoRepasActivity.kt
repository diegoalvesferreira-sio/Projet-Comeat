package fr.awa.comeat

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class InfoRepasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_repas)

        val idRepas = intent.getIntExtra("id_repas", -1)
        val repas = Modele.getSesRepas().find { it.id == idRepas }

        val tvDate: TextView = findViewById(R.id.tv_date)
        val tvSpecialite: TextView = findViewById(R.id.tv_specialite)
        val tvHote: TextView = findViewById(R.id.tv_hote)
        val tvCouverts: TextView = findViewById(R.id.tv_couverts)

        repas?.let {
            tvDate.text = it.date.toString()
            tvSpecialite.text = it.specialite.libelle
            tvHote.text = it.hote.nom
            tvCouverts.text = it.nbCouverts.toString()
        }

        val btnSuivant: Button = findViewById(R.id.btn_suivant)
        btnSuivant.setOnClickListener {
            val intent = Intent(this, ConfirmationActivity::class.java)
            intent.putExtra("id_repas", idRepas)
            startActivity(intent)
        }
    }
}