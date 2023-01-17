package com.geovane.appnotas.model

import java.io.Serializable

data class Grades(
    var subject: String,
    var noteOne: Float,
    var noteTwo: Float,
    var noteThree: Float,
    var noteFour: Float
) : Serializable
