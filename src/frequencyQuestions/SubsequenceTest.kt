package frequencyQuestions

import org.junit.Test

class SubsequenceTest {private val subsequence = Subsequence()
    @Test
    fun `case one`(){
        assert(subsequence.checkIfSubsequence("hello","hello world"))
    }
    @Test
    fun `case two`(){
        assert(!subsequence.checkIfSubsequence("sing","sting"))
    }
    @Test
    fun `case three`(){
        assert(subsequence.checkIfSubsequence("abc","abracadabra"))
    }
    @Test
    fun `case four`(){
        assert(!subsequence.checkIfSubsequence("abc","acb"))
    }
}