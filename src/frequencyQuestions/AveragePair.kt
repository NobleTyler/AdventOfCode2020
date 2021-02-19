package frequencyQuestions

class AveragePair {
    fun findAverage(candidate: Pair<List<Int>, Double>):Boolean{
        val nums = candidate.first
        val ret =  nums.map { i -> nums.map { i to it }}
                .flatten()
                .filter { (left,right) -> left!=right }
                .find { ((it.first+it.second).toDouble()/2) == candidate.second }
        println(ret)
        return  ret != null
    }
}