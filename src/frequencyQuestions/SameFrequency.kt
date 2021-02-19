package frequencyQuestions

class SameFrequency {
    fun checkFrequency(first:Int, second:Int):Boolean{
        var frequencyCounter = first.toString().groupingBy { it }.eachCount()
        var frequencyCounterTwo = second.toString().groupingBy { it }.eachCount()

        return (frequencyCounter == frequencyCounterTwo)
    }
}
