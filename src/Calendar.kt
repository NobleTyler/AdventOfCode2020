import dayOne.RepairKit
import dayTwo.PasswordPhilosophy
fun main(){
    val repKit = RepairKit()
    val passwordPhilosophy = PasswordPhilosophy()
    println("On the first day of Christmas my code gave to me: "+repKit.partOne()+" and "+repKit.partTwo())
    println("On the second day of Christmas my code gave to me: "+passwordPhilosophy.partOne()+" and "+ passwordPhilosophy.partTwo())
}