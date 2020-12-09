package daySeven

import org.junit.Test
import kotlin.test.assertEquals


class HandyTest {
    private val handyHaversacks = HandyHaversacks("src/daySeven/testText")

    @Test
    fun`is it processing Data properly`(){
        assertEquals("light red bags contain 1 bright white bag, 2 muted yellow bags.",
                handyHaversacks.process("src/daySeven/testText")[0])
    }
    @Test
    fun` how does parseLook`(){
        assertEquals(BagRule("light red",1,"bright white"),
                handyHaversacks.parseInput().elementAt(0))
    }

    @Test
    fun`how many bag colors can hold the gold`(){
        assertEquals(4,handyHaversacks.partOne())
    }
}

