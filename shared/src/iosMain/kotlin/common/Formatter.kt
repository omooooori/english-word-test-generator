package common

import platform.Foundation.NSNumber
import platform.Foundation.NSNumberFormatter
import platform.Foundation.NSNumberFormatterDecimalStyle

actual fun format(value: Int): String {
    val numberFormatter = NSNumberFormatter()
    numberFormatter.numberStyle = NSNumberFormatterDecimalStyle
    return numberFormatter.stringFromNumber(NSNumber(value)) ?: ""
}
