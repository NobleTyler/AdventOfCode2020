package dayNine

import org.junit.Test
import kotlin.test.assertEquals

class TestEncoding {
    val encodingError = EncodingError("src/dayNine/testText")

    @Test
    fun `input is processed` (){
        assertEquals("35",encodingError.process("src/dayNine/testText")[0])
    }
    @Test
    fun`partOne returns error code` (){
        assertEquals(127,encodingError.partOne())
    }
}