import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.text.StringBuilder

//2022.9.16 17:30 시작
//1025번, 브론즈5 문제
//2022.9.16 17:30 종료

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
    val originNum = readNum()
    var newNum = originNum
    var cycle = 0
    while(true)
    {
        val l = newNum / 10
        val r = newNum % 10
        newNum = (r.toString() + ((l+r)%10).toString()).toInt()
        cycle++
        if(newNum==originNum)
            break
    }
    println(cycle)
}