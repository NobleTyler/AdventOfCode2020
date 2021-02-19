package frequencyQuestions

import org.junit.Test

class AveragePairTest {
    private val averagePair = AveragePair()
    @Test
    fun `case one`(){
        assert(averagePair.findAverage(Pair(listOf(1,2,3),2.5)))
    }
    @Test
    fun `case two`(){
        assert(averagePair.findAverage(Pair(listOf(1,3,3,5,6,7,10,12,19),8.0)))
    }
    @Test
    fun `case three`(){
        assert(!averagePair.findAverage(Pair(listOf(-1,0,3,4,5,6),4.1)))
    }
    @Test
    fun `case four`(){
        assert(!averagePair.findAverage(Pair(listOf(),4.0)))
    }
}