package fr.awa.comeat

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MenuRepasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_repas)

        val btnMesRepas : Button = findViewById(R.id.btn_mes_repas)
        btnMesRepas.setOnClickListener{
            val intent = Intent(this, ListeRepasActivity::class.java)
            startActivity( intent )
        }

        val btnRechercher : Button = findViewById(R.id.btn_rechercher)
        btnRechercher.setOnClickListener{
            val intent = Intent(this, SelectionActivity::class.java)
            startActivity( intent )
        }
    }
}