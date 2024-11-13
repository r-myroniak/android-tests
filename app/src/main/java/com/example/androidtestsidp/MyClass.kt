package com.example.androidtestsidp

class MyClass(private val dependency: Dependency) {
    fun doSomething(): String {
        val data = dependency.getData()
        return "processed $data"
    }

    fun doSomethingRealData(): String {
        return "real data"
    }
}