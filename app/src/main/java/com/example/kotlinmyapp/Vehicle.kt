package com.example.kotlinmyapp


// Abstract class = a concept, which can be used to init an object
// Ex : a vehicle could be a parent abstract class. You could inherit from it to create a Car class, Moto class etc..

// Btw, you can also define an abstract function.
// An abstract function doesn't have any body, the body NEEDS to be defined by the children class, using override fun ..

// ex:

// In parent class => abstract fun pouet()
// In children class ==> override fun pouet() { return "pouet pouet"}


abstract class Vehicle(val numberOfWheels: Int) {

    abstract fun honk()
}

interface Trick { // You can use it on the classes, so they can use wheeling. But they'll have to define its body !
    // You can also use var trick: Trick = Motorcycle() because Motorcycle class uses the interface Trick
    // However you'll only be able to use wheeling and Motorcycle methods
    fun wheeling()
}

interface Fuel {
    var fuelGauge: Double // Needs to be overrided by children

    fun fillGasTank() {
        println("Filling the gas tank..")
        fuelGauge = 100.0
    }
}

class Car : Vehicle(4), Fuel {

    override var fuelGauge: Double = 0.0

    override fun honk() {
        println("Pouet !")
    }

    // Let's override fillGasTank so we can have a honk with the gas tank is fulled

    override fun fillGasTank() {
        super.fillGasTank() // calls the initial code of fillGasTank
        honk()
    }
}

class Motorcycle : Vehicle(2), Trick, Fuel {

    override var fuelGauge: Double = 0.0

    override fun honk() {
        println("Tsouin !")
    }

    override fun wheeling() {
        println("Motorcycle does a wheeling ! Insane :o")
    }
}

class Bicycle : Vehicle(2), Trick {

    override fun honk() {
        println("Ting !")
    }

    override fun wheeling() {
        println("Bicycle does a wheeling ! MAD LAD !!!!!!!!!!")
    }
}
