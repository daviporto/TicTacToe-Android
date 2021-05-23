package com.example.tictactoe

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.tictactoe.databinding.DialogPlayer2AtributesBinding

class DialogPlayer2(val _activity:SinglePlayer): DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        super.onCreateDialog(savedInstanceState)

        val binding = DialogPlayer2AtributesBinding.inflate(requireActivity().layoutInflater)
        val builder =  AlertDialog.Builder(requireActivity())
        builder.setView(binding.root)


        binding.btnDone.setOnClickListener{
            _activity.player2.name = binding.txtName.text.toString()
            dismiss()
        }

        return builder.create()

    }
}