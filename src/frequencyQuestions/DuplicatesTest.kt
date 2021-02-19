package frequencyQuestions

import org.junit.Test

class DuplicatesTest {
    private val duplicates = Duplicates()
    @Test
    fun `case one`(){
        assert(!duplicates.detect(listOf(1,2,3)))
    }
    @Test
    fun `case two`(){
        assert(duplicates.detect(listOf(1,2,2)))
    }
    @Test
    fun `case three`(){
        assert(duplicates.detect(listOf('a','b','c','a')))
    }
}