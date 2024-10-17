package com.example.fragmentnavigation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.fragmentnavigation.R
import com.example.fragmentnavigation.databinding.FragmentHomeBinding

class FragmentHome : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigationFragment2()
        pasarDatosFragment2()
    }

    private fun navigationFragment2(){
        binding.btnEnviarDatos.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentHome_to_fragment2)
        }
    }

    private fun pasarDatosFragment2() {
        binding.btnEnviarDatos.setOnClickListener {
            val dataEditTextName = binding.etName.text.toString()
            val dataEditTextNota1 = binding.etNota1.text.toString().toDoubleOrNull()
            val dataEditTextNota2 = binding.etNota2.text.toString().toDoubleOrNull()

            if (dataEditTextName.isEmpty() || dataEditTextNota1 == null || dataEditTextNota2 == null) {
                Toast.makeText(requireContext(), "Por favor, completa todos los campos.", Toast.LENGTH_SHORT).show()
            } else {
                val bundle = Bundle()
                bundle.putString("name", dataEditTextName)
                bundle.putString("nota1", dataEditTextNota1.toString())
                bundle.putString("nota2", dataEditTextNota2.toString())

                findNavController().navigate(R.id.action_fragmentHome_to_fragment2, bundle)
                limpiarCampos()
            }
        }
    }

    private fun limpiarCampos(){
        binding.etName.text.clear()
        binding.etNota1.text.clear()
        binding.etNota2.text.clear()
    }
}