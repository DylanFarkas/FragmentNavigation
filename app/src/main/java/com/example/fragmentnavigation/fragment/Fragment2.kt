package com.example.fragmentnavigation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.fragmentnavigation.R
import com.example.fragmentnavigation.databinding.Fragment2Binding


class Fragment2 : Fragment() {

    private lateinit var binding: Fragment2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = Fragment2Binding.inflate(inflater)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        obtenerDatosFragmentHome()
        calcularNota()
    }

    private fun obtenerDatosFragmentHome(){
        binding.tvNameFragment2.text = arguments?.getString("name")
        binding.tvNota1Fragment2.text = arguments?.getString("nota1")
        binding.tvNota2Fragment2.text = arguments?.getString("nota2")
    }

    private fun calcularNota(){
        binding.btnCalcularNota.setOnClickListener {
            val nota1 = binding.tvNota1Fragment2.text.toString().toDouble()
            val nota2 = binding.tvNota2Fragment2.text.toString().toDouble()
            val promedio = (nota1 + nota2) / 2.0

            binding.tvPromedio.text = promedio.toString()
            if (promedio < 3.0) {
                Toast.makeText(requireContext(), "Reprobó",
                    Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Aprobó",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }
}