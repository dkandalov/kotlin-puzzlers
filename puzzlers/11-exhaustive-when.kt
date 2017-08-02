
    sealed class X
    class A : X()
    class B : X()
    class C : X()

    fun printClassOf(x: X) {
        when (x) {
            is A -> println("is A")
            is B -> println("is B")
        }
    }

    fun main(args: Array<String>) {
        printClassOf(A())
        printClassOf(B())
        printClassOf(C())
    }

/*
A) is A
   is B
B) throws IllegalStateException
C) doesn't compile
D) none of the above
*/