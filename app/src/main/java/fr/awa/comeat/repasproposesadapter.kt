package fr.awa.comeat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RepasProposesAdapter(private val lesRepas: List<Repas>,
                           private val onItemClickListener: (Repas) -> Unit) : RecyclerView.Adapter<RepasProposesAdapter.RepasViewHolder>() {

    class RepasViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val tvIdRepas: TextView = view.findViewById(R.id.tv_id_repas)
        val tvHote: TextView = view.findViewById(R.id.tv_hote)

        fun bind(repas: Repas, onItemClickListener: (Repas) -> Unit) {
            tvIdRepas.text = repas.specialite.libelle
            tvHote.text = repas.date.toString()

            view.setOnClickListener {
                onItemClickListener(repas)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepasViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_repas_propose,
            parent,
            false
        )
        return RepasViewHolder(view)
    }

    override fun getItemCount(): Int {
        return lesRepas.size
    }

    override fun onBindViewHolder(holder: RepasViewHolder, position: Int) {
        val repas = lesRepas.get(position)
        holder.bind(repas, onItemClickListener)
    }
}