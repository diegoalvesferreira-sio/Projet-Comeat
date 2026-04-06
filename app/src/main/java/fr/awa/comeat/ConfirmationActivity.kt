package fr.awa.comeat

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ConfirmationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation)

        val idRepas = intent.getIntExtra("id_repas", -1)
        val repas = Modele.getSesRepas().find { it.id == idRepas }

        val tvConfirmation: TextView = findViewById(R.id.tv_confirmation)
        repas?.let {
            tvConfirmation.text = "Confirmer votre inscription au repas ${it.specialite.libelle} du ${it.date}"
        }

        val btnConfirmer: Button = findViewById(R.id.btn_confirmer)
        btnConfirmer.setOnClickListener {
            repas?.let {
                val utilisateur = Modele.utilisateurConnecte
                if (utilisateur != null) {
                    it.inscrire(utilisateur)
                    tvConfirmation.text = "Inscription confirmée !"
                    btnConfirmer.isEnabled = false
                }
            }
        }

        val btnMesRepas: Button = findViewById(R.id.btn_mes_repas)
        btnMesRepas.setOnClickListener {
            val intent = Intent(this, ListeRepasActivity::class.java)
            startActivity(intent)
        }
    }
}