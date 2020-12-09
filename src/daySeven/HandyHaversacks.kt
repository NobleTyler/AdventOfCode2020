//Probably wanna do this some different way. I just hated this question secretly/ and I don't feel like weekend coding
package daySeven

import Solution

class HandyHaversacks(private val inputFile:String) :Solution {
    val relationships :Set<BagRule> = parseInput(process(inputFile))

     fun parseInput(input: List<String> = process((inputFile))): Set<BagRule> =
            input.filterNot { it.contains("no other") }.flatMap { row ->
                val parts = row.replace(unusedText, "").split(whitespace)
                val parent = parts.take(2).joinToString(" ")
                parts.drop(2).windowed(3, 3, false).map { child ->
                    BagRule(
                            parent,
                            child.first().toInt(),
                            child.drop(1).joinToString(" ")
                    )
                }
            }.toSet()
    companion object {
        private val unusedText = """bags|bag|contain|,|\.""".toRegex()
        private val whitespace = """\s+""".toRegex()
    }
    private fun findParents(bag: String = "shiny gold"): Set<String> =
            relationships.filter { it.child==bag}.flatMap { findParents(it.parent) }.toSet()+bag

    override fun partOne():Int{
        return findParents().size -1
    }

    private fun baggageCost(bag: String = "shiny gold"): Int =
            relationships
                    .filter { it.parent == bag }
                    .sumBy { it.cost * baggageCost(it.child) } + 1

    override fun partTwo(): Int =
            baggageCost() - 1
}
