package com.example.kotlinmyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import java.util.*


open class User(val name: String, val height: Float, val age: Int) {

    protected var balance: Int = (0..1000).random() // can be accessed from child classes
    // private => only accessible by the current class
    // You can also do this with functions

    open fun hello() { // overrideable function
        println("Hello, $name !")
    }

    fun getBankAmount(): Int {
        return balance
    }

    fun bankAction(value: Int) {
        balance += value
        println("Your bank account now contains $balance")
    }

} // Parent class

class Musician(name: String, height: Float, age: Int, val instrument: String) :
    User(name, height, age) {


    override fun hello() {
        super.hello()
        println("$name is a musician.")
    }

    init {
        hello()
        println("$name can play $instrument")
    }

    fun playInstrument() {
        println("$name is playing $instrument")
    }
}

class Developer(name: String, height: Float, age: Int, val languages: Array<String>) :
    User(name, height, age) {


    override fun hello() {
        super.hello()
        println("$name is a developer.")
    }

    init {
        hello()
        println("$name can code " + Arrays.toString(languages))
    }

    fun codeAnApp() {
        val randomNumber = (0..languages.size).random()
        var selectedLanguage = languages[randomNumber]
        println("$name is currently coding a great app using $selectedLanguage")
    }

}


fun FirstLesson() {

    val fixedIntArray = Array<Int>(10) { 0 }

    val arrayOfInts = arrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    val codeLanguages = arrayOf(
        "React Native",
        "Go",
        "Python",
        "Kotlin",
        "NodeJS",
        "Angular",
        "JavaScript",
        "TypeScript"
    )

    var person1: User = User("Thomas", 1.92f, 22)

    person1 = Developer(person1.name, person1.height, person1.age, codeLanguages)
    person1.codeAnApp()
    println(person1.getBankAmount())
    person1.bankAction(500)

    person1 = Musician(person1.name, person1.height, person1.age, "guitar")
    person1.playInstrument()
    println(person1.getBankAmount())


    var myVehicle = Car()
    myVehicle.fillGasTank()

    println("Is myCar a car ? " + (myVehicle is Car).toString())

    var myDucati =
        myVehicle as? Motorcycle //Safe cast ==> will be Motorcycle if myVehicle is a Motorcycle. Else, value will be null
    myDucati?.fillGasTank() // Safe method call

} //OOP - Part 1 + basics

fun SecondLesson() {
    var FordFocus = VehicleData("Ford", "Focus", "Diesel", 5000.6)
    println(FordFocus.toString())

    var FordFiesta = FordFocus.copy(model = "Fiesta", price = 4500.0)
    println(FordFiesta.toString())

    println(FordFocus == FordFiesta)
} // OOP - Part 2 with DataClass

fun ThirdLesson() {
    val bag = Bag(5)

    val firstItem = Bag.Item(50.5,"rubber")
    bag.items[0] = firstItem
    bag.items[1] = Bag.Item(100.0,"book")
    bag.SecretItem("1234").pickSecretThing()
    println("Weight of the second item in my bag is : " + bag.items[1]?.weight)
    bag.SecretItem("1234").pickSecretThing()
} // OOP - Part 3 with Nested class and Inner class

fun FourthLesson() {
    val integers  = arrayOf(4,3,2,1)
    val strings = arrayOf("bois","my","Hi")
    println(PrintReversedArray(integers))
    println(PrintReversedArray(strings))

    val box = TheBox<String>("book")
    val thing = box.getTheThing()

    println("Box value : $thing")

    box.putTheThing("pen")
    println("Box value : ${box.getTheThing()}")


} // Generics (Function & Class)

fun FifthLesson() {

    var john = Human("John",36)
    john.nickname = "Crazy JoJo" // Lateinit var (see Human class). If nickname is not initialized, it will cause a crash

} // Lateinit (see Human class)

fun SixthLesson() {
    var robert = LivingOrganism.Human.createHuman("Robert",34) // or without .Human
    robert.nickname = "Bob"

}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ////////////////////////////////////////////////////////////////////////////////////////////////////
        SixthLesson()


    }


}
