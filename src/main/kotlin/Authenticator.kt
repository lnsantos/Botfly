object Authenticator {
    
    private var token: String? = null 
    
    fun getToken(): String = token ?: System.getenv("DISCORD_TOKEN")
}