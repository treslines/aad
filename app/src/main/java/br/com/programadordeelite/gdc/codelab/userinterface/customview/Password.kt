package br.com.programadordeelite.gdc.codelab.userinterface.customview

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import androidx.annotation.LayoutRes
import androidx.annotation.StyleableRes
import androidx.constraintlayout.widget.ConstraintLayout
import br.com.programadordeelite.gdc.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.item_password.view.*
import kotlin.properties.Delegates

abstract class Password @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = R.style.CustomComponents_TextInputLayout,
    @LayoutRes layoutRes: Int = R.layout.item_password,
    @StyleableRes styleableRes: IntArray = R.styleable.PasswordItem
) : ConstraintLayout(context, attrs, defStyleAttr, defStyleRes) {

    // +---------------------------------------------------------------------------------+
    // | ESCREVA SEU CÓDIGO ACOMPANHANDO A AULA NO YOUTUBE                               |
    // | JÁ APROVEITA E SEGUE O CANAL >> LINK PARA A AULA: https://youtu.be/fpNEife2cYo  |
    // +---------------------------------------------------------------------------------+
}