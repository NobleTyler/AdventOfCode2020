package dayThree

import org.junit.Test
import kotlin.test.assertEquals

class TobogganTest {
    val tobogganTrajectory = TobogganTrajectory()

    @Test
    fun`the textfile is processed properly`(){
        val firstLine = "....#............#.###...#.#.#."
        assertEquals(firstLine,tobogganTrajectory.process()[0])
    }
    @Test
    fun`test three right and 1 down small`(){
        val testHill = arrayListOf<String>(
                "......",
                "######",
                "######",
                "######",
                "......",
                "######",
                "######",
                "######",
        )
        assertEquals(6,tobogganTrajectory.partOne(testHill,3,1))
    }
}