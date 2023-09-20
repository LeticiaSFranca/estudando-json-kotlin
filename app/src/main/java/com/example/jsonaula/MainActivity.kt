package com.example.jsonaula

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    lateinit var dadosAluno: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dadosAluno = findViewById(R.id.textView)

        val jsonData = applicationContext.resources.openRawResource(
            applicationContext.resources.getIdentifier(
                "json", "raw", applicationContext.packageName
            )
        ).bufferedReader().use { it.readText() }
        val outputJsonString = JSONObject(jsonData)
        Log.d("TAG_DATA", "" + outputJsonString)

        val posts = outputJsonString.getJSONArray("dadosAluno") as JSONArray

        for (i in 0 until posts.length()){
            //val id = posts.get.JSONObject(i).get("id")
            val disciplinaj = posts.getJSONObject(i).get("disciplina")
            val nomej = posts.getJSONObject(i).get("nome")
            val turmaj = posts.getJSONObject(i).get("turma")

            //disciplina.setText("" + disciplinaj)
            //nome.setText("" + nomej)
            //turma.setText("" + turmaj)

            var dados = "\nDisciplina->$disciplinaj\nNome->$nomej\nTurma->$turmaj\n"
            var ver = dadosAluno.text
            dadosAluno.text = ver.toString()+dados
        }
    }
}