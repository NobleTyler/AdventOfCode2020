package dayEleven

import org.junit.Test
import kotlin.test.assertEquals

class SeatingTest {
    private  val seatingSystem = SeatingSystem("src/dayEleven/testingText")
    @Test
    fun `processing the input works` (){
        assertEquals("L.LL.LL.LL",seatingSystem.process()[0])
    }
    @Test
    fun `partone is correct` (){
        assertEquals(37,seatingSystem.partOne())
    }
    @Test
    fun `partTwo is correct` (){
        assertEquals(5,seatingSystem.partTwo())
    }
}