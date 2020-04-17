package com.example.kotlinmyapp

fun <T> PrintReversedArray(array: Array<T>): String { // "T" shows that it's a generic function : it's supposed to work for any type
    var separator = ""
    var sb = StringBuilder()
    for (i in array.indices.reversed()) {
        sb.append(separator)
        sb.append(array[i])

        separator = ", "
    }
    return sb.toString()
}

class TheBox <T> (var thing: T) {// Generic class. You can also use <T : Number> so it can be any type BUT IT HAS TO BE a sub-type of Number (Int, Double, Float..)

    fun putTheThing(newItem : T) {
        thing = newItem
    }

    fun getTheThing(): T {
        return thing
    }
}


