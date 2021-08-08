package com.jaca.jetpacktest.base

import android.graphics.Paint
import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("deleteLine")
fun bindDeleteLine(textView: TextView, deleteLine: Boolean) {
    if (deleteLine) {
        textView.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG or Paint.ANTI_ALIAS_FLAG
    } else {
        textView.paintFlags = 0
    }
}