package fr.awa.comeat

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.time.LocalDate
import android.widget.DatePicker
import com.google.android.material.datepicker.MaterialDatePicker.Builder.datePicker
import java.time.format.DateTimeFormatter

class SelectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selection)

        val spinnerSpecialite: Spinner = findViewById(R.id.select_specialite)
        val specialites = Modele.getSpecialites()

        var dateRepas: LocalDate = LocalDate.now()
        var specialiteChoisie: SpecialiteCulinaire? = null


        val adaptateur = ArrayAdapter(this, android.R.layout.simple_spinner_item, specialites)
        adaptateur.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinnerSpecialite.adapter = adaptateur
        spinnerSpecialite.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                specialiteChoisie = specialites[position]

            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // rien à faire
            }
        }

        val btnDate: Button = findViewById(R.id.select_date)
        val tvDate: TextView = findViewById(R.id.aff_date)
        btnDate.setOnClickListener {
            val dateCourante = LocalDate.now()
            val annee = dateCourante.year
            val mois = dateCourante.monthValue - 1
            val jour = dateCourante.dayOfMonth

            val datePickerDialog = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { _: DatePicker, anneeSelect: Int, moisSelect: Int, jourSelect: Int ->
                    dateRepas = LocalDate.of(anneeSelect, moisSelect + 1, jourSelect)
                    tvDate.text = dateRepas.toString()

                    val formateur = DateTimeFormatter.ofPattern( "dd/MM/yyyy")
                    val dateFormatee = dateRepas.format( formateur )
                    tvDate.text = dateFormatee
                },
                annee, mois, jour
            )
            datePickerDialog.show()
            }
        val btnValider: Button = findViewById(R.id.valider)
        btnValider.setOnClickListener {
            val intent = Intent(this, ListeRepasDisponiblesActivity::class.java)
            intent.putExtra("specialite_repas", specialiteChoisie?.libelle)
            intent.putExtra("date_repas", dateRepas.toString())
            startActivity(intent)
        }
    }
}