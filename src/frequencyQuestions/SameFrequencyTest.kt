package frequencyQuestions

import org.junit.Test

class SameFrequencyTest {
    private val sameFrequency = SameFrequency()
    @Test
    fun `case one`(){
        assert(sameFrequency.checkFrequency(182,281))
    }
    @Test
    fun `case two`(){
        assert(!sameFrequency.checkFrequency(34,14))
    }
    @Test
    fun `case three`(){
        assert(sameFrequency.checkFrequency(3589578,5879385))
    }
    @Test
    fun `case four`(){
        assert(!sameFrequency.checkFrequency(22,222))
    }
}