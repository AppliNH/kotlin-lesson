package com.example.kotlinmyapp

// Data classes only contain data
// Can't have additional markers such as "open" or "abstract"
// So they can't be inherited

// METHODS OF A DATA CLASS
// equals() will compare two object created with data class
// hashCode() generates a unique id for our data class instance, using class properties
// toString() I guess you know that one
// copy() copies an object
//
data class VehicleData(val brand: String, val model: String, val motorType: String, val price: Double) {

    // inside data class, you can override the default methods

    override fun toString(): String {
        return "brand: $brand - model: $model - motorType: $motorType - price: $price €"
    }
}
