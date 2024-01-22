package com.example.crimeintent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import com.example.crimeintent.databinding.FragmentCrimeDetailBinding
import java.util.Date
import java.util.UUID

class CrimeDetailFragment : Fragment() {
    private  var _binding: FragmentCrimeDetailBinding? = null
    private val binding
        get() = checkNotNull(_binding)
        {"impossible d'accéder à binding car elle est null "}
    private lateinit var incident: Crime
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        incident = Crime(
            id = UUID.randomUUID(),
            titre = " ",
            date = Date(),
            estResolu = false
        )
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //return super.onCreateView(inflater, container, savedInstanceState)
        _binding = FragmentCrimeDetailBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //lien avec l'EditText
        binding.apply {
            etTitreCrime.doOnTextChanged() { text, _, _, _ ->
                incident.copy(titre = text.toString())
            }
            btnDateCrime.apply {
                text = incident.date.toString()
                isEnabled = false
                }
            cbCrimeResolu.apply {
                isChecked = incident.estResolu
                setOnCheckedChangeListener { _, isChecked ->
                    incident.copy(estResolu = isChecked)
                }
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}