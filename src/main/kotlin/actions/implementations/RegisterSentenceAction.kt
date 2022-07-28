package actions.implementations

import actions.BotAction
import data.CacheTemp
import dev.kord.core.entity.ReactionEmoji
import domain.BotCommand
import domain.SimpleDataDomain
import ext.createResponse
import ext.getChatDescription
import ext.isCommandValid

internal class RegisterSentenceAction constructor(
    private val data: SimpleDataDomain
) : BotAction {

    override val command: BotCommand = BotCommand.RegisterSentence

    override suspend fun onWork() {

        if (data.isCommandValid()) {
            data.createResponse("Envie o comando na maneira correta, colocando r!frase [frase desejada]")
            return
        }

        val description = data.getChatDescription()

        if (CacheTemp.registerSentence(description)) {
            data.createResponse("\n\n Frase registrada com sucesso!").run {
                addReaction(ReactionEmoji.Unicode(":6781bongocattummy:"))
                addReaction(ReactionEmoji.Unicode(":9190bongocathyper:"))
            }
        }

    }
}