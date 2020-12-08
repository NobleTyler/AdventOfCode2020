import dayFive.BinaryBoarding
import dayFour.PassportProcessing
import dayOne.RepairKit
import daySix.CustomCustoms
import dayThree.TobogganTrajectory
import dayTwo.PasswordPhilosophy
fun main(){
    val repKit = RepairKit()
    val passwordPhilosophy = PasswordPhilosophy()
    val tobogganTrajectory = TobogganTrajectory()
    val passportProcessing = PassportProcessing("src/dayFour/input.txt")
    val boarding = BinaryBoarding("src/dayFive/input.txt")
    val customCustoms = CustomCustoms("src/daySix/input.txt")

    println("On the first day of Christmas my code gave to me: "+repKit.partOne()+" and "+repKit.partTwo())
    println("On the second day of Christmas my code gave to me: "+passwordPhilosophy.partOne(passwordPhilosophy.process())+" and "+ passwordPhilosophy.partTwo(passwordPhilosophy.process()))
    println("On the third day of Christmas my code gave to me: "+tobogganTrajectory.partOne(tobogganTrajectory.process(),3,1) +" and "+ tobogganTrajectory.partTwo())
    println("On the fourth day of Christmas my code gave to me: "+passportProcessing.partOne() +" and "+ passportProcessing.partTwo())
    println("On the fifth day of Christmas my code gave to me: "+boarding.partOne() +" and "+ boarding.partTwo())
    println("On the sixth day of Christmas my code gave to me: "+customCustoms.partOne() +" and "+ customCustoms.partTwo())
    println("On the seventh day of Christmas my code gave to me: "+boarding.partOne() +" and "+ boarding.partTwo())
}