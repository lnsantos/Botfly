package domain

import dev.kord.core.entity.Message

data class SimpleDataDomain(
    val messageSplit: List<String>,
    val messageData: Message
) : BotDataDomain
