package com.dalvik.customloader

import androidx.annotation.ColorRes
import androidx.annotation.RawRes

class Data constructor(
    @RawRes var lottieAnimation: Int? = null,
    @ColorRes var progressColor: Int? = null
)