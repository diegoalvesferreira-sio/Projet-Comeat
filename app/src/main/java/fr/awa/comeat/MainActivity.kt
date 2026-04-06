package fr.awa.comeat

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import fr.awa.comeat.ui.theme.ComeatTheme
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val saisieEmail: EditText = findViewById(R.id.email)
        val saisieMdp: EditText = findViewById(R.id.mdp)
        val boutonConnecter: Button = findViewById(R.id.connecter)
        val boutonAnnuler: Button = findViewById(R.id.annuler)

        boutonConnecter.setOnClickListener {
            val email: String = saisieEmail.text.toString()
            val mdp: String = saisieMdp.text.toString()

            val utilisateur = Modele.findUtilisateur(email, mdp)
            if (utilisateur != null) {
                Modele.utilisateurConnecte = utilisateur
                Toast.makeText(this, "Bienvenue ${utilisateur.prenom} !", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MenuRepasActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Email ou mot de passe incorrect.", Toast.LENGTH_SHORT).show()
            }
        }

        boutonAnnuler.setOnClickListener {
            saisieEmail.setText("")
            saisieMdp.setText("")
        }
    }
}

