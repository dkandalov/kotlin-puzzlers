
    fun main(args: Array<String>) {
        val world = "multiline world"
        println("""
            Hello
            ${'$'}world
        """.trimIndent())
    }

/*
A) >Hello
   >$world

B) >
   >      Hello
   >      $world
   >

C) >Hello
   >\multiline world

D) doesn't compile
*/
