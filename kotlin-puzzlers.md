### Java puzzlers
[](https://www.amazon.com/Java-Puzzlers-Traps-Pitfalls-Corner/dp/032133678X)
[](http://www.syfy.com/sites/syfy/files/styles/2200xauto/public/kitaoka_circles.jpg?itok=Mwwov-en)


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
[](https://giphy.com/gifs/cat-fail-quO0X65yj6gw0)


### Hello multiline world
[](http://stackoverflow.com/questions/32993586/templates-escaping-in-kotlin-multiline-strings/32994616#32994616)
```
fun main(args: Array<String>) {
    val world = "multiline world"
    println("""
        Hello
        \$world
    """.trimIndent())
}
```
[](https://giphy.com/gifs/Jk4ZT6R0OEUoM)

### What am I
Mentioned by someone on kotlin slack channel.
```
val whatAmI = {}()
println(whatAmI)
```
[](https://giphy.com/gifs/afv-funny-fail-lol-l41lPaVXzvGGMuAQ8)


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
[](https://giphy.com/gifs/infinite-cube-fractal-mb3Ih9l0Oxub6)


### Return return of power throw
```
fun f1(): Int {
    return return 42
}

fun f2() {
    throw throw Exception()
}
```
[](https://giphy.com/gifs/imadeit-qKltgF7Aw515K)


### Expressions or not?
```
var x = 0
val xx = x = 1

val f = fun(s: String) = s + "!"
println(f)

val c = class C
println(c)
```
[](https://giphy.com/gifs/funny-dog-fail-XEjgXErwfn0Bi)


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
val x: Any? = null
val s1: String? = x?.toString()
val s2: String? = x.toString()

assertThat(s1, equalTo(s2))
```
[](https://giphy.com/gifs/dog-fail-5VW5snb1OFkE8)


### List or not?
[](https://github.com/angryziber/kotlin-puzzlers/blob/master/src/interop/aListIsNotAList/AListOrNotAList.kts)
```
val x = listOf(1, 2, 3)
println(x is kotlin.collections.List<*>)
println(x is kotlin.collections.MutableList<*>)
println(x is java.util.List<*>)
```
[](https://giphy.com/gifs/shocked-ernie-bert-umMYB9u0rpJyE)


### Collection equality
[](https://youtrack.jetbrains.com/issue/KT-8511)
```
println(listOf(1, 2, 3) == listOf(1, 2, 3))
println(listOf(1, 2, 3).asSequence() == listOf(1, 2, 3).asSequence()) 
println(sequenceOf(1, 2, 3) == sequenceOf(1, 2, 3))
```
[](https://giphy.com/gifs/whoa-fractal-cuboid-13pu4qCsptlSpi)


### Mutable read-only
[](https://github.com/angryziber/kotlin-puzzlers/blob/master/src/collections/javaMapping/readonly-to-mutable.kts)[]
```
val readonly = listOf(1, 2, 3)

if (readonly is MutableList) {
    readonly.add(4)
}
println(readonly)
```
[](https://giphy.com/gifs/inception-7pHTiZYbAoq40)


### Defaulted map
[](https://youtrack.jetbrains.com/issue/KT-11851)
```
var n = 42
val map = emptyMap<Any,Any>().withDefault{ n++ }
println(map["missing key"])
println(map["missing key"])
```
[](https://giphy.com/gifs/football-skills-z75PUpyuVxcxa)


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
[](https://giphy.com/gifs/cheezburger-fail-other-water-YjWoK5F5R9ZRe)


### Exhaustive main
[](https://youtrack.jetbrains.com/issue/KT-17139https://youtrack.jetbrains.com/issue/KT-17139)
```
object Main {
    sealed class X {
        class A: X()
        class B: X()
        class C: X()
    }

    @JvmStatic fun main(args: Array<String>) {
        printClassOf(X.C())
    }

    fun printClassOf(x: X) = when (x) {
        is X.A -> println("is A")
        is X.B -> println("is B")
        is X -> println("is X")
    }.exhaustive

    val Unit.exhaustive get() = this
} 
```
[](https://giphy.com/gifs/cat-fail-animal-c3XM8SZ4g2Teg)


### Exhaustive enum
```
enum class Color {
    Red, Green, Blue
}

fun Color.from(s: String) = when (s) {
    "#FF0000" -> Red
    "#00FF00" -> Green
    else -> null
}

fun main(args: Array<String>) {
    println(Color.from("#00FF00"))
}
```
[](https://giphy.com/gifs/fractals-argWWdxS9uFUI)


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
    JavaClass.m(42)
    JavaClass.m(Integer(43))
    JavaClass.m(null as Int?)
}
```
[](https://giphy.com/gifs/piglets-baby-pigs-4hdocBfTTLs9a)


### Package 99
[](https://youtrack.jetbrains.com/issue/KT-10494)
```
package `99`

class Bottles()
val bottles = Bottles()

fun main(args: Array<String>) {
    println(bottles::class.java.canonicalName)
}
```
[](https://giphy.com/gifs/5gZvwC0vCFpmg)


## More

### Get me John
[](https://github.com/angryziber/kotlin-puzzlers/blob/master/src/properties/getMeJohn/GetMeJohn.kts)
```
class Person(name: String) {
    var name = name
        get() = if (name == "John") "Jaan" else name
}
println(Person("John").name)
```

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
```
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



[](https://giphy.com/gifs/share-thankyou-thanksthankyou-4BylJD2QxStzO)