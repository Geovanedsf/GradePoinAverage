package com.geovane.appnotas.model

import java.io.Serializable

data class DataCalculate(
    var name: String,
    var result: Float,
    var subject: String
) : Serializable
