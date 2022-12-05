fun main() {

    val input = readInput("Day01")

    val listOfTotalCalories: MutableList<Int> = arrayListOf()

    var i = 0
    var elfCalories = 0

    do {
        if (input[i] == "") {
            listOfTotalCalories.add(elfCalories)
            elfCalories = 0
        } else {
            elfCalories += input[i].toInt()
        }
        i++
    } while (i < input.size)

    var elfWithMoreCalories = listOfTotalCalories.indices.maxByOrNull { listOfTotalCalories[it] }

    println(String.format("The elf with the most calories is the %d, with a total of %d calories", elfWithMoreCalories, listOfTotalCalories[elfWithMoreCalories!!]))

    val topThreeWithMostCalories: MutableList<Int> = arrayListOf()

    for (x in 0..2) {
        topThreeWithMostCalories.add(listOfTotalCalories[elfWithMoreCalories!!])
        listOfTotalCalories.removeAt(elfWithMoreCalories)
        elfWithMoreCalories = listOfTotalCalories.indices.maxByOrNull { listOfTotalCalories[it] }
        println(elfWithMoreCalories)
    }

    var totalCaloriesTop3 = 0

    for (topElf in topThreeWithMostCalories){
        totalCaloriesTop3 += topElf
    }

    println(String.format("The top three elf with the most calories has a total of %d calories", totalCaloriesTop3))



}
