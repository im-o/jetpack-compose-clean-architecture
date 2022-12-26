package com.rivaldy.id.core.util

import android.util.Log
import com.rivaldy.id.core.BuildConfig
import java.text.NumberFormat
import java.util.*

/** Created by github.com/im-o on 12/1/2022. */

object UtilFunctions {
    private val localeID = Locale("in", "ID")

    fun logE(message: String) {
        if (BuildConfig.DEBUG) Log.e("ERROR_IMO", message)
    }

    fun Long?.fromDollarToRupiah(): String {
        val localId = localeID
        val formatter = NumberFormat.getCurrencyInstance(localId)
        val fakeDollarToday = 15000
        val intValue = (this ?: 0) * fakeDollarToday
        return when {
            intValue > 0 -> formatter.format(intValue).replace(",00", "")
            intValue < 0 -> formatter.format(intValue).replace(",00", "")
            else -> "Rp0"
        }
    }
}