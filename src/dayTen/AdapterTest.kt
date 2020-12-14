package dayTen

import org.junit.Test
import kotlin.test.assertEquals

class AdapterTest {
    private val adapterArray = AdapterArray("src/dayTen/testText")
    private val adapterArrayV2 = AdapterArray("src/dayTen/secondTestText")
    @Test
    fun `processing input file works`(){
        assertEquals(16,adapterArray.process()[0])
    }
    @Test
    fun `test1 partOne succeeds`(){
        assertEquals(35,adapterArray.partOne())
    }
    @Test
    fun `test2 partOne succeeds`(){
        assertEquals(220,adapterArrayV2.partOne())
    }
    @Test
    fun `test2 partTwo succeeds`(){
        assertEquals(19208,adapterArrayV2.partTwo())
    }
    @Test
    fun `test1 partTwo succeeds`(){
        assertEquals(8,adapterArray.partTwo())
    }
}