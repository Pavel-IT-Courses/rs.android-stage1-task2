package subtask4

import java.util.*

class Pangram {


    fun getResult(inputString: String): String {


        if(inputString.equals("")) return ""

        val inputString1 = inputString.replace('\n', ' ').trim()
        val words = inputString1.split(Regex(" +"))
        if(words.size == 1 && words[0] == "") return ""
        if(isPangram(inputString)) {
            println("PANGRAM")
            val result = words.sortedBy { countVowels(it) }
            val sb = StringBuilder()
            for(word in result) {
                if(word.length == 0) continue
                var w = countVowels(word).toString() + word
                for(i in 0..w.length - 1) {
                    if(isVowel(w[i])) w = w.replace(w[i], w[i].toUpperCase())
                }
                sb.append(w)
                sb.append(" ")
            }
            return sb.toString().trim()
        }
        else {
            println("NOT PANGRAM")
            val result = words.sortedBy { countConsonants(it) }
            val sb = StringBuilder()
            for(word in result) {
                var w = countConsonants(word).toString() + word
                for(i in 0..w.length - 1) {
                    if(isConsonant(w[i])) w = w.replace(w[i], w[i].toUpperCase())
                }
                sb.append(w)
                sb.append(" ")
            }
            return sb.toString().trim()

        }
    }

    fun isPangram(input: String): Boolean {

        for(c in 'A'..'Z') {

            if(!input.toLowerCase().contains(c.toLowerCase())) {

                return false
            }
        }
        return true
    }

    fun isVowel(c: Char): Boolean {
        if(c in listOf<Char>('a', 'e', 'i', 'o', 'u', 'y', 'A', 'E', 'I', 'O', 'U', 'Y')) return true
        return false
    }
    fun isConsonant(c: Char): Boolean {
        if(c in 'A'..'z' && !isVowel(c)) return true
        return false
    }
    fun countVowels(input: String): Int {
        var count = 0
        for(c in input) {
            if(isVowel(c)) count++
        }
        return count
    }
    fun countConsonants(input: String): Int {
        var count = 0
        for(c in input) {
            if(isConsonant(c)) count++
        }
        return count
    }
}
