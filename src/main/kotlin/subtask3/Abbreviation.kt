package subtask3

class Abbreviation {

    // TODO: Complete the following function
    fun abbreviationFromA(a: String, b: String): String {


        val sb = StringBuilder()
        val bChr = b.toCharArray()
        val bLen = b.length
        for(i in 0..bLen-1) {
            sb.append("[a-z]*(${bChr[i]}|${bChr[i].toLowerCase()})[a-z]*")
        }


        if(a.matches(Regex(sb.toString()))) return "YES"
        return "NO"

    }
}
