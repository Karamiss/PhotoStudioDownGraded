package com.example.alena6.core.presentation.PhotoPrinting.PhotoPrinting

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import android.widget.Button
import android.widget.LinearLayout
import androidx.annotation.ColorRes
import com.example.alena6.R
// TODO: [!!!] Печать на сувенирах
class CustomSouvenirPrintForm : LinearLayout {
    private var souvenirType: SouvenirType = SouvenirType.RECTANGULAR_PUZZLE

    constructor(context: Context?) : super(context) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init()
    }

    private fun init() {
        inflate(context, R.layout.souvenir_print_view, this)

        val button1 = findViewById<Button>(R.id.buttonSouvenirType1)
        val button2 = findViewById<Button>(R.id.buttonSouvenirType2)

        button1.changeState(R.color.yellow)
        button2.changeState(R.color.white)

        button1.setOnClickListener {
            button1.changeState(R.color.yellow)
            button2.changeState(R.color.white)
            souvenirType = SouvenirType.RECTANGULAR_PUZZLE
        }

        button2.setOnClickListener {
            button1.changeState(R.color.white)
            button2.changeState(R.color.yellow)
            souvenirType = SouvenirType.HEART_PUZZLE
        }
    }
}

// Enum для типов сувениров
enum class SouvenirType {
    RECTANGULAR_PUZZLE,
    HEART_PUZZLE
}