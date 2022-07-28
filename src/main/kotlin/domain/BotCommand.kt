package domain

enum class BotCommand(
    val command: String
)  {
    Vote(command = "!enquete"),
    RegisterSentence(command = "r!frase"),
    RandomSentence(command = "!frase"),
    SecretSentenceAction(command = "r!resposta");

    companion object {
        @JvmStatic
        fun find(data: String) = values().firstOrNull{ it.command == data}
    }
}
