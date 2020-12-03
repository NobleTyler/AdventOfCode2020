package dayThree

import Solution
import java.io.File
import java.io.InputStream
import java.math.BigInteger

class TobogganTrajectory:Solution {
    override fun process() : ArrayList<String> {
        val hillArray = arrayListOf<String>()
        val inputStream: InputStream = File("src/dayThree/input.txt").inputStream()
        inputStream.bufferedReader().useLines { lines -> lines.forEach {
            hillArray.add(it)
        }
    }
        return hillArray
    }
    //Moves 1 down and three right
    fun partOne(testHill: ArrayList<String> = process(),horizontal:Int,vertical:Int): Int {
        var accidents = 0
        val actor = Actor(testHill)
        while (actor.yPosition < actor.hillHeight){
             if(testHill[actor.yPosition][actor.xPosition] == '#'){
                 accidents++
             }
            actor.moveVertical(vertical)
            actor.moveHorizontal(horizontal)
        }
        return accidents
    }
    override fun partTwo(): BigInteger {
        val routeAccidents = mutableListOf<Int>()
        var accumulator = BigInteger("1")
        routeAccidents.add(partOne(process(),1,1))
        routeAccidents.add(partOne(process(),3,1))
        routeAccidents.add(partOne(process(),5,1))
        routeAccidents.add(partOne(process(),7,1))
        routeAccidents.add(partOne(process(),1,2))
        routeAccidents.forEach{num ->
            accumulator*=num.toBigInteger()
        }
        return accumulator
    }
}

class Actor(hillArray: ArrayList<String>) {

    //Could probably write some getters for this
    var xPosition = 0
    var yPosition = 0
    val hillWidth = hillArray[0].length
    val hillHeight = hillArray.size

    fun moveHorizontal(step: Int){
        xPosition+= step
        xPosition = Math.floorMod(xPosition,hillWidth)
    }
    fun moveVertical(step: Int){
        yPosition+= step
    }
}