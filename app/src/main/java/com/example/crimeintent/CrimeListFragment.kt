package com.example.crimeintent

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.crimeintent.databinding.FragmentCrimeListBinding
private const val TAG = "CrimeListFragment"

class CrimeListFragment: Fragment(){
    private var _binding: FragmentCrimeListBinding? = null
    private val crimeListViewModel: CrimeListViewModel by viewModels()
    private val binding
        get() = checkNotNull(_binding)
        {"impossible d'accéder à binding car elle est null "}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Nombre de crimes: ${crimeListViewModel.incidents.size}")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCrimeListBinding.inflate(inflater, container, false)
        binding.crimeRecyclerView.layoutManager = LinearLayoutManager(context)
        val incidents = crimeListViewModel.incidents
        val adaptateur = CrimeListAdapter(incidents)
        binding.crimeRecyclerView.adapter = adaptateur
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
    _binding = null
    }
}