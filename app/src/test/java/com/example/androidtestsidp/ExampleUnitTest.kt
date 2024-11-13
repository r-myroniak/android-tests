package com.example.androidtestsidp

import io.mockk.every
import io.mockk.mockk
import io.mockk.spyk
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun `test addition`() {
        val result = add(2, 3)
        assertEquals(5, result)
    }

    private fun add(a: Int, b: Int): Int {
        return a + b
    }

    @Test
    fun `test doSomething`() {
        val dependencyMock = mockk<Dependency>()
        every { dependencyMock.getData() } returns "mocked data"
        val myClass = MyClass(dependencyMock)
        val result = myClass.doSomething()
        assertEquals("processed mocked data", result)
    }

    @Test
    fun `test doSomething real`() {
        val dependencyMock = mockk<Dependency>()
        val myClassSpy = spyk(MyClass(dependencyMock))
        val result = myClassSpy.doSomething()
        assertEquals("real data", result)
    }
}