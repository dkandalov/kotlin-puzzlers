
fun test() {

    val run: () -> Unit = {
        println("Run run run!")
    }

    object : Runnable {
        override fun run() = run()
    }.run()

}
test()

/*
A) Run run run!

B) doesn't compile

C) StackOverflowError

D) none of the above
*/