package com.example.test

import android.content.res.Resources

fun pxToDp(px: Float): Float {
    return px / Resources.getSystem().displayMetrics.density
}
