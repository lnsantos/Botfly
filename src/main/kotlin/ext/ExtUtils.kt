package ext

import domain.BotCommand
import domain.BotCommand.Companion.find
import domain.SimpleDataDomain

infix fun BotCommand.thisIsCommand(data: String) = this == find(data)

fun SimpleDataDomain.getChatDescription(): String {
    return messageSplit.subList(1, messageSplit.size).joinToString(" ")
}

suspend fun SimpleDataDomain.createResponse(
    message: String
) = messageData.channel.createMessage(message)