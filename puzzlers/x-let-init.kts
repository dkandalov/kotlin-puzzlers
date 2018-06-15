@file:Suppress("ReplaceSingleLineLet")

class Foo {
    val i1 = 1.let { it * 10 }
    val sum = { i1 + i2 }()
    val i2 = 2.let { it * 10 }
}

val foo = Foo()
println(foo.i1)
println(foo.i2)
println(foo.sum)

/*
A) 10; 20; 30

B) 10; 20; 10

C) 10; 20; 3

D) none of the above
*/