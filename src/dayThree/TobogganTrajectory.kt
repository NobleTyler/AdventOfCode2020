package dayThree

import Solution
import java.io.File
import java.io.InputStream

class TobogganTrajectory:Solution {
    override fun process(): MutableList<Pair<String,String>> {
        val inputStream: InputStream = File("src/dayThree/input.txt").inputStream()
        val passwordList = mutableListOf<Pair<String,String>>()
        inputStream.bufferedReader().useLines { lines -> lines.forEach {
            val entry = Pair(it.split(':')[0].trim(),it.split(':')[1].trim())
            passwordList.add(entry)} }
        return passwordList

    }
    override fun partOne(){
        return
    }
    override fun partTwo(){
        return
    }
}