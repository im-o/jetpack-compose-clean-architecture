package com.rivaldy.id.core.util

import android.util.Log
import com.rivaldy.id.core.BuildConfig

/** Created by github.com/im-o on 12/1/2022. */

object UtilFunctions {
    fun logE(message: String) {
        if (BuildConfig.DEBUG) Log.e("ERROR_IMO", message)
    }
}