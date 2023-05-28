package easy

fun main() {

    println( Solution9().isPalindrome(-1))
}

 private class Solution9 {

     fun isPalindrome(x: Int): Boolean {
         var rev : Int = 0
         var temp : Int = x

         while (temp > 0){
             val digit = temp%10
             rev = (rev * 10) + digit
             temp /= 10
         }

         if (rev == x){
             return true
         }

         return false
    }
}