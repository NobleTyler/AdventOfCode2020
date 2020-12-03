package dayThree

import Solution
import java.io.File
import java.io.InputStream

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
                println("${actor.xPosition}-X and ${actor.yPosition+1}-Y  is ${testHill[actor.yPosition][actor.xPosition]}")
                 accidents++
             }
            actor.moveVertical(vertical)
            actor.moveHorizontal(horizontal)
        }
        println(testHill[322])
        return accidents
    }
    override fun partTwo(){

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
    fun reset(){
        xPosition = 0
        yPosition = 0
    }
}