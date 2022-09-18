import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max
import kotlin.math.min

//2022.9.18 16:42 시작
//2579번, 실버3 문제
//2022.9.18 18:04 종료
//정답참조 : https://hanyeop.tistory.com/297

//BufferReader를 통한 Input 속도 향상
val br = BufferedReader(InputStreamReader(System.`in`))
fun readNum() = br.readLine().toInt()
fun readNumList() = br.readLine().split(' ').map{it.toInt()}
fun readNumListWithNoSpace() = br.readLine().chunked(1).map{it.toInt()}.toIntArray()

fun main(args: Array<String>) {
    val n = readNum()

    val dp = Array(n+1){Array(10){0} }

    dp[1][0] = 0

    for(i in 1 until 10)
        dp[1][i] = 1

    for(i in 2 until n+1){
        for(j in 0 until 10){
            when(j){
                0 -> dp[i][j] = dp[i-1][1]
                9 -> dp[i][j] = dp[i-1][8]
                else -> dp[i][j] = (dp[i-1][j+1] + dp[i-1][j-1]) % 1_000_000_000
            }
        }
    }

    var sum = 0L
    dp[n].forEach { sum += it }
    println(sum % 1_000_000_000)
}

//
//  N=2
//  01  12  23  34  45  56  67  89
//      10  21  32  43  54  65  87  98
// 8 + 8

//  N=3
//  012 123 234 345 456 567 678 789
//  010 121 232 343 454 565 676 787 898
//      101 212 323 434 545 656 767 878 989
//          210 321 432 543 654 765 876 987
// 8 + 9 + 9 + 8
// 31

//  N=4
//  0123    1234    2345    3456    4567    5678    6789
//  0121    1232    2343    3454    4565    5676    6787    7898
//  0101    1212    2323    3434    4545    5656    6767    7878    8989
//          1012    2123    3234    4345    5456    6567    7678    8789
//          1010    2121    3232    4343    5454    6565    7676    8787    9898
//          1210    2321    3432    4543    5654    6765    7876    8987    9876
//                  2101    3212    4323    5434    6545    7656    8767    9878
//                          3210    4321    5432    6543    7654    8756    9876
// 7 + 8 + 9 + 8 + 9 + 9 + 8 + 7