@file:Suppress("MemberVisibilityCanPrivate")

class Foo {
    val s: String
    init {
        bar()
        s = "woof"
    }
    private fun bar() {
        println(s)
    }
}
Foo()

/*
A) null
B) empty string
C) doesn't compile
D) woof
*/

// From https://medium.freecodecamp.org/kotlin-pitfalls-and-how-to-avoid-them-7b0d3a2109ad