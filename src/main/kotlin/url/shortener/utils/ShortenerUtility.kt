package url.shortener.utils

private const val length = 5
private const val possibleCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%&_"

object ShortenerUtility {
    fun generateShortUrl(): String {
        return (0 until length)
                .map { possibleCharacters.random() }
                .joinToString("")
    }
}