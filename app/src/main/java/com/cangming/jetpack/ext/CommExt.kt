package com.cangming.jetpack.ext

import android.content.Context
import android.widget.Toast


/**
 * toast
 */
fun Any.toast(context: Context) =
    Toast.makeText(context, this.toString(), Toast.LENGTH_SHORT).show()


