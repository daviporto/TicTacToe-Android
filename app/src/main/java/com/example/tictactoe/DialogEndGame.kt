package com.example.tictactoe

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.tictactoe.databinding.DialogEndGameBinding

class DialogEndGame(val _activity:SinglePlayer, val text:String, val player: Player?): DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        super.onCreateDialog(savedInstanceState)

        val binding = DialogEndGameBinding.inflate(requireActivity().layoutInflater)
        val builder = AlertDialog.Builder(requireActivity())

        binding.txtResult.text = text
        binding.btnNewGame.setOnClickListener{
            dismiss()
            _activity.newGame()
        }

        binding.btnMenu.setOnClickListener{
            dismiss()
            _activity.menu()
        }


        player?.image?.let { binding.img.setImageResource(it) }


        builder.setView(binding.root)

        return builder.create()

    }

}