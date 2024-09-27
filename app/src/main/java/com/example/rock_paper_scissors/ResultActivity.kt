package com.example.rock_paper_scissors

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result_activity)

        val countFrom = intent.extras?.getString("count")
        val stateFrom = intent.extras?.getString("state")
        val choiceRandomLast = intent.extras?.getString("choiceRandom")
        val choicePlayerLast = intent.extras?.getString("choicePlayer")

        val state = findViewById<TextView>(R.id.tv_state)
        state.text = stateFrom
        val count = findViewById<TextView>(R.id.tv_count)
        count.text = countFrom
        val choices = findViewById<TextView>(R.id.tv_textChoices)
        choices.text = "$choiceRandomLast / $choicePlayerLast"

        val btnBack = findViewById<Button>(R.id.btn_back)
        btnBack.setOnClickListener {
            this.finish()
        }
    }
}