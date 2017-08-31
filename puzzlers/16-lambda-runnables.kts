
fun test() {
    val run: () -> Unit = {
        println("Hello World!")
    }

    object : Runnable {
        override fun run() = run()
    }.run()
}

/*

A) Hello World

B) Doesn't compile

C) StackOverflowError
 */