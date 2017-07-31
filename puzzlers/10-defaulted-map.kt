@file:Suppress("ReplaceGetOrSet")

fun main(args: Array<String>) {

    var n = 42
    val map = emptyMap<Any,Any>().withDefault{ n++ }
    println(map["missing key"])
    println(map["missing key"])

}

interface SomeInterface<K,V> {

    /**
     * Returns the value corresponding to the given [key],
     * or `null` if such a key is not present in the map.
     */
    operator fun get(key: K): V?

}

/*
A) 42; 42

B) 42; 43

C) null; null

D) throws NPE
*/
