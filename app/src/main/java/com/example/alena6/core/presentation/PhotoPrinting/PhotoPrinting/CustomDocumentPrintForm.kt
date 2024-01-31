package com.example.alena6.core.presentation.PhotoPrinting.PhotoPrinting
// TODO: [!!!] Печать документов
import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import android.widget.Button
import android.widget.LinearLayout
import androidx.annotation.ColorRes
import com.example.alena6.R

class CustomDocumentPrintForm : LinearLayout {
    var documentFormat: DocumentFormat = DocumentFormat.A4
    var paperType: PaperType_1 = PaperType_1.GSM_80
    var printType: PrintType = PrintType.BLACK_AND_WHITE
    var laminationType: LaminationType = LaminationType.NO_LAMINATION
    var bindingType: BindingType = BindingType.NO_BINDING

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
        inflate(context, R.layout.document_print_view, this)

        val buttonFormat1 = findViewById<Button>(R.id.buttonDocumentFormat1)
        val buttonFormat2 = findViewById<Button>(R.id.buttonDocumentFormat2)
        val buttonPaperType1 = findViewById<Button>(R.id.buttonPaperType1)
        val buttonPaperType2 = findViewById<Button>(R.id.buttonPaperType2)
        val buttonPrintType1 = findViewById<Button>(R.id.buttonPrintType1)
        val buttonPrintType2 = findViewById<Button>(R.id.buttonPrintType2)
        val buttonLaminationType1 = findViewById<Button>(R.id.buttonLaminationType1)
        val buttonLaminationType2 = findViewById<Button>(R.id.buttonLaminationType2)
        val buttonBindingType1 = findViewById<Button>(R.id.buttonBindingType1)
        val buttonBindingType2 = findViewById<Button>(R.id.buttonBindingType2)

        buttonFormat1.changeState(R.color.yellow)
        buttonFormat2.changeState(R.color.white)
        buttonPaperType1.changeState(R.color.yellow)
        buttonPaperType2.changeState(R.color.white)
        buttonPrintType1.changeState(R.color.yellow)
        buttonPrintType2.changeState(R.color.white)
        buttonLaminationType1.changeState(R.color.yellow)
        buttonLaminationType2.changeState(R.color.white)
        buttonBindingType1.changeState(R.color.yellow)
        buttonBindingType2.changeState(R.color.white)

        buttonFormat1.setOnClickListener {
            buttonFormat1.changeState(R.color.yellow)
            buttonFormat2.changeState(R.color.white)
            documentFormat = DocumentFormat.A4
        }

        buttonFormat2.setOnClickListener {
            buttonFormat1.changeState(R.color.white)
            buttonFormat2.changeState(R.color.yellow)
            documentFormat = DocumentFormat.A3
        }

        buttonPaperType1.setOnClickListener {
            buttonPaperType1.changeState(R.color.yellow)
            buttonPaperType2.changeState(R.color.white)
            paperType = PaperType_1.GSM_80
        }

        buttonPaperType2.setOnClickListener {
            buttonPaperType1.changeState(R.color.white)
            buttonPaperType2.changeState(R.color.yellow)
            paperType = PaperType_1.GSM_300
        }

        buttonPrintType1.setOnClickListener {
            buttonPrintType1.changeState(R.color.yellow)
            buttonPrintType2.changeState(R.color.white)
            printType = PrintType.BLACK_AND_WHITE
        }

        buttonPrintType2.setOnClickListener {
            buttonPrintType1.changeState(R.color.white)
            buttonPrintType2.changeState(R.color.yellow)
            printType = PrintType.COLOR
        }

        buttonLaminationType1.setOnClickListener {
            buttonLaminationType1.changeState(R.color.yellow)
            buttonLaminationType2.changeState(R.color.white)
            laminationType = LaminationType.NO_LAMINATION
        }

        buttonLaminationType2.setOnClickListener {
            buttonLaminationType1.changeState(R.color.white)
            buttonLaminationType2.changeState(R.color.yellow)
            laminationType = LaminationType.FILM_125MICRONS
        }

        buttonBindingType1.setOnClickListener {
            buttonBindingType1.changeState(R.color.yellow)
            buttonBindingType2.changeState(R.color.white)
            bindingType = BindingType.NO_BINDING
        }

        buttonBindingType2.setOnClickListener {
            buttonBindingType1.changeState(R.color.white)
            buttonBindingType2.changeState(R.color.yellow)
            bindingType = BindingType.METALLIC_SPRING
        }
    }
}


enum class DocumentFormat {
    A4,
    A3
}


enum class PaperType_1 {
    GSM_80,
    GSM_300
}


enum class PrintType {
    BLACK_AND_WHITE,
    COLOR
}


enum class LaminationType {
    NO_LAMINATION,
    FILM_125MICRONS
}


enum class BindingType {
    NO_BINDING,
    METALLIC_SPRING
}