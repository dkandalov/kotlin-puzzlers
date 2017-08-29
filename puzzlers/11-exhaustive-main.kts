
    object Main {
        sealed class X
        class A: X()
        class B: X()
        class C: X()

        @JvmStatic fun main(args: Array<String>) {
            printClassOf(C())
        }

        fun printClassOf(x: X) = when (x) {
            is A -> println("is A")
            is B -> println("is B")
            is X -> println("is X")
        }.exhaustive

        val Unit.exhaustive get() = this
    }

/*
A) is X
B) throws IllegalStateException
C) doesn't compile
D) none of the above
*/