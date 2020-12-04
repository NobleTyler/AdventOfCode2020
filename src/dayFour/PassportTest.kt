package dayFour

import org.junit.Test
import kotlin.test.assertEquals

class PassportTest {
    private val passportProcessing = PassportProcessing("src/dayFour/testText")
    @Test
    fun`the textile is processed properly`(){
        assertEquals(PassPort("1937","2017","2020","860033327","147","183cm","gry"),passportProcessing.process()[0])
    }
    @Test
    fun `partOne returns the proper ammount of valid passports`(){
        assertEquals(2,passportProcessing.partOne())
    }
}