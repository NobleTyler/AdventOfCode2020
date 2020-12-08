package dayFive

import Solution
import java.io.File
import java.io.InputStream

class BinaryBoarding(private val inputFile : String):Solution {
     fun process(): MutableList<String> {
        val inputStream: InputStream = File(inputFile).inputStream()
        val boardingList = mutableListOf<String>()
        inputStream.bufferedReader().useLines { lines -> lines.forEach { boardingList.add(it) } }
        return boardingList

    }

    fun calculateID(boardPass: String): Int =
            boardPass.map { if (it in setOf('B', 'R')) '1' else '0' }.joinToString("").toInt(2)

    override fun partOne(): Int? {
        return createIdList().maxOrNull()
    }

    private fun createIdList(): MutableList<Int> {
        val idList = mutableListOf<Int>()
        process().forEach {
            idList.add(calculateID(it))
        }
        return idList
    }
    override  fun partTwo(): Int{
        val listOfIds = createIdList()
        val maxSeats = 8*127
           for(i in 0..maxSeats){
               if(listOfIds.contains(i-1)&&listOfIds.contains(i+1)&&!listOfIds.contains(i))
                   return i
           }
        return 0
    }
}