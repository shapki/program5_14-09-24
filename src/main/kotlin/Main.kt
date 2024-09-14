fun main() {
    // Создать приложение, в котором пользователь вводит массив из различных слов. На выходе приложение должно показать слова сгруппированные по признаку "состоят из одинаковых букв". Например, на входе ["eat, "tea", "tan", "ate", "nat", "bat"]. Получаем группы:
    // "ate", "eat", "tea"
    // "nat", "tan"
    // "bat"

    println("Слова через пробел:")
    val words = readln().split(" ")
    val grWords = grWordsFun(words)

    println("Группы:")
    grWords.forEach { group -> println(group.joinToString(", ")) }
}

fun grWordsFun(words: List<String>): List<List<String>> {
    val grWords = mutableListOf<MutableList<String>>()
    val wordsGr = mutableMapOf<String, MutableList<String>>()

    for(word in words){
        val sortWord = word.toCharArray().sortedArray().joinToString("")
        if(sortWord in wordsGr){
            wordsGr[sortWord]!!.add(word)
        }else{
            wordsGr[sortWord] = mutableListOf(word)
        }
    }

    wordsGr.values.forEach{ grWords.add(it) }

    return grWords
}