### Java puzzlers
[](https://www.amazon.com/Java-Puzzlers-Traps-Pitfalls-Corner/dp/032133678X)
[](http://www.syfy.com/sites/syfy/files/styles/2200xauto/public/kitaoka_circles.jpg?itok=Mwwov-en)


### Hello scala
The answer is `A` because `main2()` function has type `() -> Unit` and, therefore, 
its invocation will return a lambda object and won't print anything.
```
fun main1() = println("Hello Kotlin")
fun main2() {  <-- no "= {" here 
    println("Hello Scala")
}
main1()
main2()
```
[Origin](https://github.com/angryziber/kotlin-puzzlers/blob/master/src/functions/kotlinVsScala/KotlinVsScala.kts)
[Gif](https://giphy.com/gifs/cat-fail-quO0X65yj6gw0)


### Hello multiline world
The answer is `C` because `\$` doesn't escape dollar char in multiline strings.
To escape dollar use something like this `"""price: 100${'$'}"""`.
[Origin](http://stackoverflow.com/questions/32993586/templates-escaping-in-kotlin-multiline-strings/32994616#32994616)
[Gif](https://giphy.com/gifs/Jk4ZT6R0OEUoM)


### What am I
The answer is `B` because of the types:
```
val f: () -> Unit = {}
val whatAmI: Unit = f()
println(whatAmI)
```
Origin: mentioned by someone on kotlin slack channel.
[Gif](https://giphy.com/gifs/afv-funny-fail-lol-l41lPaVXzvGGMuAQ8)


### I am this
The answer is `C` because within `foo.apply{...}` lambda `this` refers to target object which is `foo`.
```
data class IAm(val foo: String) {
  fun hello() = foo.apply {
    return this
  }
}
println(IAm("bar").hello())
```
[Origin](https://github.com/angryziber/kotlin-puzzlers/blob/master/src/functions/iAmThis/IAmThis.kts)
[Gif](https://giphy.com/gifs/infinite-cube-fractal-mb3Ih9l0Oxub6)


### Return return of power throw
The answer is `A` because:
 - both `return 42` and `throw Exception()` have type `Nothing`
 - `Nothing` is subtype of all types, therefore, from type checker point of view
   `return <Nothing>` is ok because `Nothing` is subtype of `Int` and
   `throw <Nothing>` is ok because `Nothing` is subtype of `Exception`
 - at runtime only the rightmost expression is executed, i.e. `return 42` and `throw Exception`
```
fun f1(): Int {
    return return 42
}

fun f2() {
    throw throw Exception()
}
```
See [A Whirlwind Tour of the Kotlin Type Hierarchy](http://natpryce.com/articles/000818.html).
[Gif](https://giphy.com/gifs/imadeit-qKltgF7Aw515K)


### Expression or not?
The answer is `C` because variable assignment and class declaration are not expressions:
```
    var i = 0
    i = 42
    val j = i
    println(j)

    val f = fun() = 42
    println(f)

    class C
    val c = C::class.java
    println(c)
```
[Gif](https://giphy.com/gifs/funny-dog-fail-XEjgXErwfn0Bi)


### Null empty
The answer is `D` because `s?.isEmpty()` has type `Boolean?` which cannot be used in `if`.
The fix is use elvis operator `if (s?.isEmpty() ?: false) println("is empty")`
or explicit equality `if (s?.isEmpty() == ture) println("is empty")`.

[Similar issue](https://gist.github.com/npryce/e62036ab9b75538d5c5352d48727e191):
```
val x: Any? = null
val s1: String? = x?.toString()
val s2: String? = x.toString()

assertThat(s1, equalTo(s2))
```
[Gif](https://giphy.com/gifs/dog-fail-5VW5snb1OFkE8)


### List or not?
The answer is `C` because:
 - `kotlin.collections.List` on JVM compiled to `java.util.List` so 1st and 3rd options are `true`
 - `x is kotlin.collections.MutableList<*>` ends up calling `kotlin.jvm.internal.TypeIntrinsics.isMutableList`
   which also return `true`
[Origin](https://github.com/angryziber/kotlin-puzzlers/blob/master/src/interop/aListIsNotAList/AListOrNotAList.kts)
[Gif](https://giphy.com/gifs/shocked-ernie-bert-umMYB9u0rpJyE)


### Collection equality
The answer is `D` because sequences don't define equality 
(similar to iterators because they can only be consumed once and can be infinity).

[Origin](https://youtrack.jetbrains.com/issue/KT-8511)
[Gif](https://giphy.com/gifs/whoa-fractal-cuboid-13pu4qCsptlSpi)


### Mutable read-only
The answer is `C` because `listOf()` calls `Arrays.asList()` which returns unmodifiable collection.
The fix is to use `mutableListOf()` instead of `listOf()`.

[Origin](https://github.com/angryziber/kotlin-puzzlers/blob/master/src/collections/javaMapping/readonly-to-mutable.kts)
[Gif](https://giphy.com/gifs/inception-7pHTiZYbAoq40)


### Defaulted map
The answer is `C` because `withDefault` doesn't change behaviour of `Map.get()`.
If you used function with the same name in Scala or Groovy, forget about it.
The fix is to use `getOrDefault()`: 
```
var n = 42
val map = emptyMap<Any,Any>()
println(map.getOrDefault("missing key", n++))
println(map.getOrDefault("missing key", n++))
```
[Origin](https://youtrack.jetbrains.com/issue/KT-11851)
[Gif](https://giphy.com/gifs/football-skills-z75PUpyuVxcxa)


### Exhaustive when
The answer is `A` because `when` is only exhaustive if it's assigned to a value,
e.g. using `val Unit.exhaustive get() = this`.

[Gif](https://giphy.com/gifs/cheezburger-fail-other-water-YjWoK5F5R9ZRe)


### Exhaustive main
The answer is `C` because sealed subclasses still have to be nested if defined inside another class or object.
The fix is to make classes nested:
```
sealed class X {
	class A: X()
	class B: X()
	class C: X()
}
```
[Origin](https://youtrack.jetbrains.com/issue/KT-17139)
[Gif](https://giphy.com/gifs/cat-fail-animal-c3XM8SZ4g2Teg)


### Exhaustive enum
The answer is `D` because `Color.from` is extension function for enum instances not the class.
The fix:
```
enum class Color {
    Red, Green, Blue; // need semicolor here!
    companion object
}

fun Color.Companion.from(s: String) = when (s) {
    "#FF0000" -> Red
    "#00FF00" -> Green
    else -> null
}
```
[Gif](https://giphy.com/gifs/fractals-argWWdxS9uFUI)


### Primitive overload
The answer is `D` because `Integer` is not subtype of `Int`.
The fix is to use `43 as Int?`, then the answer will be `C`.

[Origin](https://gist.github.com/npryce/b3710efcecd031b4321e6d4e7a58b8d0)
[Gif](https://giphy.com/gifs/piglets-baby-pigs-4hdocBfTTLs9a)


### Package 99
The answer is `D`. This is a compiler bug.
The workaround is to use `val bottles = Bottles()` inside `main` function.

[Origin](https://youtrack.jetbrains.com/issue/KT-10494)
[Gif](https://giphy.com/gifs/5gZvwC0vCFpmg)


### Thank you slide
[Thank you gif](https://giphy.com/gifs/share-thankyou-thanksthankyou-4BylJD2QxStzO)



## More puzzlers

### Get me John
[Origin](https://github.com/angryziber/kotlin-puzzlers/blob/master/src/properties/getMeJohn/GetMeJohn.kts)
```
class Person(name: String) {
    var name = name
        get() = if (name == "John") "Jaan" else name
}
println(Person("John").name)
```

### X
[Origin](https://github.com/angryziber/kotlin-puzzlers/blob/master/src/interop/platformNulls/PlatformNulls.kt)
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
[Origin](https://discuss.kotlinlang.org/t/1-plus-2-3/2182)
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
```
val x: Any = Unit
if (x is Int && x is String) {
  x.length + x
}
```

### Weird chaining
https://github.com/angryziber/kotlin-puzzlers/tree/master/src/syntax/weirdChaining

### X
By [Ruslan Ibragimov](https://github.com/IRus) on Kotlin slack.
```
fun main(args: Array<String>) {
    val s = ""
    val i = 0
    val b = false
    
    println(s::class == String::class)
    println(i::class == Int::class)
    println(b::class == Boolean::class)

    fun test(a: Any) = when (a::class) {
        String::class -> println("String")
        Int::class -> println("Int")
        Boolean::class -> println("Boolean")
        else -> println("Else")
    }

    test(s)
    test(i)
    test(b)
}
```
Actual output:
```
true
true
true
String
Else
Else
```
The fix:
```
fun test(a: Any) = when (a::class) {
    String::class -> println("String")
    Int::class, Int::class.javaPrimitiveType -> println("Int")
    Boolean::class, Boolean::class.javaPrimitiveType -> println("Boolean")
    else -> println("Else")
}
```

### X
[](https://discuss.kotlinlang.org/t/puzzler-that-crushed-my-production/3845)
```
private fun foo(one: (String) -> Unit = {}, two: (String) -> Unit = {}) {
    one("one")
    two("two")
}

fun main(args: Array<String>) {
    foo({ print(it) })
    foo { print(it) } 
}
```


### X
[](https://medium.com/@trionkidnapper/kotlin-beware-the-silent-cast-5fed4f4c4aa6)
[](https://youtrack.jetbrains.com/issue/KT-18938)
```
val i = 10.5
if (i in 1..10) { 
    println("$i is within the range of 1-10")
} else {
    println("$i is not in range of 1-10")     
}
```

### X
IIRC mentioned by Duncan
```
class Bob {
    fun Bob.foo() = Unit
}

fun Any.foo() = when(this) {
    is Bob -> foo()
    else -> error("")
}

class Test {
    @Test fun `kills the JVM`() {
        Bob().foo()
    }
}
```