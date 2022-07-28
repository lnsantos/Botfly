package actions.implementations

import actions.BotAction
import data.CacheTemp
import domain.BotCommand
import dev.kord.core.entity.ReactionEmoji
import domain.SimpleDataDomain
import ext.createResponse
import ext.getChatDescription
import ext.isCommandValid

internal class VoteAction(
    private val data: SimpleDataDomain
) : BotAction {

    private val yes = ReactionEmoji.Unicode("\u2705")
    private val no = ReactionEmoji.Unicode("\u274C")

    override val command: BotCommand = BotCommand.Vote

    override suspend fun onWork() {
        if (data.isCommandValid()) {
            data.createResponse("Envie o comando na maneira correta, colocando !enquete [nome da enquete]")
            return
        }

        val survey = data.getChatDescription()

        CacheTemp.getSecretAnswers(survey)?.let {
            data.createResponse("""
                
                ${it.second}
               
                Ass:. DarkBot
            """.trimIndent())
            return
        }

        data.createResponse("\n\nIniciando enquete:\n\n$survey").apply {
            addReaction(yes)
            addReaction(no)
        }

    }
}