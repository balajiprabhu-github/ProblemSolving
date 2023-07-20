package medium

import java.util.*


fun main() {
    println(Solution735().asteroidCollision(intArrayOf(5,10,-5,-10)).contentToString())
    println(Solution735().asteroidCollision(intArrayOf(5,10,-5)).contentToString())
    println(Solution735().asteroidCollision(intArrayOf(10,2,1,-5)).contentToString())
    println(Solution735().asteroidCollision(intArrayOf(8,-8)).contentToString())
    println(Solution735().asteroidCollision(intArrayOf(-2,-1,1,2)).contentToString())
    println(Solution735().asteroidCollision(intArrayOf(-2,-2,1,-2)).contentToString())
}

private class Solution735 {
    fun asteroidCollision(asteroids: IntArray): IntArray {
        val stack = mutableListOf<Int>()

        for (asteroid in asteroids) {
            var collided = false

            while (stack.isNotEmpty() && asteroid < 0 && stack.last() > 0) {
                val topAsteroid = stack.last()
                if (topAsteroid == -asteroid) {
                    stack.removeAt(stack.size - 1)
                    collided = true
                    break
                } else if (topAsteroid > -asteroid) {
                    collided = true
                    break
                } else {
                    stack.removeAt(stack.size - 1)
                }
            }

            if (!collided) {
                stack.add(asteroid)
            }
        }

        return stack.toIntArray()
    }

}