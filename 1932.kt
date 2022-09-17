import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max
import kotlin.math.min

//2022.9.17 19:35 시작
//1932번, 실버1 문제
//2022.9.17 19:32 종료

//BufferReader를 통한 Input 속도 향상
val br = BufferedReader(InputStreamReader(System.`in`))
fun readNum() = br.readLine().toInt()
fun readNumList() = br.readLine().split(' ').map{it.toInt()}
fun readNumListWithNoSpace() = br.readLine().chunked(1).map{it.toInt()}.toIntArray()

fun main(args: Array<String>) {

    //input
    val n = readNum()

    //init
    var dp = Array(n){0}

    //solve
    dp[0] = readNum()
    for(i in 1 until n)
    {
        val newDP = Array(n){0}
        val row = readNumList()
        newDP[0] = dp[0] + row[0]
        newDP[i] = dp[i-1] + row[i]
        for(i in 1 until i)
            newDP[i] = max(row[i]+dp[i-1],row[i]+dp[i])
        dp = newDP
    }

    var max = 0
    for(i in dp.indices)
         max = max(max,dp[i])
    print(max)
}