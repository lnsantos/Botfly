package actions.implementations

import actions.BotAction
import data.CacheTemp
import domain.BotCommand
import domain.SimpleDataDomain
import ext.*

internal class SecretSentenceAction(
    private val data: SimpleDataDomain
) : BotAction {

    override val command: BotCommand = BotCommand.SecretSentenceAction

    override suspend fun onWork() {

        if (data.isCommandValid() && data.isValidDescription("|")) {
            data.createResponse(
                """
                Envie o comando da maneira correta, 
                colocando -> r!resposta [contem na frase] | [ resposta ]
            """.trimIndent()
            )
            return
        }

        val chatDescription = data.getChatDescription().split("|")
        val containKey = chatDescription[0]
        val answer = chatDescription[1]

        val result = CacheTemp.registerSecretAnswer(containKey, answer)

        data.createResponse(
            """
                Resposta secreta registrada com sucesso 
                
                $result
            """.trimIndent()
        )
    }
}