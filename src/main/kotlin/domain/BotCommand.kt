package domain

enum class BotCommand(
    val command: String
)  {
    Vote(command = "!enquete"),
    RegisterSentence(command = "r!frase"),
    RandomSentence(command = "!frase");

    companion object {
        @JvmStatic
        fun find(data: String) = values().firstOrNull{ it.command == data}
    }
}
