@file:Suppress("PackageDirectoryMismatch")
package expression_or_not


    var i = 0
    val j = i = 42
    println(j)

    val f = fun() = 42
    println(f)

    val c = class C
    println(c)


/*
A) 42
   () -> kotlin.Int
   class C
   
B) 42
   () -> kotlin.Int
   doesn't compile

C) doesn't compile
   () -> kotlin.Int
   doesn't compile

D) doesn't compile
   doesn't compile
   doesn't compile
*/
