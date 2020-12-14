import java.io.File
import java.io.InputStream

class HelperMethods {

    fun process(inputFile:String): MutableList<String> {
        val inputStream: InputStream = File(inputFile).inputStream()
    val ret = mutableListOf<String>()
    inputStream.bufferedReader().useLines { lines -> lines.forEach { ret.add(it) } }
    return ret
}

}