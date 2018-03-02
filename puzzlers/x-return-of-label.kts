
// TODO
class Foo(val i: Int) {
    fun foo() {
        var i = 0
        i += Foo@i
        println(i)
    }
}

val f1 = wtf@{ n: Int -> wtf@(wtf@n + wtf@2) }
