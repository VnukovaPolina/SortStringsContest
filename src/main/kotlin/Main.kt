import kotlin.io.path.Path
import kotlin.io.path.readLines
import java.io.File

fun main() {
    val filePath = Path("C:\\Users\\Dropscapez\\IdeaProjects\\SortStringsContest\\src\\main\\kotlin\\input.txt")
    val badSortedStrings : List<String> = filePath.readLines()
    val rightSortedStrings : MutableList<String> = MutableList(badSortedStrings.size) {""}
    var numberInString = ""
    val rightFile = File("C:\\Users\\Dropscapez\\IdeaProjects\\SortStringsContest\\src\\main\\kotlin\\output.txt")

    for (i in 0..<badSortedStrings.size) {
        for (symbol in badSortedStrings[i].iterator()) {
            if (symbol in '0'..'9') {
                numberInString += symbol.toString()
            }
        }
        rightSortedStrings[numberInString.toInt() - 1] = badSortedStrings[i]
        numberInString = ""
    }

    rightFile.printWriter().use {out -> rightSortedStrings.forEach {line -> out.println(line)}}
}