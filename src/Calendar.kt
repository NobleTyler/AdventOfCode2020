import dayEight.HandheldHalting
import dayEleven.SeatingSystem
import dayFive.BinaryBoarding
import dayFour.PassportProcessing
import dayNine.EncodingError
import dayOne.RepairKit
import daySeven.HandyHaversacks
import daySix.CustomCustoms
import dayTen.AdapterArray
import dayThree.TobogganTrajectory
import dayTwo.PasswordPhilosophy
import frequencyQuestions.SameFrequency

fun main(){
    val repKit = RepairKit()
    val passwordPhilosophy = PasswordPhilosophy()
    val tobogganTrajectory = TobogganTrajectory()
    val passportProcessing = PassportProcessing("src/dayFour/input.txt")
    val boarding = BinaryBoarding("src/dayFive/input.txt")
    val customCustoms = CustomCustoms("src/daySix/input.txt")
    val handyHaversacks = HandyHaversacks("src/daySeven/input.txt")
    val handheldHalting = HandheldHalting("src/dayEight/input.txt")
    val encodingError = EncodingError("src/dayNine/input.txt")
    val adapterArray = AdapterArray("src/dayTen/input.txt")
    val seatingSystem = SeatingSystem("src/dayEleven/input.txt")
    val frequencyQuestions = SameFrequency()
    println("On the first day of Christmas my code gave to me: "+repKit.partOne()+" and "+repKit.partTwo())
    println("On the second day of Christmas my code gave to me: "+passwordPhilosophy.partOne(passwordPhilosophy.process())+" and "+ passwordPhilosophy.partTwo(passwordPhilosophy.process()))
    println("On the third day of Christmas my code gave to me: "+tobogganTrajectory.partOne(tobogganTrajectory.process(),3,1) +" and "+ tobogganTrajectory.partTwo())
    println("On the fourth day of Christmas my code gave to me: "+passportProcessing.partOne() +" and "+ passportProcessing.partTwo())
    println("On the fifth day of Christmas my code gave to me: "+boarding.partOne() +" and "+ boarding.partTwo())
    println("On the sixth day of Christmas my code gave to me: "+customCustoms.partOne() +" and "+ customCustoms.partTwo())
    println("On the seventh day of Christmas my code gave to me: "+handyHaversacks.partOne() +" and "+ handyHaversacks.partTwo())
    println("On the eighth day of Christmas my code gave to me: "+handheldHalting.partOne() +" and "+ handheldHalting.partTwo())
    println("On the ninth day of Christmas my code gave to me: "+encodingError.partOne(25) +" and "+ encodingError.partTwo())
    println("On the tenth day of Christmas my code gave to me: "+adapterArray.partOne() +" and "+ adapterArray.partTwo())
    println("On the eleventh day of Christmas my code gave to me: "+seatingSystem.partOne() +" and "+ seatingSystem.partTwo())
    println("SameFrequency ")
}