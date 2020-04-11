package subtask1

import java.text.SimpleDateFormat
import java.util.*

class DateFormatter {

    // TODO: Complete the following function
    fun toTextDay(day: String, month: String, year: String): String {
        val no = "Такого дня не существует"
        if(!isValid(day, month, year)) return no

        val formatter = SimpleDateFormat("dd MM yyyy")
        val input = day + " " + month + " " + year


        val date = formatter.parse(input)
        val format = SimpleDateFormat("dd MMMM, EEEE", Locale.forLanguageTag("ru"))
        return format.format(date)
    }

    fun isValid(day: String, month: String, year: String): Boolean {

        val dayNum = Integer.parseInt(day)
        val monthNum = Integer.parseInt(month)
        val yearNum = Integer.parseInt(year)

        if(dayNum <= 0 || monthNum <= 0 || monthNum > 12 || yearNum <= 0) return false

        var normal: Boolean = false
        if(yearNum % 4 != 0) normal = true
        else {
            if(yearNum % 100 != 0) normal = false
            else {
                if(yearNum % 400 != 0) normal = true
                else normal = false
            }
        }

         if(!normal && monthNum == 2 && dayNum == 29) return true

        if(monthNum == 2 && dayNum > 28) return false

        if(monthNum == 1 || monthNum == 3 || monthNum == 5 || monthNum == 7 || monthNum == 8 || monthNum == 10 || monthNum == 12) {
            if(dayNum > 31) return false
        }
        else{
            if(dayNum > 30) return false
        }

        return true
    }
}
