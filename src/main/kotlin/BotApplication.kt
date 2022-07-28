import actions.implementations.RandomSentenceAction
import actions.implementations.RegisterSentenceAction
import actions.implementations.SecretSentenceAction
import actions.implementations.VoteAction
import dev.kord.core.event.message.MessageCreateEvent
import domain.SimpleDataDomain
import ext.thisIsCommand

internal class BotApplication constructor(
    private val event: MessageCreateEvent
) {

    suspend fun onWork() {
        val descriptionsChat = event.message.content.split(" ")
        val commandChat = descriptionsChat[0]

        val simpleDomain = SimpleDataDomain(descriptionsChat, event.message)

        arrayListOf(
            VoteAction(simpleDomain),
            RegisterSentenceAction(simpleDomain),
            RandomSentenceAction(simpleDomain),
            SecretSentenceAction(simpleDomain)
        ).run {
            firstOrNull { it.command thisIsCommand commandChat }?.onWork()
        } ?: println("Command $commandChat not implemented! ;-;")
    }

}