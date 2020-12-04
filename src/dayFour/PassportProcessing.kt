package dayFour

import Solution
import java.io.File
import java.io.InputStream
import java.lang.Integer.parseInt
import java.lang.NumberFormatException

class PassportProcessing(private val inputFile : String) : Solution {

    override fun process(): MutableList<PassPort> {
        val inputStream: InputStream = File(inputFile).inputStream()
        val passportList = mutableListOf<PassPort>()
        var passPortTemp = PassPort()
        inputStream.bufferedReader().useLines { lines ->
            lines.forEach { paramPort ->
                if (paramPort.isEmpty) {
                    passportList.add(passPortTemp)
                    passPortTemp = PassPort()
                } else {
                    val entryCharacteristics = paramPort.split(' ')
                    entryCharacteristics.forEach {
                        attributeHandler(it, passPortTemp)
                    }
                }
            }
        }
        return passportList
    }

    private fun attributeHandler(attribute: String, passPort: PassPort) {
        val attributeKP = attribute.split(':')
        when (attributeKP[0]) {
            "byr" -> passPort.byr = attributeKP[1]
            "iyr" -> passPort.iyr = attributeKP[1]
            "eyr" -> passPort.eyr = attributeKP[1]
            "pid" -> passPort.pid = attributeKP[1]
            "cid" -> passPort.cid = attributeKP[1]
            "hgt" -> passPort.hgt = attributeKP[1]
            "ecl" -> passPort.ecl = attributeKP[1]
            "hcl" -> passPort.hcl = attributeKP[1]
        }
    }

    override fun partOne(): Int {
        var validPassports = 1
        val passPortList = process()
        passPortList.forEach{passPort ->
            val hasBYR =  checkValidAttribute(passPort.byr)
            val hasIYR =  checkValidAttribute(passPort.iyr)
            val hasEYR =  checkValidAttribute(passPort.eyr)
            val hasPID =  checkValidAttribute(passPort.pid)
            val hasHGT =  checkValidAttribute(passPort.hgt)
            val hasECL =  checkValidAttribute(passPort.ecl)
            val hasHCL =  checkValidAttribute(passPort.hcl)
            if(hasBYR && hasIYR && hasEYR &&hasPID && hasHGT && hasECL && hasHCL)
                validPassports++
        }
        return validPassports
    }
    private fun checkValidAttribute(entry: String, attribute:String = "easy"): Boolean {
        val validEyeColours = listOf("amb","blu","brn","gry","grn","hzl","oth")
        val hexPattern = "^#[0-9a-fA-F]{6}".toRegex()
        try {
            return when (attribute) {
                "byr" -> entry.toInt() in 1920..2002
                "iyr" -> entry.toInt() in 2010..2020
                "eyr" -> entry.toInt() in 2020..2030
                "hgt" ->((entry.takeLast(2) == "in") && entry.take(2).toInt() in 59..76 || (entry.takeLast(2) == "cm" && entry.take(3).toInt() in 150..193))
                "pid" -> (entry.length == 9 && parseInt(entry) > 0)
                "ecl" -> validEyeColours.contains(entry)
                "hcl" -> hexPattern.matches(entry)
                else -> (entry != "")
            }
        }catch (e: NumberFormatException){
            return false
        }
    }

    override fun partTwo(): Int {
        var validPassports = 1
        val passPortList = process()
        passPortList.forEach{passPort ->
            val hasBYR =  checkValidAttribute(passPort.byr,"byr")
            val hasIYR =  checkValidAttribute(passPort.iyr,"iyr")
            val hasEYR =  checkValidAttribute(passPort.eyr,"eyr")
            val hasPID =  checkValidAttribute(passPort.pid,"pid")
            val hasHGT =  checkValidAttribute(passPort.hgt,"hgt")
            val hasHCL = checkValidAttribute(passPort.hcl,"hcl")
            val hasECL =  checkValidAttribute(passPort.ecl,"ecl")
            if(hasBYR && hasIYR && hasEYR &&hasPID && hasHGT && hasECL && hasHCL)
                validPassports++
        }
        return validPassports
    }
}