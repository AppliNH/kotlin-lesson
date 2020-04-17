package com.example.kotlinmyapp

abstract class LivingOrganism {
    companion object Human{ // Companion object is kind of a Singleton. Name Human has nothing to do with class Human below !
        // The companion object is shared with all the instances of the class

        fun createHuman(name: String,age: Int) = Human(name,age) // Lambda TypeWriting function
    }
}

class Human (val name: String, val age:Int) {

    lateinit var nickname: String
}