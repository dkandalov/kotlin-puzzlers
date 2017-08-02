
    println(listOf(1, 2, 3) == listOf(1, 2, 3))

    println(listOf(1, 2, 3).asSequence() == listOf(1, 2, 3).asSequence())

    println(sequenceOf(1, 2, 3) == sequenceOf(1, 2, 3))


/*
A) true; true; true

B) true; true; false

C) true; false; true

D) true; false; false

E) false; false; false
*/