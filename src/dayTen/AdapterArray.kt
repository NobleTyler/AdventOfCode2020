package dayTen

import Solution
import java.io.File
import java.io.InputStream

class AdapterArray(private val inputFile: String) : Solution{
    private val adapters = process().sorted()
    fun process(): MutableList<Int> {
        val inputStream: InputStream = File(inputFile).inputStream()
        val ret = mutableListOf<Int>()
        inputStream.bufferedReader().useLines { lines -> lines.forEach { ret.add(it.toInt()) } }
        ret.plus(0).plus(ret.maxOrNull()!!+3)
        return ret
    }

    override fun partOne(): Int {
        val buckets = mutableListOf(1,1,1)
        for(i in 0 until adapters.size-1){
            when {
                adapters[i + 1] == adapters[i] + 3 -> buckets[2]++
                adapters[i + 1] == adapters[i] + 2 -> buckets[1]++
                adapters[i + 1] == adapters[i] + 1 -> buckets[0]++
            }
        }

        return buckets[0]*buckets[2]
    }

    override fun partTwo(): Int {
        val pathsByAdapter: MutableMap<Int,Long> = mutableMapOf(0 to 1L)
        adapters.drop(1).forEach{adapter ->
            pathsByAdapter[adapter] = (1..3).map {
                prev -> pathsByAdapter.getOrDefault(adapter - prev,0)
            }.sum()
        }
        return -1
    }

}