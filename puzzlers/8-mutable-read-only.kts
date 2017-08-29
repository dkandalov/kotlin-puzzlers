fun main(args: Array<String>) {

    val readonly = listOf(1, 2, 3)
    if (readonly is MutableList) {
        readonly.add(4)
    }
    println(readonly)

}

/*
A) [1, 2, 3]

B) [1, 2, 3, 4]

C) UnsupportedOperationException

D) doesn't compile
*/