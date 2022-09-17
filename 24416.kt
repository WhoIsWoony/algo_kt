import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.text.StringBuilder

//2022.9.17 16:21 시작
//1025번, 브론즈1 문제
//2022.9.17 16:43 종료

//BufferReader를 통한 Input 속도 향상
val br = BufferedReader(InputStreamReader(System.`in`))
fun readNum() = br.readLine().toInt()
fun readNumList() = br.readLine().split(' ').map{it.toInt()}
fun readNumListWithNoSpace() = br.readLine().chunked(1).map{it.toInt()}.toIntArray()

fun main(args: Array<String>) {
    //재귀함수 피보나치
    var c1 = 1
    fun fib(n:Int): Int {
        if(n==1 || n==2) return 1
        else {
            c1++
            return fib(n - 1) + fib(n - 2)
        }
    }

    //dp를 통한 피보나치
    var c2 = 0
    val dp = ArrayList<Int>()
    fun fibDP(n:Int):Int{
        dp.add(1)
        dp.add(1)
        for(i in 2 until n)
        {
            c2++
            dp.add(dp[dp.lastIndex-1] + dp[dp.lastIndex])
        }
        return dp[dp.lastIndex]
    }

    //함수 실행
    var n = readNum()
    fib(n)
    fibDP(n)
    print("$c1 $c2")

}