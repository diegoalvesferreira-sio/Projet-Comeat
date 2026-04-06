package fr.awa.comeat

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.time.LocalDate

class ListeRepasDisponiblesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_liste_repas_disponibles)

        val specialiteRepas = intent.getStringExtra("specialite_repas")
        val dateRepas = LocalDate.parse(intent.getStringExtra("date_repas"))

        val repasFiltres = Modele.getSesRepas().filter { repas ->
            repas.specialite.libelle == specialiteRepas &&
                    repas.date == dateRepas
        }

        val rvrepas = findViewById<RecyclerView>(R.id.rv_repas_proposes)
        rvrepas.layoutManager = LinearLayoutManager(this)

        val adapterRepas = RepasProposesAdapter(repasFiltres) { repas ->
            val intent = Intent(this, InfoRepasActivity::class.java)
            intent.putExtra("id_repas", repas.id)
            startActivity(intent)
        }
        rvrepas.adapter = adapterRepas
    }
}