package com.geovane.appnotas.model

import java.io.Serializable

data class Student(
    var name: String,
    var grades: Grades
) : Serializable
