
    fun main(args: Array<String>) {
        JavaClass.m(42)
        JavaClass.m(Integer(43))
        JavaClass.m(null as Int?)
    }

/*
A) int: 42
   int: 43
   NullPointerException

B) Integer: 42
   Integer: 43
   Integer: null

C) int: 42
   Integer: 43
   Integer: null

D) doesn't compile
*/
