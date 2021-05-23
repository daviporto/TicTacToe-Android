package com.example.tictactoe

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.R
import android.R.drawable
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.fragment.app.DialogFragment
import com.example.tictactoe.databinding.DialogPlayer1AtributesBinding

class DialogPlayer1(val _activity:SinglePlayer): DialogFragment(),
    View.OnClickListener,
    Animation.AnimationListener{
    private var _binding:DialogPlayer1AtributesBinding? = null
    val binding get() = _binding!!
    private lateinit var fadeIn:Animation
    private lateinit var fadeOut:Animation

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        super.onCreateDialog(savedInstanceState)
        _binding = DialogPlayer1AtributesBinding.inflate(requireActivity().layoutInflater)
        val builder = AlertDialog.Builder(requireActivity())
        builder.setView(binding.root)

        binding.imgAndroid.setOnClickListener (this)
        binding.imgLinux.setOnClickListener(this)
        binding.btnDone.setOnClickListener(this)

        fadeIn = AnimationUtils.loadAnimation(this.context, R.anim.fade_in)
        fadeIn.setAnimationListener(this)

        fadeOut = AnimationUtils.loadAnimation(this.context, R.anim.fade_out)
        fadeOut.setAnimationListener(this)


        return builder.create()
    }

    override fun onClick(v: View?) {
        when(v?.id){
            binding.imgAndroid.id->{
                _activity.player1.image = MainActivity.androidImage
                if(binding.imgAndroid.alpha != 1f){
                    binding.imgAndroid.startAnimation(fadeIn)
                    binding.imgAndroid.alpha = 1f
                }
                if(binding.imgLinux.alpha != 0.5f){
                    binding.imgLinux.startAnimation(fadeOut)
                    binding.imgLinux.alpha = 0.5f
                }
            }
            binding.imgLinux.id->{
                _activity.player1.image = MainActivity.linuxImage
                if(binding.imgLinux.alpha != 1f){
                    binding.imgLinux.startAnimation(fadeIn)
                    binding.imgLinux.alpha = 1f
                }
                if(binding.imgAndroid.alpha != 0.5f){
                    binding.imgAndroid.startAnimation(fadeOut)
                    binding.imgAndroid.alpha = 0.5f
                }
            }
            binding.btnDone.id->{
                _activity.player1.name = binding.txtNome.text.toString()
                dismiss()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _activity.takeCarePlayer2()
    }

    override fun onAnimationStart(animation: Animation?) {

    }

    override fun onAnimationEnd(animation: Animation?) {

    }

    override fun onAnimationRepeat(animation: Animation?) {

    }

}