@file:JvmName("MainKt")

fun main(args: Array<String>) = println("1")

object MainKt {
    @JvmStatic fun main(args: Array<String>) = println("2")
}

/*
A) 1

B) 2

C) 1; 2

D) Doesn't compile
*/