package com.abhi.tictactoe

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.resultdialog.*

class GameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
    }
    fun btnClick(view : View){
        var CellId = 0
        val btnSelected = view as Button
        when(btnSelected.id){
            R.id.btn1 ->
                CellId = 1
            R.id.btn2 ->
                CellId = 2
            R.id.btn3 ->
                CellId = 3
            R.id.btn4 ->
                CellId = 4
            R.id.btn5 ->
                CellId = 5
            R.id.btn6 ->
                CellId = 6
            R.id.btn7 ->
                CellId = 7
            R.id.btn8 ->
                CellId = 8
            R.id.btn9 ->
                CellId = 9
        }
        playGame(CellId,btnSelected)
    }
    var activePlayer = 1
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    fun playGame(CellId : Int,btnSelected : Button){
        if(activePlayer == 1){
            btnSelected.text = "x"
//                btnSelected.currentTextColor = R.color.teal_200
            btnSelected.setBackgroundResource(R.drawable.playeronebox)
            player1.add(CellId)
            activePlayer = 4
        }else{
            btnSelected.text = "o"
//            btnSelected.setBackgroundResource(R.drawable.playeronebox)
            btnSelected.setBackgroundResource(R.drawable.playertwobox)
            player2.add(CellId)
            activePlayer = 1
        }
        btnSelected.isEnabled = false
        Checkwinner()
    }
    fun Checkwinner(){
        var winner = 10


//        AA ROW AA 1
        if(player1.contains(1) && player1.contains(2) && player1.contains(3)){
            winner = 1
        }
        if(player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winner = 2
        }


//        AA ROW AA 2
        if(player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winner = 1
        }
        if(player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winner = 2
        }


//        AA ROW AA 3
        if(player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winner = 1
        }
        if(player2.contains(7) && player2.contains(8) && player2.contains(9)){
            winner = 2
        }


//        AA COLOUM AA 1
        if(player1.contains(1) && player1.contains(4) && player1.contains(7)){
            winner = 1
        }
        if(player2.contains(1) && player2.contains(4) && player2.contains(7)){
            winner = 2
        }


//        AA COLOUM AA 2
        if(player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winner = 1
        }
        if(player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winner = 2
        }


//        AA COLOUM AA 3
        if(player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winner = 1
        }
        if(player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winner = 2
        }

////        AA COLOUM AA 1
//        if(player1.contains(1) && player1.contains(4) && player1.contains(7)){
//            winner = 1
//        }
//        if(player2.contains(1) && player2.contains(4) && player2.contains(7)){
//            winner = 2
//        }


//        AA DIAGONAL AA 1
        if(player1.contains(1) && player1.contains(5) && player1.contains(9)){
            winner = 1
        }
        if(player2.contains(1) && player2.contains(5) && player2.contains(9)){
            winner = 2
        }


//        AA DIAGONAL AA 2
        if(player1.contains(3) && player1.contains(5) && player1.contains(7)){
            winner = 1
        }
        if(player2.contains(3) && player2.contains(5) && player2.contains(7)){
            winner = 2
        }




        ////player.At
        if(winner == 1){
            val dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
//            hi
            dialog.setCancelable(false)
            dialog.setContentView(R.layout.resultdialog)
            dialog.winnertext.text = "PLAYER X WINS THE GAME"
            dialog.btne.setOnClickListener {
//                val intent = Intent(this,StartActivity::class.java)
//                startActivity(intent)
                finish()
            }
            dialog.btnplayagain.setOnClickListener {
                val intent = Intent(this,GameActivity::class.java)
                finish()
                startActivity(intent)
            }
            dialog.show()
            //            Toast.makeText(this,"aa player 1 win the game aa",Toast.LENGTH_LONG).show()
        }else if(winner == 2){
            val dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
//            hi
            dialog.setCancelable(false)
            dialog.setContentView(R.layout.resultdialog)
            dialog.winnertext.text = "PLAYER O WINS THE GAME"
            dialog.btne.setOnClickListener {
//                val intent = Intent(this,StartActivity::class.java)
//                startActivity(intent)
                finish()
            }
            dialog.btnplayagain.setOnClickListener {
                val intent = Intent(this,GameActivity::class.java)
                finish()
                startActivity(intent)
            }
            dialog.show()
            //            Toast.makeText(this,"aa player 1 win the game aa",Toast.LENGTH_LONG).show()
        }
        else if(player1.size + player2.size >= 9){
            val dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
//            hi
            dialog.setCancelable(false)
            dialog.setContentView(R.layout.resultdialog)
            dialog.winnertext.text = "THE GAME IS DRAW"
            dialog.btne.setOnClickListener {
//                val intent = Intent(this,StartActivity::class.java)
//                startActivity(intent)
                finish()
            }
            dialog.btnplayagain.setOnClickListener {
                val intent = Intent(this,GameActivity::class.java)
                finish()
                startActivity(intent)
            }
            dialog.show()
//                Toast.makeText(this,"aa player 1 and 2 both win the game aa",Toast.LENGTH_LONG).show()
        }
    }
}