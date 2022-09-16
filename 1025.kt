import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max
import kotlin.math.sqrt
import kotlin.text.StringBuilder

//2022.9.16 14:50 시작
//1025번, 골드5 문제
//2022.9.16 17:24 종료
//참조블로그 : https://qgqg264.tistory.com/83

//BufferReader를 통한 Input 속도 향상
val br = BufferedReader(InputStreamReader(System.`in`))
fun readNum() = br.readLine().toInt()
fun readNumList() = br.readLine().split(' ').map{it.toInt()}
fun readNumListWithNoSpace() = br.readLine().chunked(1).map{it.toInt()}.toIntArray()


//StringBuilder를 통한 Output 속도 향상
val sb = StringBuilder()
//sb.append("결과값")...
//println(sb)

fun main(args: Array<String>) {
    fun isPerfectSqrt(n: Int): Boolean {
        val sr = sqrt(n.toDouble()).toLong()
        return sr * sr == n.toLong()
    }

    //N행 M열 테이블이 존재 (1<=(N,M)<=9)
    //서로 다른 1개 이상의 칸을 선택
    //행의 번호는 선택한 순서대로 등차수열
    //적힌수 를 이어붙이면 정수를 하나 만들 수 있음
    //가장 큰 완전 제곱수
    val (n, m) = readNumList()
    val table = Array(n) { IntArray(m) { 0 } }

    //배열 저장
    for (i in 0 until n){
        val row = readNumListWithNoSpace()
        for (j in 0 until m)
            table[i][j] = row[j]
    }

    var res = -1
    for (x in 0 until n){
        for (y in 0 until m) {
            for(vx in -n until n)
            {
                for(vy in -m until m)
                {
                    if(vx==0 && vy==0) continue
                    var num = ""
                    var px = x
                    var py = y
                    while((px in 0 until n) && (py in 0 until m)){
                        num += table[px][py]
                        if(isPerfectSqrt(num.toInt())) res = max(num.toInt(), res)
                        px+=vx
                        py+=vy
                    }
                    if (isPerfectSqrt(num.toInt()))  res = max(num.toInt(), res)
                }
            }
        }
    }
    print(res)
}