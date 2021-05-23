package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.example.tictactoe.databinding.ActivitySinglePlayerBinding
import kotlin.random.Random

class SinglePlayer : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding:ActivitySinglePlayerBinding
    private val grade = arrayOf(0,0,0,0,0,0,0,0,0)
    val player1 = Player(1)
    val player2 = Player(2)
    var possitionsOccupied = 0

    private lateinit var currentPlayer:Player

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySinglePlayerBinding.inflate(layoutInflater)

        binding.btn0.setOnClickListener(this)
        binding.btn1.setOnClickListener(this)
        binding.btn2.setOnClickListener(this)
        binding.btn3.setOnClickListener(this)
        binding.btn4.setOnClickListener(this)
        binding.btn5.setOnClickListener(this)
        binding.btn6.setOnClickListener(this)
        binding.btn7.setOnClickListener(this)
        binding.btn8.setOnClickListener(this)


        setContentView(binding.root)
        takeCarePlayer1()
        currentPlayer = if(Random.nextInt(1) == 0) player1 else player2

    }

    fun takeCarePlayer1(){
        val d = DialogPlayer1(this)
            d.show(supportFragmentManager, "123")
    }

    fun takeCarePlayer2(){
        val d = DialogPlayer2(this)
        d.show(supportFragmentManager, "1234")
        if(player1.image === MainActivity.linuxImage) player2.image = MainActivity.androidImage else MainActivity.linuxImage
        binding.txtStatus.text = "jogando"
        binding.txtCurrentPlayer.text = currentPlayer.name
    }



    override fun onClick(v: View?) {
        when(v?.id){
            binding.btn0.id->{
                routine(0, binding.btn0)
            }

            binding.btn1.id->{
                routine(1, binding.btn1)
            }

            binding.btn2.id->{
                routine(2, binding.btn2)
            }

            binding.btn3.id->{
                routine(3, binding.btn3)
            }

            binding.btn4.id->{
                routine(4, binding.btn4)
            }
            binding.btn5.id->{
                routine(5, binding.btn5)
            }
            binding.btn6.id->{
                routine(6, binding.btn6)
            }

            binding.btn7.id->{
                routine(7, binding.btn7)
            }

            binding.btn8.id->{
                routine(8, binding.btn8)
            }


        }
    }

    fun routine(position:Int, v:ImageView){
        if(!verifyIsSelected(position)){
            v.setImageResource(currentPlayer.image)
            selectGrade(position)
            verifyEndGame()
            nextPlayer()
        }
    }


    fun nextPlayer(){
        currentPlayer = if(currentPlayer === player1) player2 else player1
        binding.txtCurrentPlayer.text = currentPlayer.name
    }

    fun verifyEndGame(){
        possitionsOccupied++
        if(possitionsOccupied == 9) velha()
        else{
            var end = 0
            //horizontais
            for (x in 0..2){
                end = grade[x * 3]
                if((end == grade[x * 3 + 1]) && (end == grade[x * 3 + 2]) && end !=0) won(end)
            }

            //verticais
            for (x in 0..2){
                end = grade[x + 0 * 3]
                if((end == grade[x + 1 * 3]) && (end == grade[x  + 2 * 3 ])&& end !=0) won(end)
            }
            //diagonal principal
            end = grade[0]
            if((end == grade[4]) && (end == grade[8])&& end !=0) won(end)

            //diagonal secundaria
            end = grade[2]
            if((end == grade[4]) && (end == grade[6])&& end !=0) won(end)
            }

    }

    fun won(who:Int){
        val winner = if(who == 1) player1 else player2
        val d = DialogEndGame(this, (getString(R.string.playerWon) + " " + winner.name), winner)
        d.show(supportFragmentManager, "11")
    }

    fun velha(){
        val d = DialogEndGame(this, getString(R.string.tie) , null)
        d.show(supportFragmentManager, "11")
    }

    fun selectGrade(position:Int){
        grade[position] = if(currentPlayer === player1) 1 else 2
    }

    fun verifyIsSelected(position:Int):Boolean{
        return grade[position] != 0
    }

    fun newGame(){
        grade.forEachIndexed { index, i ->grade[index] = 0 }

        binding.btn0.setImageResource(R.mipmap.pink_background_foreground)
        binding.btn1.setImageResource(R.mipmap.pink_background_foreground)
        binding.btn2.setImageResource(R.mipmap.pink_background_foreground)
        binding.btn3.setImageResource(R.mipmap.pink_background_foreground)
        binding.btn4.setImageResource(R.mipmap.pink_background_foreground)
        binding.btn5.setImageResource(R.mipmap.pink_background_foreground)
        binding.btn6.setImageResource(R.mipmap.pink_background_foreground)
        binding.btn7.setImageResource(R.mipmap.pink_background_foreground)
        binding.btn8.setImageResource(R.mipmap.pink_background_foreground)

        currentPlayer = if(Random.nextInt(1) == 0) player1 else player2
        binding.txtCurrentPlayer.text = currentPlayer.name
        possitionsOccupied = 0
    }

    fun menu(){
        finish()
    }

}