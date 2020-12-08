package daySix

import org.junit.Test
import kotlin.test.assertEquals

class CustomTest {
    private val inputFile = "src/daySix/testText"
    private val customCustoms = CustomCustoms(inputFile)
    @Test
    fun `is it processing the input` (){
        assertEquals("abc.",customCustoms.process()[0])
    }
    @Test
    fun `is it summing`(){
        assertEquals(customCustoms.partOne(),11)
    }
    @Test
    fun `is part two doing anything`(){
        assertEquals(customCustoms.partTwo(),6)
    }
}