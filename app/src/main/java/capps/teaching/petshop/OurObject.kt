package capps.teaching.petshop

import android.net.Uri

object OurObject {
    var imageUri: Uri? = null

    const val PET_ID = "petId"

    interface OurItemClickListener {
        fun ourItemClick(position: Int)
    }

    fun imgurJPGLink(imgurDefaultLInk: String?): String? {

        return if (imgurDefaultLInk != null) {
            val stringBuilder = StringBuilder(imgurDefaultLInk)
            stringBuilder.insert(8, "i.")
            stringBuilder.append(".jpg")

            stringBuilder.toString()
        } else{
            null
        }
    }

    fun isColorDark(hexColor: String): Boolean {
        val cleanHexColor = if (hexColor.startsWith("#")) {
            hexColor.substring(1)
        } else {
            hexColor
        }

        // Parse the hex color string to RGB components
        val red = Integer.parseInt(cleanHexColor.substring(0, 2), 16)
        val green = Integer.parseInt(cleanHexColor.substring(2, 4), 16)
        val blue = Integer.parseInt(cleanHexColor.substring(4, 6), 16)

        // Calculate the brightness using the relative luminance formula
        val brightness = 0.299 * red + 0.587 * green + 0.114 * blue

        // Determine if the color is light or dark based on the brightness
        return brightness < 128
    }

    /*fun splitSentence(input: String?): Pair<String, String>? {
        return if (input != null) {
            val sentenceEnd = "[.!?\\,]| {2,}"
            val sentenceRegex = "(.*?)(?=$sentenceEnd)".toRegex()

            val matchResult = sentenceRegex.find(input)
            val firstSentence = matchResult?.value ?: input

            val remainingText = matchResult?.let { input.substring(it.range.last + 1).trim() } ?: ""

            Pair(firstSentence, remainingText)
        } else{
            null
        }
    }*/
}