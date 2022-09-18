import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max
import kotlin.math.min

//2022.9.18 14:20 시작
//2579번, 실버3 문제
//2022.9.18 16:27 종료
//정답 참조 : https://hanyeop.tistory.com/288

//BufferReader를 통한 Input 속도 향상
val br = BufferedReader(InputStreamReader(System.`in`))
fun readNum() = br.readLine().toInt()
fun readNumList() = br.readLine().split(' ').map{it.toInt()}
fun readNumListWithNoSpace() = br.readLine().chunked(1).map{it.toInt()}.toIntArray()

fun main(args: Array<String>) {
    val n = readNum()

    val arr = Array(n+1){0}
    for (i in 1 until arr.size)
        arr[i] = readNum()

    val dp = Array(n+1){0}
    for(i in 1 until dp.size){
        when (i){
            1 -> dp[i] = arr[1]
            2 -> dp[i] = arr[1] + arr[2]
            else -> dp[i] = max(arr[i]+dp[i-2],arr[i]+arr[i-1]+dp[i-3])
        }
    }
    println(dp[n])
}