package dayTwo
import org.junit.Test
import kotlin.test.assertEquals

class PasswordTest {
    val pword = PasswordPhilosophy()

    @Test
    fun `the list becomes pairs`(){
        val pairTest = Pair("4-5 m", "mmpth")
        assertEquals(pword.process()[0],pairTest)
    }
    @Test
    fun`count that it gets it right`(){
        val testList = mutableListOf<Pair<String,String>>(
                Pair("1-3 a","abcde"),
                Pair("1-3 b","cdefg"),
                Pair("2-9 c","cccccccc")
        )

        assertEquals(2,pword.partOne(testList),)
    }
    @Test
    fun`count that part2 is right`(){
        val testList = mutableListOf<Pair<String,String>>(
                Pair("1-3 a","abcde"),
                Pair("1-3 b","cdefg"),
                Pair("2-9 c","cccccccccc")
        )

        assertEquals(1,pword.partTwo(testList))
    }

}