package cn.okzyl.studyjamscompose

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.graphics.Color
import cn.okzyl.studyjamscompose.ui.theme.Orange
import java.math.BigDecimal

val buttons = arrayOf(
    arrayOf(
        ButtonModel("C", type = ButtonType.EMPTY),
        ButtonModel(type = ButtonType.DELETE, res = R.drawable.ic_delete),
        ButtonModel("%", type = ButtonType.PERCENT),
        ButtonModel(res = R.drawable.ic_chufa, type = ButtonType.SYMBOL, text = "/")
    ),

    arrayOf(
        ButtonModel("7"),
        ButtonModel("8"),
        ButtonModel("9"),
        ButtonModel(res = R.drawable.ic_chengfa, type = ButtonType.SYMBOL, text = "x")
    ),

    arrayOf(
        ButtonModel("4"),
        ButtonModel("5"),
        ButtonModel("6"),
        ButtonModel(res = R.drawable.ic_jianfa, type = ButtonType.SYMBOL, text = "-")
    ),
    arrayOf(
        ButtonModel("1"),
        ButtonModel("2"),
        ButtonModel("3"),
        ButtonModel(res = R.drawable.ic_jiafa, type = ButtonType.SYMBOL, text = "+")
    ),
    arrayOf(
        ButtonModel(type = ButtonType.CHANGE, res = R.drawable.ic_change),
        ButtonModel("0"),
        ButtonModel("."),
        ButtonModel(res = R.drawable.ic_dengyu, type = ButtonType.CALCULATE)
    ),
)

data class ButtonModel(
    val text: String = "",
    val enable: Boolean = true,
    val type: ButtonType = ButtonType.NUMBER,
    val res: Int? = null,
)

enum class ButtonType(val color: Color) {
    NUMBER(Color.Black), SYMBOL(Orange), CALCULATE(Color.White), DELETE(Orange),
    PERCENT(Orange), EMPTY(Orange), CHANGE(Orange)
}

data class CalculateState(
    val list: SnapshotStateList<CalculateUnit> = mutableStateListOf<CalculateUnit>(),
    val result: BigDecimal = BigDecimal("0"),
)

data class CalculateUnit(
    val text: String = "",
    val editing: Boolean = false,
) {
    companion object {
        fun from(text: String) = CalculateUnit(text)
    }
}