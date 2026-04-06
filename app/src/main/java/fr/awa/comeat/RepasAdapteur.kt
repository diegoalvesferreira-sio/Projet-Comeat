package fr.awa.comeat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.time.format.DateTimeFormatter

class RepasAdapteur(private val lesrepas: List<Repas>) :
    RecyclerView.Adapter<RepasAdapteur.RepasViewHolder>() {

    class RepasViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvDate: TextView = view.findViewById(R.id.tv_date)
        val tvSpecialite: TextView = view.findViewById(R.id.tv_specialite)
    }

    override fun onCreateViewHolder(parent: ViewGroup , viewType: Int ): RepasViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate( R.layout.item_repas , parent, false)
        return RepasViewHolder( view )
    }

    override fun onBindViewHolder(holder: RepasViewHolder , position : Int ) {
        val repas = lesrepas.get( position )
        val formateur = DateTimeFormatter.ofPattern("dd/MM/yyyy")

        holder.tvDate.text= repas.date.format( formateur)
        holder.tvSpecialite.text = repas.specialite.libelle
    }

    override fun getItemCount(): Int {
        return lesrepas.size
    }
}