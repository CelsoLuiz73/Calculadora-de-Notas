package com.celsoluiz73.calculadoranotas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.celsoluiz73.calculadoranotas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener {

            val numero1 = binding.etxNota1
            val numero2 = binding.etxNota2
            val numero3 = binding.etxNota3
            val numero4 = binding.etxNota4
            val faltas = binding.etxNumeroFaltas
            val resultado = binding.txtResultado

            val nota1 = Integer.parseInt(numero1.text.toString())
            val nota2 = Integer.parseInt(numero2.text.toString())
            val nota3 = Integer.parseInt(numero3.text.toString())
            val nota4 = Integer.parseInt(numero4.text.toString())
            val numeroFaltas = Integer.parseInt(faltas.text.toString())

            val mediaAluno = (nota1 + nota2 + nota3 + nota4) / 4

            if (mediaAluno >= 5 && numeroFaltas <= 20) {
                resultado.setText("Aluno foi aprovado \n Média final $mediaAluno")
                resultado.setTextColor(getColor(R.color.green))
            } else if (numeroFaltas > 20) {
                resultado.setText("Aluno foi reprovado por faltas \n Média final $mediaAluno")
                resultado.setTextColor(getColor(R.color.red))
            } else if (mediaAluno < 5) {
                resultado.setText("Aluno foi reprovado por Nota \n Média final $mediaAluno")
                resultado.setTextColor(getColor(R.color.red))
            }
        }
    }
}