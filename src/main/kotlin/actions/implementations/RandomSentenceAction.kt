package actions.implementations

import actions.BotAction
import data.CacheTemp
import domain.BotCommand
import domain.SimpleDataDomain
import ext.createResponse

internal class RandomSentenceAction constructor(
    private val data: SimpleDataDomain
) : BotAction {

    override val command: BotCommand = BotCommand.RandomSentence

    override suspend fun onWork() {
        data.createResponse(CacheTemp.getRandomSentence())
    }
}