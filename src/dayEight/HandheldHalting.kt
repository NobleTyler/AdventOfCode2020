package dayEight

import Solution
import java.io.File
import java.io.InputStream

class HandheldHalting(inputFile: String) :Solution {

    private val instructions = process(inputFile)

    fun process(inputFile:String ): MutableList<String> {
        val inputStream: InputStream = File(inputFile).inputStream()
        val ret = mutableListOf<String>()
        inputStream.bufferedReader().useLines { lines -> lines.forEach { ret.add(it) } }
        return ret
    }
    override fun partOne(): Int {
        var accumulator = 0
        var instructionLine = 0
        var runInstructions = mutableListOf<Int>()
        fun instructionACC(argumentVal : Int){
            accumulator+= argumentVal
            instructionLine++
        }
        fun instructionJMP(argumentVal: Int): Int {
            instructionLine+=argumentVal
            return instructionLine
        }
        fun instructionNOP(){
            instructionLine++
        }
        fun takeAccount(){
            runInstructions.add(instructionLine)
        }
        while(true){
            val instruction: Pair<String, Int> = instructionSplitter(instructions[instructionLine])
            when (instruction.first) {
                "nop" -> instructionNOP()
                "acc" -> instructionACC(instruction.second)
                "jmp" -> instructionJMP(instruction.second)
            }
            if (runInstructions.contains(instructionLine))
                return accumulator
            takeAccount()
        }
    }

    override  fun partTwo():Int{
        return -1
        fun instructionACC(argumentVal : Int){
    }
        fun instructionJMP(argumentVal: Int): Int {
            return 1
        }
        fun instructionNOP(){
        }
        for (i in 0..instructions.size){
            val instruction: Pair<String, Int> = instructionSplitter(instructions[i])
            when (instruction.first) {
                "nop" -> print("")
                "acc" -> instructionACC(instruction.second)
                "jmp" -> instructionJMP(instruction.second)
            }
        }

        return 0
    }


    private fun instructionSplitter(instruction : String): Pair<String, Int> {
        val deconIns = instruction.split(" ")
        return Pair(deconIns[0],deconIns[1].trim().toInt())
    }


}