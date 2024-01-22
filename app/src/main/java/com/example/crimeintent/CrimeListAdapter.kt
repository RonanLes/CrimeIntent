package com.example.crimeintent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.crimeintent.databinding.ListItemCrimeBinding
class CrimeHolder (
    val binding: ListItemCrimeBinding) :
    RecyclerView.ViewHolder(binding.root) {
        fun bind(incident: Crime) {
            binding.apply {
                binding.crimeTitre.text = incident.titre
                binding.crimeDate.text = incident.date.toString()
                binding.root.setOnClickListener {
                    Toast.makeText(
                        itemView.context,
                        "${incident.titre} pressed!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
}
class CrimeListAdapter (private val incidents: List<Crime>)
    : RecyclerView.Adapter<CrimeHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrimeHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemCrimeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CrimeHolder(binding)

    }
    override fun onBindViewHolder(holder: CrimeHolder, position: Int) {
        val incident = incidents[position]
        holder.bind(incident)
    }
    override fun getItemCount() = incidents.size
}