package dayOne

import Solution
import java.io.File
import java.io.InputStream

class  RepairKit :Solution{
        private val sKVal = 2020
        fun process(): MutableList<Int> {
                val inputStream: InputStream = File("src/dayOne/input.txt").inputStream()
                val numberList = mutableListOf<Int>()
                inputStream.bufferedReader().useLines { lines -> lines.forEach { numberList.add(it.toInt())} }
                numberList.sort()
                return numberList

        }
        override fun partOne(): Int{
                val numberList = process()
                val candidates = numberList.filter { number -> (numberList.contains(sKVal-number)) }
                val result = candidates.reduce{ a, b  -> a*b}
                return result
        }
        override fun partTwo(): Int{
                val numberList = process()
                val numbersAddedList = mutableListOf<Pair<Int,Int>>()
                for(i in 0 until numberList.size){
                        for(j in 0 until numberList.size){
                                numbersAddedList.add(Pair(numberList[i],numberList[j]))
                                }
                        }
                val candidates = numbersAddedList.filter { numbers -> (numberList.contains(sKVal-(numbers.first+numbers.second))) }
                return (sKVal-candidates[0].first-candidates[0].second)*candidates[0].first*candidates[0].second
        }
}