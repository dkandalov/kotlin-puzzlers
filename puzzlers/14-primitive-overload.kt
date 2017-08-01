
    fun main(args: Array<String>) {
        JavaClass.m(42)
        JavaClass.m(43 as Int?)
        JavaClass.m(null as Int?)
    }

/*
A) int: 42
   Integer: 43
   Integer: null

B) Integer: 42
   Integer: 43
   Integer: null
   
C) Integer: 42
   Integer: 43
   NullPointerException

D) doesn't compile

*/
