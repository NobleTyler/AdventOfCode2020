package daySix

import Solution
import java.io.File
import java.io.InputStream

class CustomCustoms(private val inputFile:String) :Solution {
    val customsList = process()
    fun process(): MutableList<String> {
        val inputStream: InputStream = File(inputFile).inputStream()
        val customsList = mutableListOf<String>()
        var stringBuilder = StringBuilder()
        inputStream.bufferedReader().useLines { lines ->
            lines.forEach {
                if(it.isBlank()){
                    customsList.add(stringBuilder.toString())
                    stringBuilder = StringBuilder()
                }else{
                    stringBuilder.append("$it.")
                }
            }
            customsList.add(stringBuilder.toString())
        }
        return customsList
    }
   override fun partOne(): Int {
       var sumOfQuestions = 0
       customsList.forEach {
           //the minus 1 is cause of the dot
           sumOfQuestions+=gradeCustom(it)-1
       }
       return  sumOfQuestions
   }
    private fun gradeCustom(custom:String):Int{
        return custom.toSet().size
    }
    override fun partTwo():Int{
        var sum = 0
            customsList.forEach { customEntry ->
                val mapWord = getFreqMap(customEntry)
                mapWord.keys.forEach{
                    if(mapWord['.'] == mapWord[it] && it!='.'){
                        sum++
                    }
                }
            }
            return sum
        }
    private fun getFreqMap(chars: String): Map<Char, Int> {
        val freq: MutableMap<Char, Int> = HashMap()
        for (c in chars) {
            freq.putIfAbsent(c, 0)
            freq[c] = freq[c]!! + 1
        }
        return freq
    }

}
//count the ammount of /n in a block, if occurence of char is = count of /n then add 1.