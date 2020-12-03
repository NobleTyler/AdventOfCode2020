package dayTwo

import Solution
import java.io.File
import java.io.InputStream

class PasswordPhilosophy: Solution {
    override fun process(): MutableList<Pair<String,String>> {
        val inputStream: InputStream = File("src/dayTwo/input").inputStream()
        val passwordList = mutableListOf<Pair<String,String>>()
        inputStream.bufferedReader().useLines { lines -> lines.forEach {
            val entry = Pair(it.split(':')[0].trim(),it.split(':')[1].trim())
            passwordList.add(entry)} }
        return passwordList

    }

    fun partOne( passwordList :MutableList<Pair<String,String>> = process()): Int   {
        var ret = 0
        passwordList.forEach{ entry ->
            val  rule = entry.first.split('-',' ')
            print(rule)
            val min = rule[0].toInt()
            val max = rule[1].toInt()
            val key = rule[2].single()
            val givenKeyCount = entry.second.filter { it == key }.count()
            if (givenKeyCount in min..max) {
                ret++
            }
        }
        return ret
    }
    fun partTwo( passwordList :MutableList<Pair<String,String>> = process()): Int   {
        var ret = 0
        passwordList.forEach{ entry ->
            val  rule = entry.first.split('-',' ')
            val key = rule[2].single()
            var first = false
            var second = false
            try {
                first =  (entry.second[rule[0].toInt()-1]== key )
                second = (entry.second[rule[1].toInt()-1]== key )
            }catch (e: StringIndexOutOfBoundsException){

            }
            if (first xor second ) {
                ret++
                println("$first, $second $key $rule")
            }
        }
        return ret
    }
}