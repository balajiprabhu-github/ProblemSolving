package easy


fun main() {
    println(Solution2469().convertTemperature(36.50).toList().toString())
    println(Solution2469().convertTemperature(122.11).toList().toString())
}

private class Solution2469 {
    fun convertTemperature(celsius: Double): DoubleArray {
        return DoubleArray(2).apply{
            this[0] = celsius + 273.15
            this[1] = celsius * 1.80 + 32.00
        }
    }
}