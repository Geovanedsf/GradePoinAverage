package com.geovane.appnotas.model

 open class BestNote(
    var name: String,
    var note: String
)

object MockBestNote {
    private val bestNote1 = BestNote("Joao", "10")
    private val bestNote2 = BestNote("zE", "9")
    private val bestNote3 = BestNote("Lukas", "7")
    var list = listOf(bestNote1, bestNote2, bestNote3)
}
