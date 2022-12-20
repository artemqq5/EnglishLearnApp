package com.entenses.sesnethsilgne.domain.models

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class Lesson(
    val label: String,
    val shortDesc: String,
    val content: String
) : Parcelable
