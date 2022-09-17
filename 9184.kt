import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.text.StringBuilder

//2022.9.17 16:43 시작
//1025번, 브론즈1 문제
//2022.9.17 18:02 종료

//BufferReader를 통한 Input 속도 향상
val br = BufferedReader(InputStreamReader(System.`in`))
fun readNum() = br.readLine().toInt()
fun readNumList() = br.readLine().split(' ').map{it.toInt()}
fun readNumListWithNoSpace() = br.readLine().chunked(1).map{it.toInt()}.toIntArray()

fun main(args: Array<String>) {
    val table = Array(21){Array(21){Array(21){1} } }
    for(i in 1 until 21) {
        for(j in 1 until 21){
            for(k in 1 until 21){
                if(j in (i + 1) until k)
                    table[i][j][k] = table[i][j][k-1] + table[i][j-1][k-1] - table[i][j-1][k]
                else
                    table[i][j][k] = table[i-1][j][k] + table[i-1][j-1][k] + table[i-1][j][k-1] - table[i-1][j-1][k-1]
            }
        }
    }

    while(true){
        var (a,b,c) = readNumList()
        if(a==-1 && b==-1 && c==-1)
            break;
        else if(a<=0 || b<=0 || c<=0)
            println("w($a, $b, $c) = 1")
        else
        {
            if(a>20 || b>20 || c>20)
                println("w($a, $b, $c) = ${table[20][20][20]}")
            else
                println("w($a, $b, $c) = ${table[a][b][c]}")
        }
    }

}