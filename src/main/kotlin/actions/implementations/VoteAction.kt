package actions.implementations

import actions.BotAction
import domain.BotCommand
import dev.kord.core.entity.ReactionEmoji
import domain.SimpleDataDomain
import ext.createResponse
import ext.getChatDescription


internal class VoteAction(
    private val data: SimpleDataDomain
) : BotAction {

    private val yes = ReactionEmoji.Unicode("\u2705")
    private val no = ReactionEmoji.Unicode("\u274C")

    override val command: BotCommand = BotCommand.Vote

    override suspend fun onWork() {
        if (data.messageSplit.size < 2) {
            data.messageData.channel.createMessage("Envie o comando na maneira correta, colocando !enquete [nome da enquete]")
            return
        }

        val survey = data.getChatDescription()
        val response = data.createResponse("\n\nIniciando enquete: $survey")

        response.addReaction(yes)
        response.addReaction(no)
    }
}