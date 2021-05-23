package com.example.tictactoe

import android.text.TextUtils

class Player(val id:Int) {
    var image = R.mipmap.linux_penguim
    var name = id.toString()
    set(value) {
        if(!TextUtils.isEmpty(value)) field = value
    }

}