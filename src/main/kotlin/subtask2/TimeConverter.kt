package subtask2

class TimeConverter {

    // TODO: Complete the following function
    fun toTextFormat(hour: String, minute: String): String {
        val h = Integer.parseInt(hour)
        val m = Integer.parseInt(minute)
        if(m > 59 || h > 23) return ""


        val hh = listOf<String>("midnight", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve")
        val mm = listOf<String>("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen",
        "quarter", "sixteen", "seventeen", "eighteen", "nineteen", "twenty")

        if(m == 0) return hh[h] + " o' clock"
        if(m < 15) return mm[m - 1] + " minutes past " + hh[h]
        if(m == 15) return "quarter past " + hh[h]
        if(m <= 20) return mm[m - 1] + " minutes past " + hh[h]
        if(m in 21..29) return mm[19] + " " + mm[m - 21] + " minutes past " + hh[h]
        if(m == 30) return "half past " + hh[h]
        if(m in 31..39) return mm[19] + " " + mm[39 - m] + " minutes to " + hh[h + 1]
        if(m == 40) return mm[19] + " minutes to " + hh[h + 1]
        if(m in 41..44) return mm[59 - m] + " minutes to " + hh[h + 1]
        if(m == 45) return "quarter to " + hh[h + 1]
        return mm[59 - m] + " minutes to " + hh[h + 1]
    }
}
