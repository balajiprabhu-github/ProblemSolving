package easy

fun main() {
    println(Solution412().fizzBuzz(60).toString())
}

private class Solution412 {
    fun fizzBuzz(n: Int): List<String> {
        val result = mutableListOf<String>()

        for(i in 1..n) {
            val sb = StringBuilder("")

            if(i%3 == 0){
                sb.append("Fizz")
            }

            if(i%5 == 0){
                sb.append("Buzz")
            }

            if(sb.toString().isEmpty()){
                sb.append(i)
            }

            result.add(sb.toString())
        }

        return result

    }

}