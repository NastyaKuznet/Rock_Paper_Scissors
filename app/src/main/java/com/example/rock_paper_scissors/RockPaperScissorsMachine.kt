package com.example.rock_paper_scissors

class RockPaperScissorsMachine {

    private var _countRandom: Int = 0
    private var _countPlayer: Int = 0
    private var _statePlayerInRound: StateGame = StateGame.NOBODY
    private var _choiceRandomLast: Choice = Choice.ROCK
    private var _choicePlayerLast: Choice = Choice.ROCK

    val countMachine
        get() = _countRandom

    val countPlayer
        get() = _countPlayer

    val statePlayerInRound
        get() = _statePlayerInRound

    val choiceRandomLast
        get() = _choiceRandomLast

    val choicePlayerLast
        get() = _choicePlayerLast

    fun chooseMade(choicePlayer: Choice){
        val choiceRandom = Choice.entries.random()

        if(choiceRandom == choicePlayer) {
            _statePlayerInRound = StateGame.NOBODY
        }else if(choiceRandom == Choice.ROCK && choicePlayer == Choice.SCISSORS ||
            choiceRandom == Choice.SCISSORS && choicePlayer == Choice.PAPER ||
            choiceRandom == Choice.PAPER && choicePlayer == Choice.ROCK) {
            _countRandom += 1
            _statePlayerInRound = StateGame.LOSE
        }else {
            _countPlayer += 1
            _statePlayerInRound = StateGame.WIN
        }
        _choicePlayerLast = choicePlayer
        _choiceRandomLast =choiceRandom
    }

    fun restart(){
        _countRandom = 0
        _countPlayer = 0
    }
}

enum class Choice(val str: String){
    ROCK("Камень"),
    PAPER("Бумага"),
    SCISSORS("Ножницы"),
}

enum class StateGame(val str: String) {
    WIN("Победа!"),
    LOSE("Проигрыш"),
    NOBODY("Ничья"),
}