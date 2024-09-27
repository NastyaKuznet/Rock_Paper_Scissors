package com.example.rock_paper_scissors

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private val play: RockPaperScissorsMachine = RockPaperScissorsMachine()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnRock = findViewById<Button>(R.id.btn_rock)
        val btnScissors = findViewById<Button>(R.id.btn_scissors)
        val btnPaper = findViewById<Button>(R.id.btn_paper)
        val tvRestart = findViewById<TextView>(R.id.tv_restart)

        btnRock.setOnClickListener {
            clickChoice(Choice.ROCK)
        }
        btnScissors.setOnClickListener {
            clickChoice(Choice.SCISSORS)
        }
        btnPaper.setOnClickListener {
            clickChoice(Choice.PAPER)
        }

        tvRestart.setOnClickListener {
            clickRestart()
        }
    }

    private fun clickChoice(choice: Choice){
        play.chooseMade(choice)
        val count = findViewById<TextView>(R.id.tv_count)
        count.text = "${play.countMachine.toString()} : ${play.countPlayer.toString()}"

        val intent = Intent(this, ResultActivity::class.java).apply{
            val bundle = Bundle()
            bundle.putString("count", count.text.toString())
            bundle.putString("state", play.statePlayerInRound.str)
            bundle.putString("choiceRandom", play.choiceRandomLast.str)
            bundle.putString("choicePlayer", play.choicePlayerLast.str)
            putExtras(bundle)
        }
        startActivity(intent)
    }

    private fun clickRestart(){
        val count = findViewById<TextView>(R.id.tv_count)
        count.text = "0 : 0"
        play.restart()
    }
}