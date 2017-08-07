
    fun main(args: Array<String>) {
        val s: String? = null
        if (s?.isEmpty()) println("is empty")
        if (s.isNullOrEmpty()) println("is null or empty")
    }

/*
A) is empty
   is null or empty

B) is null or empty

C) prints nothing

D) doesn't compile
*/
