package dayFive

import org.junit.Test
import kotlin.test.assertEquals

class BoardingTest {
    val binaryBoarding = BinaryBoarding("src/dayFive/testText")

    @Test
    fun `the text file is processed`(){
        val firstLine = "FBFBBFFRLR"
        assertEquals(firstLine,binaryBoarding.process()[0])
    }
    @Test
    fun `we can calculate the seatId`(){
        assertEquals(357,binaryBoarding.calculateID("FBFBBFFRLR"))
    }
}