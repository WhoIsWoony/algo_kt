import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

//2022.9.17 18:10 시작
//1149번, 실버1 문제
//2022.9.17 19:32 종료

//BufferReader를 통한 Input 속도 향상
val br = BufferedReader(InputStreamReader(System.`in`))
fun readNum() = br.readLine().toInt()
fun readNumList() = br.readLine().split(' ').map{it.toInt()}
fun readNumListWithNoSpace() = br.readLine().chunked(1).map{it.toInt()}.toIntArray()

fun main(args: Array<String>) {
    //1. 1번과 2번 집은 다른색
    //2. N번의 N-1번의 집은 다른색
    //3. 2 <= i <= N-1 집은 i-1번, i+1번 집과 다른색
    //N 집의수
    //RGB 색비용
    val n = readNum()

    //색칠하기 시작하는 집의 색의 비용(경로의 최소를 저장)
    val (R1,G1,B1) = readNumList()
    val (R2,G2,B2) = readNumList()
    var dp = arrayOf(
        R1+G2,
        R1+B2,
        G1+B2,
        G1+R2,
        B1+R2,
        B1+G2)
    for (i in 2 until n){
        //i번 집의 색칠 비용
        val (r,g,b) = readNumList()
        dp = arrayOf(
            min(dp[3]+g,dp[4]+g),
            min(dp[3]+b,dp[4]+b),
            min(dp[0]+b,dp[5]+b),
            min(dp[0]+r,dp[5]+r),
            min(dp[1]+r,dp[2]+r),
            min(dp[1]+g,dp[2]+g)
        )
    }


    var min = dp[0]
    for(i in 1 until 6){
        if(dp[i]<min)
            min=dp[i]
    }
    println(min)

}