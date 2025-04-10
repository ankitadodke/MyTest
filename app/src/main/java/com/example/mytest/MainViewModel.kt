package com.example.mytest

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    // Sample data for images carousel
    val imageUrls = listOf(
        "https://picsum.photos/id/1/800/800",
        "https://picsum.photos/id/10/800/800",
        "https://picsum.photos/id/100/800/800",
        "https://picsum.photos/id/1000/800/800"
    )

    val listData = listOf(
        listOf("Apple", "Banana", "Cherry", "Date", "Elderberry", "Fig", "Grape", "Honeydew",
            "Imbe", "Jackfruit", "Kiwi", "Lemon", "Mango", "Nectarine", "Orange", "Papaya",
            "Quince", "Raspberry", "Strawberry", "Tangerine", "Ugli fruit", "Voavanga",
            "Watermelon", "Xigua", "Yangmei"),
        listOf("Almond", "Brazil nut", "Cashew", "Chestnut", "Coconut", "Hazelnut", "Macadamia",
            "Peanut", "Pecan", "Pistachio", "Walnut", "Pine nut", "Almond", "Brazil nut",
            "Cashew", "Chestnut", "Coconut", "Hazelnut", "Macadamia", "Peanut", "Pecan",
            "Pistachio", "Walnut", "Pine nut", "Almond"),
        listOf("Asparagus", "Broccoli", "Carrot", "Daikon", "Eggplant", "Fennel", "Garlic",
            "Horseradish", "Iceberg lettuce", "Jalapeño", "Kale", "Leek", "Mushroom",
            "Nori", "Onion", "Potato", "Quinoa", "Radish", "Spinach", "Turnip", "Ube",
            "Valerianella", "Watercress", "Xigua", "Yam")
    )

    fun calculateStatistics(list: List<String>): Map<String, Any> {
        val charFrequency = mutableMapOf<Char, Int>()
        list.forEach { item ->
            item.lowercase().filter { it.isLetter() }.forEach { char ->
                charFrequency[char] = charFrequency.getOrDefault(char, 0) + 1
            }
        }

        val topChars = charFrequency.entries.sortedByDescending { it.value }.take(3)
        return mapOf(
            "count" to list.size,
            "topChars" to topChars.map { it.key to it.value }
        )
    }
}