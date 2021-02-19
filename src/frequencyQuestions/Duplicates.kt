package frequencyQuestions

class Duplicates {
    fun detect(candidates : List<Any>): Boolean{
        return candidates.size != candidates.distinct().size
    }
}