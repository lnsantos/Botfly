package actions

import domain.BotCommand

interface BotAction {
    val command : BotCommand
    suspend fun onWork()
}