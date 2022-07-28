import dev.kord.core.Kord
import dev.kord.core.event.message.MessageCreateEvent
import dev.kord.core.on

suspend fun main() {

   Kord(Authenticator.getToken()).apply {
       on<MessageCreateEvent> {
           if (message.content.isEmpty()) return@on
           BotApplication(this).onWork()
       }
   }.login()
}





