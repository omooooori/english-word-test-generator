package common

import java.text.DecimalFormat

actual fun format(value: Int): String {
    val formatter = DecimalFormat("#,###")
    return formatter.format(value)
}
