package fr.awa.comeat

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListeRepasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_liste_repas)

        val utilisateur = Modele.utilisateurConnecte
        val repasFiltres = Modele.getSesRepas().filter { repas ->
            utilisateur != null && repas.estConvive(utilisateur.id)
        }

        val rvrepas = findViewById<RecyclerView>(R.id.rv_repas)
        rvrepas.layoutManager = LinearLayoutManager(this)
        rvrepas.adapter = RepasAdapteur(repasFiltres)

        val btnRetourMenu: Button = findViewById(R.id.btn_retour_menu)
        btnRetourMenu.setOnClickListener {
            val intent = Intent(this, MenuRepasActivity::class.java)
            startActivity(intent)
        }
    }
}