
    data class IAm(val foo: String) {
        fun hello() = foo.apply {
            return this
        }
    }
    println(IAm("bar").hello())

/*
A) IAm

B) IAm(foo=bar)

C) bar

D) Will not compile
*/
