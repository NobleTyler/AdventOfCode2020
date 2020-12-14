package dayNine

import Solution
import java.io.File
import java.io.InputStream

class EncodingError(private val inputFile: String) : Solution{

    fun process(inputFile:String ): MutableList<String> {
        val inputStream: InputStream = File(inputFile).inputStream()
        val ret = mutableListOf<String>()
        inputStream.bufferedReader().useLines { lines -> lines.forEach { ret.add(it) } }
        return ret
    }

    private fun processToLong(): List<Long> = process(inputFile).map { it.toLong() }

    val inputList = processToLong()

    fun partOne(preamble :Int = 25): Long = inputList.windowed(preamble+1,1,false).first(){!it.preambleIsValid()}.last()

    private fun List<Long>.preambleIsValid(): Boolean{
        val target = this.last()
        val rest = this.dropLast(1).toSet()
        return rest.any{target - it in rest}
    }

    override fun partTwo(): Any? {
        return super.partTwo()
    }
}