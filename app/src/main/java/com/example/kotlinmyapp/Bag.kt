package com.example.kotlinmyapp

class Bag(itemsCount: Int) {

    val items = arrayOfNulls<Item>(itemsCount) // I can use my nested class above here :)
    protected val secretThing = "magic pen"

    class Item(val weight: Double,val name:String) // That's a nested class. It can't the stuff of the above class

    inner class SecretItem(val code: String) {

        fun pickSecretThing(): String {
            if (code == "1234") {
                return secretThing
            } else {
                return "Hey stop right there ! You're not allow to pick the secret thing in the bag !"
            }
        }

    }
}