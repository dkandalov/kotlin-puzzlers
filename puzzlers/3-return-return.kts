@file:Suppress("UNREACHABLE_CODE", "unused")

fun f1(): Int {
    return return 42
}

fun f2() {
    throw throw Exception()
}

fun `return return`() {
    return return
}

fun `unit of nothing`() {
    return throw throw return
}

/*
A) returns 42; throws exception

B) returns 42; doesn't compile

C) doesn't compile; throws exception

D) doesn't compile; doesn't compile
*/

