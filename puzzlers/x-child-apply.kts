@file:Suppress("unused", "MemberVisibilityCanPrivate")


open class Node(val name: String) {
    fun lookup() = "lookup in: $name"
}

class Example : Node("container") {
    fun createChild(name: String): Node? = Node(name)

    val child1 = createChild("child1")?.apply {
        println("child1 ${lookup()}")
    }
    val child2 = createChild("child2").apply {
        println("child2 ${lookup()}")
    }
}

Example()

/*
A) child1 lookup in: child1
   child2 lookup in: child2

B) child1 lookup in: child1
   child2 lookup in: container

C) child1 lookup in: container
   child2 lookup in: child2

D) none of the above
*/

// By Roman Dawydkin (@beholder)