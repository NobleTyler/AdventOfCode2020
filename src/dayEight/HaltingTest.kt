package dayEight

import org.junit.Test
import kotlin.test.assertEquals

class HaltingTest {
    val handheldHalting = HandheldHalting("src/dayEight/testText")

    @Test
    fun `input is processed` (){
        assertEquals("nop +0",handheldHalting.process("src/dayEight/testText")[0])

    }
    @Test
    fun `partOne gives proper accumulator value` (){
        assertEquals(5,handheldHalting.partOne())
    }
}