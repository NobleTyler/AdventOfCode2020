package dayEleven
//This one aint mine I just like seeing what other people did to learn kotlin stuff cause I get lazy
// https://todd.ginsberg.com/post/advent-of-code/2020/day11/ real one is here
import Solution
import java.io.File
import java.net.URI

typealias Seats = Array<CharArray>
typealias Seat = Pair<Int,Int>

class SeatingSystem(val inputFile: String) : Solution {

    fun process(): List<String>
    {
        return File(inputFile).readLines()
    }
    private  val input = process()
    private val seats: Seats = input.map { it.toCharArray() }.toTypedArray()

    companion object {
        private val neighbors = sequenceOf(
                -1 to -1, -1 to 0, -1 to 1,
                0 to -1,           0 to 1,
                1 to -1,  1 to 0,  1 to 1
        )
    }
    private operator fun Seats.contains(seat: Seat): Boolean =
            seat.first in this.indices && seat.second in this.first().indices

    private operator fun Seat.plus(that: Seat): Seat =
            Seat(this.first + that.first, this.second + that.second)

    private fun Seats.occupied(): Int =
            this.sumBy { it.count { row -> row == '#' } }

    private fun countImmediateNeighbors(seats: Seats, seat: Seat): Int =
            neighbors
                    .map { it + seat }
                    .filter { it in seats }
                    .count { seats[it.first][it.second] == '#' }

    private fun Seats.next(tolerance: Int, countFunction: (Seats, Seat) -> Int): Seats =
            this.mapIndexed { x, row ->
                row.mapIndexed { y, spot ->
                    val occupied = countFunction(this, Seat(x, y))
                    when {
                        spot == 'L' && occupied == 0 -> '#'
                        spot == '#' && occupied >= tolerance -> 'L'
                        else -> spot
                    }
                }.toCharArray()
            }.toTypedArray()

    private fun findStableMap(tolerance: Int, countFunction: (Seats, Seat) -> Int): Int =
            generateSequence(seats) { it.next(tolerance, countFunction) }
                    .zipWithNext()
                    .first { it.first.contentDeepEquals(it.second) }
                    .first
                    .occupied()

    override fun partOne(): Int {
        return  findStableMap(4, this::countImmediateNeighbors)
    }

}