package dayEight

import Solution

class HandheldHalting(override val inputFile: String) :Solution {
    var accumulator = 0
    var instructionLine = 0
    val instructions = process()
    var runInstructions = mutableListOf<Int>()
    override fun partOne(): Int {
        while(!runInstructions.contains(instructionLine)){
            return 0
        }
        return 0
    }
    private fun accumulate(argumentVal : Int){
        accumulator+= argumentVal
    }
    private fun instructionJump(argumentVal: Int): Int {
        instructionLine+=argumentVal
        return instructionLine
    }
}