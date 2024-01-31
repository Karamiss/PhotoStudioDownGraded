package com.example.alena6.core.presentation.PhotoPrinting.PhotoPrinting

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import android.widget.Button
import android.widget.LinearLayout
import androidx.annotation.ColorRes
import com.example.alena6.R

class CustomSizeForm : LinearLayout {
    private var size: Size = Size._10x15

    constructor(context: Context?) : super(context) {
        init()
    }
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){
        init()
    }
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ){
        init()
    }

    private fun init() {
        inflate(context, R.layout.size_view, this)


        val button1 = findViewById<Button>(R.id.buttonSize1)
        val button2 = findViewById<Button>(R.id.buttonSize2)

        button1.changeState(R.color.yellow)
        button2.changeState(R.color.white)

        button1.setOnClickListener {
            button1.changeState(R.color.yellow)
            button2.changeState(R.color.white)
            size = Size._10x15
        }

        button2.setOnClickListener {
            button1.changeState(R.color.white)
            button2.changeState(R.color.yellow)
            size = Size._20x30
        }

    }


}

fun Button.changeState(@ColorRes resId: Int) {
    backgroundTintList = ColorStateList.valueOf(context.getColor(resId))
}

enum class Size {
    _10x15,
    _20x30;

    override fun toString(): String {
        return name.substring(1)
    }}

//TODO: Добавить customView (крч создать ещё такие же категории для каждой категории(типа)