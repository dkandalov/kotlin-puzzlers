@Suppress("PLATFORM_CLASS_MAPPED_TO_KOTLIN")

fun main(args: Array<String>) {
    val x = listOf(1, 2, 3)
    println(x is List<*>)
    println(x is MutableList<*>)
    println(x is java.util.List<*>)
}

/*
A) true; false; true

B) false; false; true

C) true; true; true

D) true; false; false
*/