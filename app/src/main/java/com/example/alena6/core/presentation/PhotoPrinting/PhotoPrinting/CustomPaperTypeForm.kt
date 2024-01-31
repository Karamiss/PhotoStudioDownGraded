package com.example.alena6.core.presentation.PhotoPrinting.PhotoPrinting

import android.content.Context
import android.util.AttributeSet
import android.widget.Button
import android.widget.LinearLayout
import com.example.alena6.R

class CustomPaperTypeForm : LinearLayout {
    private var paperType: PaperType = PaperType.MATTE

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
        inflate(context, R.layout.paper_type_view, this)

        val buttonMatte = findViewById<Button>(R.id.buttonMatte)
        val buttonGlossy = findViewById<Button>(R.id.buttonGlossy)

        buttonMatte.changeState(R.color.yellow)
        buttonGlossy.changeState(R.color.white)

        buttonMatte.setOnClickListener {
            buttonMatte.changeState(R.color.yellow)
            buttonGlossy.changeState(R.color.white)
            paperType = PaperType.MATTE
        }

        buttonGlossy.setOnClickListener {
            buttonMatte.changeState(R.color.white)
            buttonGlossy.changeState(R.color.yellow)
            paperType = PaperType.GLOSSY
        }
    }
}


enum class PaperType {
    MATTE,
    GLOSSY
}
