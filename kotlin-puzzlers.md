### Hello scala
[](https://github.com/angryziber/kotlin-puzzlers/blob/master/src/functions/kotlinVsScala/KotlinVsScala.kts)
```
fun main1() = println("Hello Kotlin")
fun main2() = {
    println("Hello Scala")
}
main1()
main2()
```

### Hello multiline world
[](http://stackoverflow.com/questions/32993586/templates-escaping-in-kotlin-multiline-strings/32994616#32994616)
If I want to use $ sign in multiline strings, how do I escape it?
`val condition = """ ... $eq ... """`
You would need to use a standard string with newlines
`" ...\n \$eq \n ... "`
or you could use the literal representation
`""" ... ${'$'}eq ... "`

### What am I
Mentioned by someone on kotlin slack channel.
```
val whatAmI = {}()
println(whatAmI)
```

### I am this
[](https://github.com/angryziber/kotlin-puzzlers/blob/master/src/functions/iAmThis/IAmThis.kts)
```
data class IAm(val foo: String) {
  fun hello() = foo.apply {
    return this
  }
}
println(IAm("bar").hello())
```

### Return return of power throw
```
throw throw throw Exception()
return return 42
fun `return return`() {
    return return
}
```

### Expressions or not?
```
var x = 0
val xx = x = 1

val f = fun(s: String) = s + "!"
println(f)

val c = class C
println(c)
```

### Null or empty?
```
fun main(args: Array<String>) {
    val s: String? = null
    if (s?.isEmpty()) println("is empty")
    if (s.isNullOrEmpty()) println("is null or empty")
} 
```

[](https://gist.github.com/npryce/e62036ab9b75538d5c5352d48727e191)
```
val s1 : String? = x?.toString()
val s2 : String? = x.toString()
```

### List or not?
[](https://github.com/angryziber/kotlin-puzzlers/blob/master/src/interop/aListIsNotAList/AListOrNotAList.kts)
``` kotlin
val x = listOf(1, 2, 3)
println(x is kotlin.collections.List<*>)
println(x is kotlin.collections.MutableList<*>)
println(x is java.util.List<*>)
```

### Collection equality
[](https://youtrack.jetbrains.com/issue/KT-8511)
```
println(listOf(1, 2, 3) == listOf(1, 2, 3)) // true
println(listOf(1, 2, 3).asSequence() == listOf(1, 2, 3).asSequence()) // false
println(sequenceOf(1, 2, 3) == sequenceOf(1, 2, 3)) // false
```

### Mutable read-only
[](https://github.com/angryziber/kotlin-puzzlers/blob/master/src/collections/javaMapping/readonly-to-mutable.kts)[]
```
val readonly = listOf(1, 2, 3)

if (readonly is MutableList) {
    readonly.add(4)
}
println(readonly)
```

### Defaulted map
[](https://youtrack.jetbrains.com/issue/KT-11851)
```
val map = mapOf<Any, Any>().withDefault{ "default" }
println(map["1"]) // output null
```

### Exhaustive when
```
sealed class X
class A : X()
class B : X()
class C : X()

fun main(args: Array<String>) {
    printClassOf(A())
    printClassOf(B())
    printClassOf(C())
}

fun printClassOf(x: X) {
    when (x) {
        is A -> println("is A")
        is B -> println("is B")
    }
}
```

### Exhaustive main
[Subclasses of sealed class have to be nested if defined inside a class](https://youtrack.jetbrains.com/issue/KT-17139https://youtrack.jetbrains.com/issue/KT-17139)

### Primitive overload
[](https://gist.github.com/npryce/b3710efcecd031b4321e6d4e7a58b8d0)
```
public class JavaClass {
	public void m(int value) {
		System.out.println("int: " + value);
	}

	public void m(Integer value) {
		System.out.println("Integer: " + value);
	}
}

fun main(args: Array<String>) {
    val javaClass = JavaClass()
    javaClass.m(42)
    javaClass.m(Integer(43))
    javaClass.m(null as Int?)
}
```

### Get me John
[](https://github.com/angryziber/kotlin-puzzlers/blob/master/src/properties/getMeJohn/GetMeJohn.kts)
```
class Person(name: String) {
    var name = name
        get() = if (name == "John") "Jaan" else name
}
// println(Person("John").name) <-- stack overflow
```

### 99 bottles
[](https://youtrack.jetbrains.com/issue/KT-10494)
```
package `99`

class Bottles()
val bottles = Bottles()

fun main(args: Array<String>) {
    println(bottles::class.java.canonicalName)
}
```



## More

### X
[](https://github.com/angryziber/kotlin-puzzlers/blob/master/src/interop/platformNulls/PlatformNulls.kt)
```
class Kotlin {
  fun hello(name: String) = print("Hello $name")
}

fun main(args: Array<String>) {
  val prop = System.getProperty("key")
  Kotlin().hello(prop)
}
```

### X
assertThat(End.add(2), equalTo(Node(2)))
// Error:(33, 9) Kotlin: None of the following functions can be called with the arguments supplied: 
// public fun <T> assertThat(actual: ???, criteria: Matcher<???>): Unit defined in com.natpryce.hamkrest.assertion
// public fun <T> assertThat(actual: Tree<Int>, criteria: KFunction1<Tree<Int>, Boolean>): Unit defined in com.natpryce.hamkrest.assertion

// This works
assertThat(End.add(2), equalTo<Tree<Int>>(Node(2)))

### X
from [](https://discuss.kotlinlang.org/t/1-plus-2-3/2182)
``` kotlin
println(-1 xor 3) //result: -4
println(-1.xor(3)) //result: -2

println(Integer.toBinaryString(-1))
println(Integer.toBinaryString(3))
println(Integer.toBinaryString(-1 xor 3))
println(Integer.toBinaryString(1 xor 3))
```

### X
-10.toByte() shouldEqual (-10).toByte()

### X
http://stackoverflow.com/questions/35272761/how-to-compare-two-arrays-in-kotlin/35275418#35275418

### X
val x: Any = Unit
if (x is Int && x is String) {
  x.length + x
}

### Weird chaining
https://github.com/angryziber/kotlin-puzzlers/tree/master/src/syntax/weirdChaining


### Gifs
https://images.duckduckgo.com/iu/?u=http%3A%2F%2Fwww.moillusions.com%2Fwp-content%2Fuploads%2F2013%2F11%2Fdaeb7c724d956013a0b2c411bd610dcf_original.gif&f=1
https://images.duckduckgo.com/iu/?u=https%3A%2F%2F38.media.tumblr.com%2F2960f5d32dc6bd525c374fe3a3f573aa%2Ftumblr_nbehznoMpK1qic3lco1_500.gif&f=1
https://www.facebook.com/photo.php?fbid=1189021667801492&set=a.427882653915401.87783.100000810112605&type=3&theater
https://images.duckduckgo.com/iu/?u=http%3A%2F%2Ftheunshaven.rooms.cwal.net%2FImages%2520fit%2520for%2520HTML%2520Posting%2520Madness%2FFractal%2520Teddies.gif&f=1
https://images.duckduckgo.com/iu/?u=http%3A%2F%2Filiketowastemytime.com%2Fsites%2Fdefault%2Ffiles%2Fmind-bending-gif-images11.gif&f=1
https://images.duckduckgo.com/iu/?u=http%3A%2F%2F38.media.tumblr.com%2Fa5fa1cd3d56640c03017cd8a3832225b%2Ftumblr_njsa5pajkt1qzbj7zo1_500.gif&f=1
https://images.duckduckgo.com/iu/?u=http%3A%2F%2Fgrowld.com%2Fwp-content%2Fuploads%2F2014%2F02%2Finfinity-doge.gif&f=1
https://images.duckduckgo.com/iu/?u=http%3A%2F%2Fwww.threadbombing.com%2Fdata%2Fmedia%2F67%2F20090523045404_auto.gif&f=1

https://media.giphy.com/media/xT9KVexx939mRgS8tG/giphy.gif
https://media.giphy.com/media/Ub8XEam5vXbMY/giphy.gif
https://media.giphy.com/media/c3XM8SZ4g2Teg/giphy.gif