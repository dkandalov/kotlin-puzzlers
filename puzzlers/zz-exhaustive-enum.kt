
    import Color.Green
    import Color.Red

    enum class Color {
        Red, Green, Blue;
        companion object
    }

    fun Color.Companion.from(s: String) = when (s) {
        "#FF0000" -> Red
        "#00FF00" -> Green
        else -> null
    }

    fun main(args: Array<String>) {
        println(Color.from("#00FF00"))
    }

/*
A) Green

B) Blue

C) null

D) doesn't compile
*/
