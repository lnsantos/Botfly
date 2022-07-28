package data

object CacheTemp {

    private val sentences = arrayListOf<String>()

    fun registerSentence(data: String) = sentences.add(data)

    fun getRandomSentence() : String {

        if (sentences.isEmpty()) {
            return """
                Não encontramos nenhuma frase cadastrada,
                para adicionar uma frase digite [ r!frase 'Conteúdo'] 
            """.trimIndent()
        }

        return sentences.random()
    }
}
