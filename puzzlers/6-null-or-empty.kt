import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo

fun main(args: Array<String>) {
    val s: String? = null
    //if (s?.isEmpty()) println("is empty")
    if (s.isNullOrEmpty()) println("is null or empty")

    f()
}


fun f() {

    val x: Any? = null
    val s1: String? = x?.toString()
    val s2: String? = x.toString()

    assertThat(s1, equalTo(s2))

}

/*
A) is empty
   is null or empty

B) is null or empty

C) prints nothing

D) doesn't compile
*/
