import dayOne.RepairKit
import dayThree.TobogganTrajectory
import dayTwo.PasswordPhilosophy
fun main(){
    val repKit = RepairKit()
    val passwordPhilosophy = PasswordPhilosophy()
    val tobogganTrajectory = TobogganTrajectory()
    println("On the first day of Christmas my code gave to me: "+repKit.partOne()+" and "+repKit.partTwo())
    println("On the second day of Christmas my code gave to me: "+passwordPhilosophy.partOne(passwordPhilosophy.process())+" and "+ passwordPhilosophy.partTwo(passwordPhilosophy.process()))
    println("On the third day of Christmas my code gave to me: "+tobogganTrajectory.partOne(tobogganTrajectory.process(),3,1) +" and "+ tobogganTrajectory.partTwo())
}