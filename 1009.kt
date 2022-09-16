import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

//1009번, 브론즈2 문제
//2022.9.16 13:50 시작
//2022.9.16 14:43 종료

//BufferReader를 통한 Input 속도 향상
val br = BufferedReader(InputStreamReader(System.`in`))
fun readNum() = br.readLine().toInt()
fun readNumList() = br.readLine().split(' ').map{it.toInt()}


//StringBuilder를 통한 Output 속도 향상
val sb = StringBuilder()
//sb.append("결과값")...
//println(sb)

fun main(args: Array<String>) {
    //테스트케이스 t
    val t = readNum()

    //컴퓨터개수 10대
    //총데이터 수 a^b
    // 1<=a<100
    // 1<=b<1_000_000
    //1...
    //2,4,8,6...
    //3,9,7,1...
    //4,6...
    //5...
    //6...
    //7,9,3,1...
    //8,4,2,6...
    //9,1...
    val table = arrayOf(
        intArrayOf(10),
        intArrayOf(1),
        intArrayOf(2,4,8,6),
        intArrayOf(3,9,7,1),
        intArrayOf(4,6),
        intArrayOf(5),
        intArrayOf(6),
        intArrayOf(7,9,3,1),
        intArrayOf(8,4,2,6),
        intArrayOf(9,1),
    )

    for (i in 0 until t){
        val (a, b) = readNumList()
        val row = table[a % 10]
        val result = row[(b-1)%row.size]
        println(result)
    }
}