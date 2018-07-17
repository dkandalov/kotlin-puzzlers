// Observed by https://twitter.com/tom_puter
@file:Suppress("UNCHECKED_CAST")

fun <T> String.parse(): List<T> =
    this.split(",").map {
        try {
            it as T
        } catch (e: ClassCastException) {
            error("fail")
        }
    }

fun main(args: Array<String>) {
    val list = "a,b,c".parse<Int>()
    println(list)
    list.forEach {
        try {
            it + 1
        } catch (e: ClassCastException) {
            error("epic fail")
        }
    }
}

/*
A) fail

B) epic fail

C) ClassCastException

D) none of the above
*/