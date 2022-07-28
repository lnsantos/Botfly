package data

object CacheTemp {

    private val sentences = arrayListOf<String>()
    private val secretAnswer = hashMapOf<String,String>()
    fun registerSentence(data: String) = sentences.add(data)
    fun registerSecretAnswer(key: String, answer: String) = secretAnswer.put(key, answer)
    fun removeSecretAnswer(key: String){
        secretAnswer.remove(key)
    }
    fun getSecretAnswers(sentence: String) : Pair<String, String>? {
        secretAnswer.forEach { data ->
            if (sentence.contains(data.key, true)){
                return data.toPair()
            }
        }
        return null
    }

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
