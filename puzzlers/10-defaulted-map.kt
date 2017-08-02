@file:Suppress("ReplaceGetOrSet")

fun main(args: Array<String>) {

    var n = 42
    val map = emptyMap<Any,Any>().withDefault{ n++ }
    println(map["missing key"])
    println(map["missing key"])

}

/*
A) 42; 42

B) 42; 43

C) null; null

D) throws NPE
*/
