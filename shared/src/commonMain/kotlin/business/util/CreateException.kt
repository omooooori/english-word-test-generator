package business.util

import business.datasource.network.common.AlertResponse

const val THROWABLE_DIVIDER = "THROWABLE_DIVIDER"

fun AlertResponse.createException() = Throwable(" $THROWABLE_DIVIDER ${this.title} $THROWABLE_DIVIDER ${this.message}")
